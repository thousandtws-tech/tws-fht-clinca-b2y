import { Footer } from "./components/footer/Footer";
import { Header } from "./components/header/Header";
import { About } from "./components/sections/About";
import { Portals } from "./components/sections/Portals";
import { Principal } from "./components/sections/Principal";

export function Home() {
    return(
        <>
            <Header/>
            <Principal/>
            <About/>
            <Portals/>
            <Footer/>
        </>
    )
}