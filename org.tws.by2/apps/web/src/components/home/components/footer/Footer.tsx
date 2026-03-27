
export function Footer() {
    return(
        <footer className="h-15 text-white bg-[#3b5be4] text-center flex flex-col lg:flex-row justify-center items-center gap-5">
            <p className="text-sm">© 2025 FHT Soluções Hospitalares - Todos os direitos reservados.</p>
            <ul className="a text-[13px] flex gap-4">
                <li className="hover:underline hover:cursor-pointer"><a href="/sobre">Sobre Nós</a></li>
                <li className="hover:underline hover:cursor-pointer"><a href="/contato">Contato</a></li>
                <li className="hover:underline hover:cursor-pointer"><a href="/termos">Termos</a></li>
                <li className="hover:underline hover:cursor-pointer"><a href="/politica">Politica de privacidade</a></li>
            </ul>
        </footer>
    )
}