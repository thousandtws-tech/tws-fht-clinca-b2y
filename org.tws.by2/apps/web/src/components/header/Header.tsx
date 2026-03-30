import { ButtonEnter } from "../buttons/Enter"
import { ButtonRegister } from "../buttons/Registrer"

import { useEffect, useRef } from "react";
import { animateHeader } from "./animation/Header";


export function Header() {

    const ref = useRef(null);

    useEffect(() => {
    const cleanup = animateHeader(ref);
    return cleanup;
    }, []);

    return(
        <header ref={ref}>
            <div className="sticky top-0 w-full z-9 bg-white flex items-center justify-between shadow p-6">
                <a href="/"><img className="header-logo area w-30" src="/svgs/logo-fht.svg" alt="" /></a>

                <ul className="flex items-center text-[12px] gap-5">
                    <ButtonEnter to="/login">Entre</ButtonEnter>
                    <ButtonRegister to="/register">Cadastre-se</ButtonRegister>
                </ul>
            </div>
        </header>
    ) 

}