
/* Animações */
import { useEffect, useRef } from "react";
import { animateHero } from "../animations/Hero";
import { Link } from "react-router-dom";

/* imagens */
import doctorPng from "../../../assets/pngs/doctor.png"
import EffectPng from "../../../assets/pngs/Effect.png"
import logo from "../../../assets/svgs/logo-fht.svg"


export function Hero() {

    const ref = useRef(null);

    useEffect(() => {
        const cleanup = animateHero(ref);
        return cleanup;
    }, []);

    return (
        <main ref={ref} className="flex items-center justify-center">
            <div className=" h-auto relative flex flex-col pb-30 px-6 pt-10">
                <a href="/">
                    <img src={EffectPng} className="example hidden lg:block absolute z-[-99] bg-cover right-0" alt="" />
                </a>
                {/* Primeira Aba */}
                <div className="flex flex-col lg:flex-row justify-between items-center">
                    <div className=" flex flex-col lg:w-1/2 gap-6 ">
                        <h1 className="hero-title text-3xl lg:text-4xl font-semibold text-lightGrayFHT">Conectamos médicos e hospitais com eficiência</h1>
                        <p className="hero-subtitle font-light text-lightGrayFHT">
                            A plataforma perfeita para automatizar a contratação, alocação e operação
                            de profissionais de saúde, 
                            reduzindo atritos operacionais e aumentando a eficiência da gestão hospitalar.
                        </p>
                        <div className="py-3">
                            <Link to="/register" className="hero-cadastro max-w-50 z-[-99] gap-2 px-4 py-3 rounded-md flex items-center justify-center bg-blue-600 text-white shadow-2xl hover:cursor-pointer"> 
                                Comece Agora
                                <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" className="lucide lucide-arrow-right h-4 w-4"><path d="M5 12h14"></path><path d="m12 5 7 7-7 7"></path></svg>
                            </Link>
                        </div>

                    </div>
                    <div>
                        <img className="hero-image w-90 lg:block" src={doctorPng} alt="" />
                    </div>
                </div>

                <div className="hero-card z-100 flex flex-row items-center justify-between px-6 max-w-screen h-30 bg-white shadow-2xl"> 
                    <div>
                        <h2 className="text-3xl font-medium"><span className="text-blueFHT">+</span>500</h2>
                        <p>Profissionais Conectados</p>
                    </div>
                    <div>
                        <h2 className="text-3xl font-medium"><span className="text-blueFHT">+</span>1800</h2>
                        <p>Contratações Automatizadas</p>
                    </div>
                    <div>
                        <h2 className="text-3xl font-medium"><span className="text-blueFHT">-</span>25%</h2>
                        <p>Redução de custos</p>
                    </div>

                    <div className="hidden lg:block">
                        <img className="w-40" src={logo} alt="" />
                    </div>
                </div>
            </div>
        </main>
    )
}
