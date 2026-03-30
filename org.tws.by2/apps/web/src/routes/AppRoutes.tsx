import { Routes, Route } from "react-router-dom";

import { Home } from "../pages/Landing/Home";
import { Sobre } from "../components/footer/Sobre";
import { Politic } from "../components/footer/Politic";
import { Terms } from "../components/footer/Terms";
import { Contact } from "../components/footer/Contact";
import { Telemedicina } from "../pages/Portal/Telemedicina";
import { Login } from "../auth/login/Login";

export function AppRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/sobre" element={<Sobre />} />
      <Route path="/politica" element={<Politic />} />
      <Route path="/termos" element={<Terms />} />
      <Route path="/contato" element={<Contact />} />
      <Route path="/telemedicina" element={<Telemedicina />} />
      <Route path="/login" element={<Login />} />
    </Routes>
  );
}