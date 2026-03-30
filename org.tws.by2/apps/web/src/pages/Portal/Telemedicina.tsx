import { Footer } from "../../components/footer/Footer";
import { Header } from "../../components/header/Header";
import { Hero } from "./sections/Hero";
import { Cards } from "./sections/Cards";

export function Telemedicina() {
    return(
        <section>
            <Header/>
            <Hero/>
            <Cards/>
            <Footer/>
        </section>
    )
}