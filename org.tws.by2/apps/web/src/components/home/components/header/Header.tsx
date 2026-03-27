import { gsap } from "gsap"
import { useEffect } from "react"

export function Header() {


  useEffect(() => {
    const tl = gsap.timeline();

    tl.fromTo(".logo",
    { x: -300, opacity: 0 },
    { x: 0, opacity: 1, duration: 1 }
    )
    .fromTo(".nav-item",
    { x: 300, opacity: 0 },
    { x: 0, opacity: 1, duration: 1, stagger: 0.2 },
    "-=0.5"
    );    // começa antes da anterior terminar

  }, []);



    return(
        <header>
            <div className="sticky top-0 w-full z-9 bg-white flex items-center justify-between shadow p-6">
                <img className="logo area w-30" src="/svgs/logo-fht.svg" alt="" />

                <ul className="flex items-center text-[12px] gap-5">
                    <li className="hover:cursor-pointer inline-flex items-center justify-center gap-2 whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 [&_svg]:pointer-events-none [&_svg]:size-4 [&_svg]:shrink-0 hover:bg-accent h-10 px-4 py-2 text-blue-600 hover:text-blue-700">Entrar</li>
                    <li className="hover:cursor-pointer inline-flex items-center justify-center gap-2 whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 [&_svg]:pointer-events-none [&_svg]:size-4 [&_svg]:shrink-0 h-10 py-2 bg-blue-600 hover:bg-blue-700 text-white px-6">Cadastre-se</li>
                </ul>
            </div>
        </header>
    ) 

}