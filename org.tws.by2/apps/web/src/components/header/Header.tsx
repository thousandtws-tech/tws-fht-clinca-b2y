export function Header() {
    return(
        <header className=" sticky top-0 w-full z-9 bg-white flex items-center justify-between shadow p-6">
            <img className="w-30" src="/svgs/logo-fht.svg" alt="" />

            <ul className="flex items-center gap-5">
                <li className="hover:cursor-pointer">Registre-se</li>
                <li className="px-5 py-1 rounded-[7px] bg-blueFHT text-white shadow-2xl hover:cursor-pointer">Entrar</li>
            </ul>
        </header>
    ) 

}