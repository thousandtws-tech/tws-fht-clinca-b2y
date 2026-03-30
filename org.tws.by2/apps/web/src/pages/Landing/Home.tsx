import { Footer } from "../../components/footer/Footer";
import { Header } from "../../components/header/Header";
import { About } from "./sections/About";
import { Features } from "./sections/Features";
import { Hero } from "./sections/Hero";

export function Home() {
    return(
        <>
            <Header/>
            <Hero/>
            <About/>
            <Features/>
            <Footer/>
        </>
    )
}