import { Link } from "react-router-dom";
import logo from "../../assets/svgs/logo-fht.svg"


export function Sobre() {
    return(
        <div className="min-h-screen flex flex-col bg-linear-to-r from-blue-50 to-white dark:from-blue-900 dark:to-gray-800 text-gray-800 dark:text-white px-6 py-12">
            <header className="mb-12 flex justify-center"><a href="/"><img src={logo} className="w-50" alt="" /></a></header>
            <main className="max-w-4xl mx-auto text-center">
                <h1 className="text-4xl mb-5 font-bold">Sobre Nós</h1>
                <p className="text-center mb-5 text-[20px] max-w-270">
                    A <span className="text-[#65a3f5] font-bold">FHT Soluções Hospitalares </span> 
                    é uma plataforma inovadora que conecta médicos e instituições de saúde de forma prática, 
                    ágil e segura. Com tecnologia de ponta e foco na experiência do usuário, facilitamos o
                    processo de contratação de plantões, otimizando a gestão hospitalar e valorizando o trabalho médico.
                </p>

                {/* Caixas */}
                <div className="grid grid-cols-1 md:grid-cols-3 gap-8 mb-16">
                    <div className="flex flex-col items-center text-center p-6 bg-white dark:bg-gray-800 rounded-xl shadow-md">
                        <div className="bg-blue-100 dark:bg-blue-900 p-4 rounded-full mb-4">
                            <svg className="w-10 h-10" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512">
                                <path className="fill-blue-600" 
                                
                                d="M64 48c-8.8 0-16 7.2-16 16l0 384c0 8.8 7.2 16 16 16l80 0 0-80c0-17.7 14.3-32 32-32l32 0c17.7 0 32 14.3 32 32l0 80 80 0c8.8 0 16-7.2 16-16l0-384c0-8.8-7.2-16-16-16L64 48zM0 64C0 28.7 28.7 0 64 0L320 0c35.3 0 64 28.7 64 64l0 384c0 35.3-28.7 64-64 64L64 512c-35.3 0-64-28.7-64-64L0 64zm96 48c0-8.8 7.2-16 16-16l32 0c8.8 0 16 7.2 16 16l0 32c0 8.8-7.2 16-16 16l-32 0c-8.8 0-16-7.2-16-16l0-32zM240 96l32 0c8.8 0 16 7.2 16 16l0 32c0 8.8-7.2 16-16 16l-32 0c-8.8 0-16-7.2-16-16l0-32c0-8.8 7.2-16 16-16zM96 240c0-8.8 7.2-16 16-16l32 0c8.8 0 16 7.2 16 16l0 32c0 8.8-7.2 16-16 16l-32 0c-8.8 0-16-7.2-16-16l0-32zm144-16l32 0c8.8 0 16 7.2 16 16l0 32c0 8.8-7.2 16-16 16l-32 0c-8.8 0-16-7.2-16-16l0-32c0-8.8 7.2-16 16-16z"/>
                            </svg>
                    
                        </div>
                        <h2 className="text-2xl">Missão</h2>
                        <p className="text-">
                            Transformar a gestão hospitalar através da
                            tecnologia, promovendo conexões eficazes entre profissionais e instituições de saúde
                        </p>
                    </div>
                    <div className="bg-[#1f2936] shadow  p-3 flex flex-col justify-center items-center rounded-2xl">
                        <div className="bg-blue-100 dark:bg-blue-900 p-4 rounded-full mb-4">
                            <svg className="w-10 h-10" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                <path className="fill-blue-600" d="M378.9 80c-27.3 0-53 13.1-69 35.2l-34.4 47.6c-4.5 6.2-11.7 9.9-19.4 9.9s-14.9-3.7-19.4-9.9l-34.4-47.6c-16-22.1-41.7-35.2-69-35.2-47 0-85.1 38.1-85.1 85.1 0 49.9 32 98.4 68.1 142.3 41.1 50 91.4 94 125.9 120.3 3.2 2.4 7.9 4.2 14 4.2s10.8-1.8 14-4.2c34.5-26.3 84.8-70.4 125.9-120.3 36.2-43.9 68.1-92.4 68.1-142.3 0-47-38.1-85.1-85.1-85.1zM271 87.1c25-34.6 65.2-55.1 107.9-55.1 73.5 0 133.1 59.6 133.1 133.1 0 68.6-42.9 128.9-79.1 172.8-44.1 53.6-97.3 100.1-133.8 127.9-12.3 9.4-27.5 14.1-43.1 14.1s-30.8-4.7-43.1-14.1C176.4 438 123.2 391.5 79.1 338 42.9 294.1 0 233.7 0 165.1 0 91.6 59.6 32 133.1 32 175.8 32 216 52.5 241 87.1l15 20.7 15-20.7z"/>
                            </svg>
                        </div>
                        <h2 className="text-2xl">Valores</h2>
                        <p className="text-center">
                            Ética, transparência, inovação, valorização do profissional da saúde e compromisso com 
                            a excelência no atendimento.
                        </p>
                    </div>
                    <div className="bg-[#1f2936] shadow p-3 flex flex-col justify-center items-center rounded-2xl">
                        <div className="bg-blue-100 dark:bg-blue-900 p-4 rounded-full mb-4">
                            <svg className="w-10 h-10" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                                <path className="fill-blue-600"  d="M144 128a80 80 0 1 1 160 0 80 80 0 1 1 -160 0zm208 0a128 128 0 1 0 -256 0 128 128 0 1 0 256 0zM48 480c0-70.7 57.3-128 128-128l96 0c70.7 0 128 57.3 128 128l0 8c0 13.3 10.7 24 24 24s24-10.7 24-24l0-8c0-97.2-78.8-176-176-176l-96 0C78.8 304 0 382.8 0 480l0 8c0 13.3 10.7 24 24 24s24-10.7 24-24l0-8z"/>
                            </svg>
                        </div>
                        <h2 className="text-2xl">Pra quem é</h2>
                        <p>
                            Médicos em busca de oportunidades e hospitais que desejam otimizar o processo de
                            contratação e escala de plantões.
                        </p>
                    </div>
                </div>
                    <Link className="hover:cursor-pointer inline-flex items-center justify-center gap-2 whitespace-nowrap text-sm font-medium ring-offset-background transition-colors bg-blue-600 hover:bg-blue-700 text-white px-6 py-3 rounded-xl" to="/">Voltar para a Pagina Inicial</Link>                
            </main>
        </div>
    )
}