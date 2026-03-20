# Módulo Auth - Documentação das APIs

Esta documentação descreve as rotas de autenticação expostas em `AuthResource`, integradas ao Keycloak e com persistência das entidades locais (`jhi_user`, `user_account`, `doctor_profile`, `hospital_profile`).

## Base path

Todas as rotas estão sob:

- `/api/auth`

No `SecurityConfiguration`, esse prefixo está liberado com `permitAll` para permitir login/cadastro sem token prévio.

## Visão geral da arquitetura

### Componentes principais

- **`AuthResource`**: recebe as requisições HTTP e delega para a camada de serviço.
- **`AuthOrchestrationService`**: orquestra fluxo reativo de cadastro e login com consistência entre Keycloak e banco local.
- **`KeycloakAuthService`**: integração com Keycloak (login por senha, criação/remoção de usuário, atribuição de role).

### Fluxo de cadastro (alto nível)

1. Validar duplicidades locais (ex.: e-mail e CNPJ).
2. Criar usuário no Keycloak.
3. Atribuir role de realm (`ROLE_USER`, `ROLE_DOCTOR`, `ROLE_HOSPITAL`).
4. Criar usuário local em `jhi_user` (+ authority), para atender FKs.
5. Persistir `user_account` e perfil específico (`doctor_profile` ou `hospital_profile`).
6. Autenticar no Keycloak (`grant_type=password`) e retornar token.
7. Em falha local após criação no Keycloak, executar rollback no IdP (deleção do usuário).

## Endpoints

---

### POST `/api/auth/login`

Autentica um usuário existente no Keycloak e retorna o token.

#### Request body

```json
{
  "username": "medico@teste.com",
  "password": "123456"
}
```

#### Response (200 OK)

Formato de resposta contendo token e metadados da autenticação.

Exemplo:

```json
{
  "accessToken": "<jwt>",
  "refreshToken": "<refresh-token>",
  "tokenType": "Bearer",
  "expiresIn": 300,
  "refreshExpiresIn": 1800
}
```

#### Erros comuns

- `401 Unauthorized`: credenciais inválidas.
- `5xx`: falha de integração com Keycloak.

---

### POST `/api/auth/register/user`

Cadastra um usuário padrão, cria dados locais e autentica ao final.

#### Request body

```json
{
  "email": "user@teste.com",
  "password": "123456",
  "displayName": "Usuario Teste",
  "userType": "USER",
  "status": "ACTIVE",
  "documentVerificationStatus": "APPROVED",
  "activated": true
}
```

#### Regras aplicadas

- Validação de e-mail duplicado (base local).
- Criação de usuário no Keycloak.
- Atribuição de role `ROLE_USER`.
- Criação em `jhi_user` + authorities.
- Criação de `user_account`.
- Login automático para retorno do token.

#### Response (201 Created / 200 OK, conforme implementação)

Retorna token e identificadores criados no processo.

Exemplo:

```json
{
  "accessToken": "<jwt>",
  "refreshToken": "<refresh-token>",
  "tokenType": "Bearer",
  "expiresIn": 300,
  "userId": 10,
  "userAccountId": 25
}
```

#### Erros comuns

- `409 Conflict`: e-mail já cadastrado.
- `5xx`: erro ao persistir entidades locais ou falha no Keycloak.

---

### POST `/api/auth/register/doctor`

Cadastra médico com perfil profissional, cria dados locais e autentica ao final.

#### Request body

```json
{
  "email": "doctor@teste.com",
  "password": "123456",
  "displayName": "Dra Maria",
  "professionalCrm": "12345",
  "crmState": "SP",
  "desiredHourlyRate": 250.0,
  "approvalStatus": "PENDING"
}
```

#### Regras aplicadas

- Validação de e-mail duplicado.
- Criação no Keycloak + role `ROLE_DOCTOR`.
- Criação de `jhi_user` + authorities.
- Criação de `user_account`.
- Criação de `doctor_profile`.
- Login automático para retorno do token.

#### Response (201 Created / 200 OK, conforme implementação)

Exemplo:

```json
{
  "accessToken": "<jwt>",
  "refreshToken": "<refresh-token>",
  "tokenType": "Bearer",
  "expiresIn": 300,
  "userId": 11,
  "userAccountId": 26,
  "doctorProfileId": 7
}
```

#### Erros comuns

- `409 Conflict`: e-mail já cadastrado.
- `5xx`: erro de integração/persistência.

---

### POST `/api/auth/register/hospital`

Cadastra hospital com perfil institucional, cria dados locais e autentica ao final.

#### Request body

```json
{
  "email": "hospital@teste.com",
  "password": "123456",
  "displayName": "Hospital Central",
  "tradeName": "Hospital Central",
  "legalName": "Hospital Central SA",
  "cnpj": "12345678000199",
  "phone": "11999999999",
  "address": "Rua X, 123"
}
```

#### Regras aplicadas

- Validação de e-mail duplicado.
- Validação de CNPJ duplicado (`HospitalProfileRepository.findOneByCnpj`).
- Criação no Keycloak + role `ROLE_HOSPITAL`.
- Criação de `jhi_user` + authorities.
- Criação de `user_account`.
- Criação de `hospital_profile`.
- Login automático para retorno do token.

#### Response (201 Created / 200 OK, conforme implementação)

Exemplo:

```json
{
  "accessToken": "<jwt>",
  "refreshToken": "<refresh-token>",
  "tokenType": "Bearer",
  "expiresIn": 300,
  "userId": 12,
  "userAccountId": 27,
  "hospitalProfileId": 5
}
```

#### Erros comuns

- `409 Conflict`: e-mail ou CNPJ já cadastrados.
- `5xx`: erro de integração/persistência.

## Rollback e consistência de dados

Se a criação no Keycloak ocorrer com sucesso, mas houver falha na persistência local, o serviço executa rollback no Keycloak removendo o usuário recém-criado. Esse comportamento reduz risco de inconsistência entre IdP e base local.

## Repositórios ajustados

- `UserAccountRepository`: `findOneByEmail`
- `HospitalProfileRepository`: `findOneByCnpj`

## Configuração necessária (Keycloak)

Exemplo de chaves adicionadas em `application-secret-samples.yml`:

```yaml
application:
  security:
    keycloak:
      realm: <seu-realm>
      admin-client-id: <client-admin-id>
      admin-client-secret: <client-admin-secret>
```

### Pré-requisitos no realm

- Client com **Direct Access Grants** habilitado para login por senha.
- Credenciais válidas para uso da **Admin API** (gerenciar usuários e roles), no mesmo client ou client administrativo dedicado.
- Roles de realm existentes com os nomes exatos:
  - `ROLE_USER`
  - `ROLE_DOCTOR`
  - `ROLE_HOSPITAL`

## Testes e validação recomendados

### Build

```bash
./mvnw -DskipTests compile
```

### Cenários mínimos de teste

- Login com credencial válida e inválida.
- Cadastro `user` com sucesso e conflito de e-mail.
- Cadastro `doctor` com sucesso e conflito de e-mail.
- Cadastro `hospital` com sucesso, conflito de e-mail e conflito de CNPJ.
- Falha proposital de persistência local para validar rollback no Keycloak.
