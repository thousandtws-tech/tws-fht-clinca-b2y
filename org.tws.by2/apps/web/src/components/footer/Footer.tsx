
export function Footer() {
    return(
        <footer className="text-white bg-blueFHT text-center flex flex-col lg:flex-row justify-center items-center gap-2 py-2">
            <p className="text-sm">© 2025 FHT Soluções Hospitalares - Todos os direitos reservados.</p>
            <ul className="a text-sm flex gap-4">
                <li className="hover:underline hover:cursor-pointer"><a href="/sobre">Sobre Nós</a></li>
                <li className="hover:underline hover:cursor-pointer"><a href="/contato">Contato</a></li>
                <li className="hover:underline hover:cursor-pointer"><a href="/termos">Termos de Uso</a></li>
                <li className="hover:underline hover:cursor-pointer"><a href="/politica">Política de Privacidade</a></li>
            </ul>
        </footer>
    )
}