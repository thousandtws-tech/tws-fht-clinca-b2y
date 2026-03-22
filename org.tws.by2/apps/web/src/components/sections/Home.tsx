export function Home() {
    return (
        <main className="flex items-center justify-center">
            <div className=" h-auto relative flex flex-col pb-30 px-6 pt-10">
                <img src="/Effect.png" className="hidden lg:block absolute z-[-99] bg-cover right-0" alt="" />
                {/* Primeira Aba */}
                <div className="flex flex-col lg:flex-row justify-between items-center">
                    <div className="flex flex-col lg:w-1/2 gap-6 ">
                        <h1 className="text-3xl lg:text-4xl font-semibold text-lightGrayFHT">Conectamos médicos e hospitais com eficiência</h1>
                        <p className="font-light text-lightGrayFHT">
                            A plataforma perfeita para automatizar a contratação, alocação e operação
                            de profissionais de saúde, 
                            reduzindo atritos operacionais e aumentando a eficiência da gestão hospitalar.
                        </p>
                        <div className="py-3">
                            <button className="gap-2 px-4 py-2 rounded-xl flex items-center justify-center bg-blueFHT text-white shadow-2xl hover:cursor-pointer"> 
                                Comece Agora
                                <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" className="lucide lucide-arrow-right h-4 w-4"><path d="M5 12h14"></path><path d="m12 5 7 7-7 7"></path></svg>
                            </button>
                        </div>

                    </div>
                    <div className="">
                        <img className="w-90 lg:block" src="/doctor.png" alt="" />
                    </div>
                </div>

                <div className="flex flex-row items-center justify-between px-6 max-w-screen h-30 bg-white shadow-2xl"> 
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
                        <img className="w-40" src="/svgs/logo-fht.svg" alt="" />
                    </div>
                </div>
            </div>
        </main>
    )
}
