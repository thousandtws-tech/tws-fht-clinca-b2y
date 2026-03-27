import { Routes, Route } from "react-router-dom";
import { Home } from "./components/home/Home";
import { Sobre } from "./components/home/components/footer/Sobre";
import { Politic } from "./components/home/components/footer/Politic";
import { Terms } from "./components/home/components/footer/Terms";
import { Contact } from "./components/home/components/footer/Contact";
import 'antd/dist/reset.css';

import "./App.css"


export default function App() {
  return (
    <>
      <main>
        <Routes>
          <Route path="" element={<Home />} />
          <Route path="/sobre" element={<Sobre />} />
          <Route path="/politica" element={<Politic />} />
          <Route path="/termos" element={<Terms />} />
          <Route path="/contato" element={<Contact/>} />
        </Routes>
      </main>
    </>
  );
}