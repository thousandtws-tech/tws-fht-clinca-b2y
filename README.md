# FHT Clínica

A **FHT Clínica** é uma plataforma de gestão e operação para instituições de saúde, conectando hospitais, clínicas e profissionais da saúde em um ecossistema digital completo.

## Proposta
A plataforma foi idealizada para automatizar a contratação, alocação e operação de profissionais de saúde, reduzindo atritos operacionais e aumentando a eficiência da gestão hospitalar.  
  
Além disso, permite que hospitais organizem suas equipes internas e acompanhem toda a jornada de atendimento do paciente, desde a recepção até a finalização do atendimento médico.

## Colaboradores

- **Sócio:** Leonardo
- **CEO:** Vinicius Thousands
- **Desenvolvedor:** Herberth
- **Desenvolvedor:** Victor

## Módulos

Atualmente, o projeto possui ou prevê os seguintes módulos:

- Cadastro de pacientes
- Cadastro de médicos e profissionais
- Agendamento de consultas
- Match inteligente entre hospitais e profissionais
- Gestão de contratação e aceite digital  
- Geração de contratos em PDF  
- Back-office operacional  
- Check-in e check-out com Face ID  
- Gestão de equipes hospitalares  
- Prontuário eletrônico e fluxo assistencial  
- Portal de telemedicina


## Stack

> 
- **Frontend:** React 
- **Backend:** Java, SpringBoot, WebFlux
- **Banco de Dados:** PostgreSQL, R2DBC
- **Autenticação:** OAuth, JWT, RBAC
- **DevOps:** Docker
- **Upload Documentos:** Cloudinary, Mux
- **Sistema de Pagamento:** Strip

## Estrutura Inicial do Projeto

```txt
fht-clinica/  
├── apps/  
│   ├── client/  
│   └── server/  
├── infra/  
│   └── docker/  
├── docs/  
├── .gitignore  
└── README.md
```

## Status do Projeto

🚧 Em desenvolvimento


## Análise de Requisitos

### Requisitos funcionais

#### 1. Match entre hospital e profissional
```
O hospital publica sua necessidade informando, por exemplo:  
  
- especialidade requerida  
- dias de trabalho  
- faixa de horário  
- região de atuação  
- valor pago por hora  
  
O profissional de saúde cadastra:  
  
- especialidade  
- disponibilidade  
- faixa de horário  
- região de interesse  
- valor desejado por hora  
  
A plataforma realiza automaticamente o cruzamento dessas informações e identifica os matches compatíveis entre demanda e oferta.
```
### 2. Inteligência de margem da plataforma  
  ```
Quando existe compatibilidade entre hospital e profissional, a plataforma também analisa os valores envolvidos.  
  
Exemplo:  
  
- o profissional solicita `R$ 100/hora`  
- o hospital paga `R$ 150/hora`  
  
Nesse cenário, a plataforma identifica automaticamente a margem operacional de `R$ 50/hora`, repassando o valor acordado ao profissional e retendo a margem da operação.
```
### 3. Fluxo de aceite e contratação  
  ```
Após o match:  
  
1. o hospital visualiza o profissional compatível  
2. o hospital realiza o aceite  
3. o profissional recebe os detalhes da oportunidade  
4. o profissional visualiza contrato, local e condições  
5. o profissional realiza o aceite  
6. a plataforma gera automaticamente o contrato em PDF  
7. as assinaturas são coletadas digitalmente  
8. o contrato segue para validação no back-office  
  ```
### 4. Back-office operacional  
  ```
O sistema possui uma camada administrativa responsável por acompanhar e validar:  
  
- matches realizados  
- valores negociados  
- termos de aceite  
- contratos gerados  
- aprovações finais da operação  
 
Após a validação do back-office, o profissional passa a operar vinculado à estrutura institucional do hospital contratante.  
   ```
### 5. Vinculação operacional ao hospital  
  ```
Depois da aprovação:  
  
- o profissional passa a atuar sob o guarda-chuva do hospital contratante  
- sua jornada operacional fica vinculada à instituição  
- ele passa a fazer parte da estrutura funcional daquela unidade  
  ```
### 6. Check-in e check-out com Face ID  
  ```
Durante a operação, o profissional realiza:  
  
- check-in no início do expediente  
- check-out no encerramento do expediente  
  
Esse processo é validado por **Face ID**, aumentando a segurança operacional e o controle de presença.  
  ```
### 7. Gestão interna por roles  
  ```
Dentro do hospital, o administrador pode estruturar a equipe e configurar acessos por perfil.  
  
Exemplos de perfis:  
  
- recepcionista  
- enfermeiro(a)  
- médico(a)  
- atendimento  
- administrativo  
- limpeza/faxina  
- gestão hospitalar  
  
Cada role possui sua própria dashboard e permissões de uso no sistema.  
  ```
### 8. Fluxo assistencial do paciente  
```
A plataforma também cobre o fluxo operacional do paciente dentro da unidade de saúde.  
  
Fluxo previsto:  
  
1. recepção do paciente  
2. chamada para atendimento  
3. geração de ficha  
4. criação/consulta de prontuário eletrônico  
5. geração de etiqueta de identificação  
6. encaminhamento para triagem  
7. atendimento de enfermagem  
8. encaminhamento ao médico  
9. finalização do atendimento  
  
Esse fluxo já se encontra estruturado e funcional, restando etapas de validação e refinamento.  
```
### 9. Portal de telemedicina  
```
A solução também conta com um portal de telemedicina.  
  
Nesse módulo:  
  
- o paciente informa a especialidade desejada  
- escolhe o horário de atendimento  
- visualiza os médicos disponíveis  
- seleciona o profissional  
- entra na fila de atendimento  
- realiza a consulta online com o médico  
  
Esse portal amplia o alcance da plataforma, permitindo atendimentos remotos de forma prática e organizada.

- O sistema deve permitir autenticação de usuários
- O sistema deve permitir diferentes níveis de acesso
- O sistema deve possibilitar o cadastro de pacientes
- O sistema deve possibilitar o cadastro de medicos
- O sistema deve permitir o agendamento de consultas
- O sistema deve gerar relatórios administrativos
```
### Requisitos não funcionais

- Segurança no armazenamento de dados
- Interface intuitiva e de fácil utilização
- Desempenho adequado para uso diário
- Escalabilidade para novos módulos
- Compatibilidade com mobile e desktop

## Regras de Negócio

Algumas regras centrais da plataforma:
- o match entre hospital e profissional deve considerar especialidade, disponibilidade, horário, região e valor
- a plataforma deve calcular automaticamente a margem entre valor ofertado e valor solicitado
- o aceite das partes deve gerar contrato digital
- contratos devem ser enviados para validação administrativa
- profissionais aprovados passam a operar vinculados ao hospital contratante
- registros de entrada e saída devem ser controlados por Face ID
- usuários devem acessar dashboards conforme suas roles
- o fluxo assistencial deve registrar a jornada completa do paciente
- a telemedicina deve permitir agendamento e atendimento remoto

## Documentao

- Arquitetura
- Diagramas
- Fluxogramas
- Estrutura dos módulos

## Licensa 
Apache License
