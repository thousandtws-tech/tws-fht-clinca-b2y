import { useEffect, useRef } from "react";
import { animateAbout } from "../animations/About";

export function About() {

    const ref = useRef(null);

    useEffect(() => {
    const cleanup = animateAbout(ref);
    return cleanup;
    }, []);
    
    return( 
        <section ref={ref} className="flex items-center justify-center ">
            <div className="flex flex-col gap-7 pb-36 justify-center text-center items-center">
                {/* Titulo */}
                <h2 className="about-title text-3xl font-semibold text-lightGrayFHT">Como funciona a Plataforma da FHT</h2>
                {/* Cards */}
                <div className="grid grid-cols-1 w-full px-5 md:grid-cols-2 lg:grid-cols-4 gap-4">
                    
                    <div className="card1 flex flex-col justify-center items-center text-center gap-4 rounded-2xl shadow p-4 w-full bg-white hover:shadow">
                        <div className="bg-lightBlueFHT w-15 h-15 rounded-full flex items-center justify-center">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 640" className="w-10">
                                <path className="fill-blueFHT"  d="M240 192C240 147.8 275.8 112 320 112C364.2 112 400 147.8 400 192C400 236.2 364.2 272 320 272C275.8 272 240 236.2 240 192zM448 192C448 121.3 390.7 64 320 64C249.3 64 192 121.3 192 192C192 262.7 249.3 320 320 320C390.7 320 448 262.7 448 192zM144 544C144 473.3 201.3 416 272 416L368 416C438.7 416 496 473.3 496 544L496 552C496 565.3 506.7 576 520 576C533.3 576 544 565.3 544 552L544 544C544 446.8 465.2 368 368 368L272 368C174.8 368 96 446.8 96 544L96 552C96 565.3 106.7 576 120 576C133.3 576 144 565.3 144 552L144 544z"/>
                            </svg>
                        </div>
                        <h3 className="font-bold text-lightGrayFHT text-[20px]">Crie seu perfil</h3>
                        <p className="text-[14px] text-grayFHT">Adicione suas especialidades e documentos de forma simples.</p>
                    </div>


                    <div className=" card2 flex flex-col justify-center items-center text-center gap-4 rounded-2xl shadow h-50 p-4  bg-white">
                        <div className="bg-lightBlueFHT w-15 h-15 rounded-full flex items-center justify-center">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 640" className="w-10">
                                <path className="fill-blueFHT" d="M216 64C229.3 64 240 74.7 240 88L240 128L400 128L400 88C400 74.7 410.7 64 424 64C437.3 64 448 74.7 448 88L448 128L480 128C515.3 128 544 156.7 544 192L544 480C544 515.3 515.3 544 480 544L160 544C124.7 544 96 515.3 96 480L96 192C96 156.7 124.7 128 160 128L192 128L192 88C192 74.7 202.7 64 216 64zM216 176L160 176C151.2 176 144 183.2 144 192L144 240L496 240L496 192C496 183.2 488.8 176 480 176L216 176zM144 288L144 480C144 488.8 151.2 496 160 496L480 496C488.8 496 496 488.8 496 480L496 288L144 288z"/>
                            </svg>  
                        </div>
                        <h3 className="font-bold text-lightGrayFHT text-[20px]">Defina Sua Agenda</h3>
                        <p className="text-[14px] text-grayFHT">Escolha os dias e horários em que está disponível.</p>
                    </div>


                    <div className="card3 flex flex-col justify-center items-center text-center gap-4 rounded-2xl shadow p-4  bg-white">
                        <div className="bg-lightBlueFHT w-15 h-15 rounded-full flex items-center justify-center">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 640" className="w-10">
                                <path className="fill-blueFHT"  d="M528 320C528 434.9 434.9 528 320 528C205.1 528 112 434.9 112 320C112 205.1 205.1 112 320 112C434.9 112 528 205.1 528 320zM64 320C64 461.4 178.6 576 320 576C461.4 576 576 461.4 576 320C576 178.6 461.4 64 320 64C178.6 64 64 178.6 64 320zM296 184L296 320C296 328 300 335.5 306.7 340L402.7 404C413.7 411.4 428.6 408.4 436 397.3C443.4 386.2 440.4 371.4 429.3 364L344 307.2L344 184C344 170.7 333.3 160 320 160C306.7 160 296 170.7 296 184z"/>
                            </svg>
                        </div>
                        <h3 className="font-bold text-lightGrayFHT text-[20px]">Receba Propostas </h3>
                        <p className="text-[14px] text-grayFHT">Hospitais enviam ofertas baseadas no seu perfil</p>
                    </div>


                    <div className=" card4 flex flex-col justify-center items-center text-center gap-4 rounded-2xl shadow  p-4 bg-white">
                        <div className="bg-lightBlueFHT w-15 h-15 rounded-full flex items-center justify-center" >
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 640" className="w-10">
                                <path className="fill-blueFHT" d="M192 112L304 112L304 200C304 239.8 336.2 272 376 272L464 272L464 512C464 520.8 456.8 528 448 528L192 528C183.2 528 176 520.8 176 512L176 128C176 119.2 183.2 112 192 112zM352 131.9L444.1 224L376 224C362.7 224 352 213.3 352 200L352 131.9zM192 64C156.7 64 128 92.7 128 128L128 512C128 547.3 156.7 576 192 576L448 576C483.3 576 512 547.3 512 512L512 250.5C512 233.5 505.3 217.2 493.3 205.2L370.7 82.7C358.7 70.7 342.5 64 325.5 64L192 64zM248 320C234.7 320 224 330.7 224 344C224 357.3 234.7 368 248 368L392 368C405.3 368 416 357.3 416 344C416 330.7 405.3 320 392 320L248 320zM248 416C234.7 416 224 426.7 224 440C224 453.3 234.7 464 248 464L392 464C405.3 464 416 453.3 416 440C416 426.7 405.3 416 392 416L248 416z"/>
                            </svg>
                        </div>
                        <h3 className="font-bold text-lightGrayFHT text-[20px]">Assine Digitalmente</h3>
                        <p className="text-[14px] text-grayFHT">Contrato seguro e digital, com validade jurídica.</p>
                    </div>
                </div>
            </div>
        </section>
    )
}