import { Link } from "react-router-dom"

import logo from "../../assets/svgs/logo-fht.svg"

export function Contact() {
    return(
        
        <div className="flex flex-col min-h-screen bg-gray-50 dark:bg-gray-900 dark:text-white transition-colors duration-300">
            <header className="bg-white dark:bg-gray-800 shadow-md sticky top-0 z-50">
                <div className="sticky top-0 w-full z-9 flex items-center justify-between shadow p-6">
                    <a href="/">
                        <img className="logo area w-30" src={logo} alt="" />
                    </a>
                    <ul className="flex items-center gap-5">
                        <li className="nav-item hover:cursor-pointer">Registre-se</li>
                        <li className="nav-item px-5 py-1 rounded-[7px] bg-blueFHT text-white shadow-2xl hover:cursor-pointer">Entrar</li>
                    </ul>
                </div>
            </header>
            <div className="py-20 bg-linear-to-r from-blue-100 to-white dark:from-blue-900 dark:to-gray-800">
                <div className="container mx-auto px-6 text-center max-w-3xl">
                    <h1 className="text-4xl font-bold mb-6">Fale com a FHT</h1>
                    <p>
                        Estamos prontos para ajudar. Entre em contato conosco para dúvidas,
                        parcerias ou suporte à sua clínica ou hospital.
                    </p>
                </div>
            </div>
            <div className="py-20 bg-white dark:bg-gray-800">
                <div className="container mx-auto px-6 grid md:grid-cols-2 gap-12">
                    <div>
                        <div>
                            <h2 className="text-2xl font-bold mb-4">Informações de Contato</h2>
                            <ul className="space-y-4 text-gray-700 dark:text-gray-300">
                                <li className="flex items-center gap-3"><svg className="w-6" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path className="fill-blueFHT" d="M160.2 25C152.3 6.1 131.7-3.9 112.1 1.4l-5.5 1.5c-64.6 17.6-119.8 80.2-103.7 156.4 37.1 175 174.8 312.7 349.8 349.8 76.3 16.2 138.8-39.1 156.4-103.7l1.5-5.5c5.4-19.7-4.7-40.3-23.5-48.1l-97.3-40.5c-16.5-6.9-35.6-2.1-47 11.8l-38.6 47.2C233.9 335.4 177.3 277 144.8 205.3L189 169.3c13.9-11.3 18.6-30.4 11.8-47L160.2 25z"/></svg>(11) 9999-9999</li>
                                <li className="flex items-center gap-3"><svg className="w-6" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path className="fill-blueFHT" d="M61.4 64C27.5 64 0 91.5 0 125.4 0 126.3 0 127.1 .1 128L0 128 0 384c0 35.3 28.7 64 64 64l384 0c35.3 0 64-28.7 64-64l0-256-.1 0c0-.9 .1-1.7 .1-2.6 0-33.9-27.5-61.4-61.4-61.4L61.4 64zM464 192.3L464 384c0 8.8-7.2 16-16 16L64 400c-8.8 0-16-7.2-16-16l0-191.7 154.8 117.4c31.4 23.9 74.9 23.9 106.4 0L464 192.3zM48 125.4C48 118 54 112 61.4 112l389.2 0c7.4 0 13.4 6 13.4 13.4 0 4.2-2 8.2-5.3 10.7L280.2 271.5c-14.3 10.8-34.1 10.8-48.4 0L53.3 136.1c-3.3-2.5-5.3-6.5-5.3-10.7z"/></svg>contato@fht.com.br</li>
                                <li className="flex items-center gap-3"><svg className="w-6" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path className="fill-blueFHT" d="M512 48c0-11.1-5.7-21.4-15.2-27.2s-21.2-6.4-31.1-1.4L349.5 77.5 170.1 17.6c-8.1-2.7-16.8-2.1-24.4 1.7l-128 64C6.8 88.8 0 99.9 0 112L0 464c0 11.1 5.7 21.4 15.2 27.2s21.2 6.4 31.1 1.4l116.1-58.1 179.4 59.8c8.1 2.7 16.8 2.1 24.4-1.7l128-64c10.8-5.4 17.7-16.5 17.7-28.6l0-352zM192 376.9l0-284.5 128 42.7 0 284.5-128-42.7z"/></svg>Av. Paulista, 1000 - São Paulo/SP</li>
                            </ul>
                        </div>
                        <div className="mt-10">
                            <iframe 
                                className="w-full h-64 rounded-xl shadow-md" 
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3656.9183517617975!2d-46.64820498438526!3d-23.573958668647807!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce59c8a3c0f57f%3A0x1ba5b66cb6b8d7a9!2sAv.%20Paulista%2C%201000%20-%20Bela%20Vista%2C%20S%C3%A3o%20Paulo%20-%20SP%2C%2001310-100!5e0!3m2!1spt-BR!2sbr!4v1612981596785!5m2!1spt-BR!2sbr" 
                                loading="lazy">
                            </iframe>
                        </div>
                    </div>
                    <div>
                        <form className="space-y-6">
                            <h2 className="text-2xl font-bold">Envie uma mensagem</h2>
                            <div>
                                <label htmlFor="">Nome</label>
                                <input className="w-full px-4 py-3 rounded-lg bg-gray-100 dark:bg-gray-700 border border-gray-300 dark:border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="Seu nome" type="text" required/>
                            </div>

                            <div>
                                <label htmlFor="">Email</label>
                                <input className="w-full px-4 py-3 rounded-lg bg-gray-100 dark:bg-gray-700 border border-gray-300 dark:border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500" type="email" placeholder="exemplo@email.com" required/>
                            </div>


                            <div>
                                <label htmlFor="">Mensagem:</label>
                                <textarea className="w-full px-4 py-3 rounded-lg bg-gray-100 dark:bg-gray-700 border border-gray-300 dark:border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="Deixe sua mensagem aqui..." rows={5}></textarea>
                            </div>
                            <input className="inline-flex items-center justify-center gap-2 whitespace-nowrap text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 [&_svg]:pointer-events-none [&_svg]:size-4 [&_svg]:shrink-0 h-10 bg-blue-600 hover:bg-blue-700 text-white px-6 py-3 rounded-xl" type="submit" value="Enviar" />
                        </form>
                    </div>
                </div>
                <div className="text-center mt-16">
                    <Link className="hover:cursor-pointer inline-flex items-center justify-center gap-2 whitespace-nowrap text-sm font-medium ring-offset-background transition-colors bg-blue-600 hover:bg-blue-700 text-white px-6 py-3 rounded-xl" to="/">Voltar para a Pagina Inicial</Link>
                </div>
            </div>
           <footer className="text-sm bg-blue-700 text-white text-center py-6">© 2025 FHT Soluções Hospitalares. Todos os direitos reservados.</footer>
        </div>


    )
}