import logo from "../../assets/svgs/logo-fht.svg"

export function Terms() {
    return(
        <div className="min-h-screen flex flex-col bg-linear-to-r from-blue-50 to-white dark:from-gray-800 dark:to-gray-900 text-gray-800 dark:text-white transition-colors duration-300">
           <header className="w-full p-6 flex items-center justify-center">
                <a href="/"><img src={logo} alt="" /></a>
           </header>
           <main className="flex flex-col items-center justify-center flex-1 px-6">
                <div className="max-w-3xl text-center">
                    <h2 className="text-4xl font-bold mb-4">Termos de Uso</h2>
                    <p className="text-lg text-gray-700 dark:text-gray-300 mb-6" >Ao utilizar a plataforma FHT, você concorda com os nossos termos e condições. Leia atentamente as regras abaixo
                    </p>
                    <div className="text-left bg-white dark:bg-gray-800 p-6 rounded-xl shadow-md space-y-4">
                        <p><span className="font-bold">1. Uso da Plataforma:</span> O acesso e uso são destinados a médicos e hospitais devidamente cadastrados.</p>
                        <p><span className="font-bold">2. Privacidade:</span> Seus dados são protegidos conforme nossa <a href="/politica">Política de Privacidade</a>.</p>
                        <p><span className="font-bold">3. Responsabilidades:</span> Cada usuário é responsável pelas informações fornecidas e pelo cumprimento dos compromissos acordados.</p>
                        <p><span className="font-bold">4. Alterações:</span> A FHT pode alterar estes termos, sendo responsabilidade do usuário revisá-los periodicamente.</p>
                    </div>
                    {/* Concordando com os termos */}
                    <div className="mt-6 flex items-center gap-4">
                        <input type="checkbox" className="w-5 h-5 rounded border-gray-300 dark:border-gray-600" name="" id="" />
                        <p>Declaro que li e aceito os Termos de Uso e a <a href="/politica" className="underline">Política de Privacidade.</a></p>
                    </div>
                    
                <button className="mt-6 inline-flex items-center justify-center gap-2 whitespace-nowrap text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 [&_svg]:pointer-events-none [&_svg]:size-4 [&_svg]:shrink-0 h-10 bg-blue-600 hover:bg-blue-700 text-white px-6 py-3 rounded-xl"><a href="/">Voltar Para Pagina Inicial</a></button>
                </div>
           </main>
           <footer className="mt-10 text-sm bg-blue-700 text-white text-center py-6">© 2025 FHT Soluções Hospitalares. Todos os direitos reservados.</footer>
        </div>
    )
}