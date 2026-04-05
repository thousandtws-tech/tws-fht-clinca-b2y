import { BrowserRouter, Routes, Route } from "react-router-dom";
import { AppLayout } from "../layout/Outlet/Layout";


import { Dashboard } from "../pages/Dashboard";
import { Leads } from "../pages/Leads";

export function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<AppLayout />}>
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/leads" element={<Leads />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}