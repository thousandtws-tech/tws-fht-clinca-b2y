import { Header } from "./components/header/Header"
import "./App.css"
import { Home } from "./components/sections/Home"
import { About } from "./components/sections/About"
import { Portals } from "./components/sections/Portals"
import { Footer } from "./components/footer/Footer"

function App() {

  return (
    <>
      <main className="min-h-screen flex flex-col">
        <Header/>
        <Home/>
        <About/>
        <Portals/>
      </main>
      <Footer/>
    </>
  )
}

export default App
