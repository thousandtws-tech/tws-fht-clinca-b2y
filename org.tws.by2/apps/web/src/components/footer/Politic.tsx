import {Link} from "react-router-dom";

export function Politic() {
    return(
        <div className="min-h-screen flex flex-col bg-linear-to-br from-white to-blue-50 dark:from-gray-900 dark:to-gray-800 text-gray-800 dark:text-white">
            <main className="flex-1 container mx-auto px-6 py-12 max-w-3xl">
                <h2 className="text-4xl font-bold mb-6">Politica de Privacidade</h2>
                <p>A sua privacidade é importante para nós. Esta política descreve como a FHT Soluções Hospitalares coleta, usa e protege suas informações.</p>
                <section className="space-y-6 text-base leading-relaxed">
                    <div>
                        <h2 className="text-xl font-semibold mb-2">1. Coleta de Informações</h2>
                        <p>Coletamos informações fornecidas por você no momento do cadastro, como nome, e-mail, CRM e especialidade médica, bem como dados de uso da plataforma.</p>
                    </div>
                    <div>
                        <h2 className="text-xl font-semibold mb-2">2. Uso das Informações</h2>
                        <p>Utilizamos os dados para oferecer uma experiência personalizada, facilitar a contratação de plantões e melhorar continuamente nossos serviços.</p>
                    </div>
                    <div>
                        <h2 className="text-xl font-semibold mb-2">3. Compartilhamento de Dados</h2>
                        <p>Seus dados poderão ser compartilhados com hospitais e clínicas parceiras mediante sua autorização e somente para fins operacionais da plataforma.</p></div>
                    <div>
                        <h2 className="text-xl font-semibold mb-2">4. Segurança</h2>
                        <p>Utilizamos medidas técnicas e organizacionais para proteger seus dados contra acesso não autorizado, perda ou alteração.</p>
                    </div>
                    <div>
                        <h2 className="text-xl font-semibold mb-2">5. Direitos do Usuário</h2>
                        <p>Você tem o direito de acessar, corrigir ou excluir seus dados pessoais. Para isso, entre em contato conosco pelo e-mail <strong>privacidade@fht.com.br</strong>.</p>
                    </div>
                    <div>
                        <h2 className="text-xl font-semibold mb-2">6. Atualizações</h2>
                        <p>Esta política poderá ser atualizada periodicamente. As alterações serão comunicadasa através da plataforma.</p>
                    </div>
                </section>
                <div>
                    <Link className="hover:cursor-pointer inline-flex items-center justify-center gap-2 whitespace-nowrap text-sm font-medium ring-offset-background transition-colors bg-blue-600 hover:bg-blue-700 text-white px-6 py-3 rounded-xl" to="/">Voltar para a Pagina Inicial</Link>
                </div>
            </main>
            <footer className="bg-blue-700 text-white text-sm text-center py-6">© 2025 FHT Soluções Hospitalares. Todos os direitos reservados.</footer>
        </div>
    )
}