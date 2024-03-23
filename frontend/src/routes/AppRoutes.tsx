import { BrowserRouter, Route, Routes } from "react-router-dom";
import { AdminLogin } from "../pages/AdminLogin/AdminLogin";
import { Login } from "../pages/Login/Login";
import { RegistrarConta } from "../pages/RegistrarConta/RegistrarConta";
import { Home } from "../pages/Home/Home";
import { Carrinho } from "../pages/Carrinho/Carrinho";
import { Produto } from "../pages/Produto/Produto";
import { CadastraFuncionario } from "../pages/CadastraFuncionario/CadastraFuncionario";

export function AppRoutes() {
    return (
    <>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path='/adminlogin' element={<AdminLogin />} />
                <Route path="/cadastrafuncionario" element={<CadastraFuncionario />} />
                <Route path="/login" element={<Login />} />
                <Route path="/carrinho" element={<Carrinho />} />
                <Route path="/produto" element={<Produto />} />
                <Route path="/registrarconta" element={<RegistrarConta />} />
            </Routes>
        </BrowserRouter>
        </>
    )

}