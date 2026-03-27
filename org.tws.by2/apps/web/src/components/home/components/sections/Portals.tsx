export function Portals() {
    return( 
        <section className="flex items-center justify-center ">
            <div className="flex flex-col gap-7 mb-24 px-4 items-center">
                <div className="text-center">
                    <h2 className="titlePortals text-3xl font-semibold text-lightGrayFHT">Nossas Iniciativas de Saúde</h2>
                    <p className="text-lightGrayFHT subTitlePortals">Projetos de alto impacto para levar cuidado e tecnologia a quem mais precisa. Conheça e participe.</p>
                </div>
                <div className="grid grid-cols-1 px-0 lg:grid-cols-2 items-center gap-8 justify-center  ">
                    {/* Primeiro Card : Carreta da Saúde */}
                    <div className="card5 gap-4 p-5 flex flex-col justify-center items-center text-center shadow-lg rounded bg-white">
                        <div className="flex gap-5 items-center">
                            <div className="h-15 w-15 bg-lightBlueFHT flex items-center justify-center rounded-full">
                                <svg className="w-10" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                                    <path className="fill-blueFHT" d="M0 96C0 60.7 28.7 32 64 32l288 0c35.3 0 64 28.7 64 64l0 32 50.7 0c17 0 33.3 6.7 45.3 18.7L557.3 192c12 12 18.7 28.3 18.7 45.3L576 384c0 35.3-28.7 64-64 64l-3.3 0c-10.4 36.9-44.4 64-84.7 64s-74.2-27.1-84.7-64l-102.6 0c-10.4 36.9-44.4 64-84.7 64s-74.2-27.1-84.7-64L64 448c-35.3 0-64-28.7-64-64L0 96zM512 288l0-50.7-45.3-45.3-50.7 0 0 96 96 0zM192 424a40 40 0 1 0 -80 0 40 40 0 1 0 80 0zm232 40a40 40 0 1 0 0-80 40 40 0 1 0 0 80z"/>
                                </svg>
                            </div>
                            {/* Titulo */}
                            <h3 className="text-2xl font-semibold text-lightGrayFHT">Carreta da Saúde</h3>
                        </div>
                        <p className="text-justify text-grayFHT max-w-90">
                            Atendimentos presenciais e exames em diversas localidades.
                            Um projeto itinerante de cuidado e prevenção.
                        </p>
                        <button className="bg-[#BABABA] text-white w-full rounded-2xl p-2 ">Em breve...</button>
                    </div>

                    {/* Segundo Card :  Portal Telemedicina */}
                    <div className=" card6 gap-4 p-5 flex flex-col justify-center items-center text-center shadow-lg rounded bg-white">
                        <div className="flex gap-5 items-center ">
                            <div className="h-15 w-15 bg-lightGreenFHT flex items-center justify-center rounded-full">
                                <svg className="w-10" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                                    <path className="fill-greenFHT" d="M96 64c-35.3 0-64 28.7-64 64l0 256c0 35.3 28.7 64 64 64l256 0c35.3 0 64-28.7 64-64l0-256c0-35.3-28.7-64-64-64L96 64zM464 336l73.5 58.8c4.2 3.4 9.4 5.2 14.8 5.2 13.1 0 23.7-10.6 23.7-23.7l0-240.6c0-13.1-10.6-23.7-23.7-23.7-5.4 0-10.6 1.8-14.8 5.2L464 176 464 336z"/>
                                </svg>
                            </div>
                            {/* Titulo */}
                            <h3 className="text-2xl font-semibold text-lightGrayFHT">Portal Telemedicina</h3>
                        </div>
                        <p className="text-justify text-grayFHT max-w-90 mx-auto">
                            Consultas online com especialistas,
                            trazendo conveniência e acesso à saúde de qualidade, onde quer que você esteja.
                        </p>
                        <button className="bg-darkGreenFHT text-white w-full rounded-2xl p-2 flex items-center justify-center gap-4 hover:bg-greenFHT hover:cursor-pointer transition ">
                            Acender ao Portal <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" className="lucide lucide-arrow-right h-4 w-4"><path d="M5 12h14"></path><path d="m12 5 7 7-7 7"></path></svg>
                        </button>
                    </div>
                </div>
            </div>
        </section>
    )
}