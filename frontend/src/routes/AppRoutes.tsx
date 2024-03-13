import { BrowserRouter, Route, Routes } from "react-router-dom";
import { AdminLogin } from "../pages/AdminLogin/AdminLogin";
import { Login } from "../pages/Login/Login";
import { RegistrarConta } from "../pages/RegistrarConta/RegistrarConta";
import { Home } from "../pages/Home/Home";

export function AppRoutes(){
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/login' element={<Login />} />
                <Route path='/adminlogin' element={<AdminLogin />} />
                <Route path='/registrarconta' element={<RegistrarConta />} />
                <Route path="/" element={<Home />}/>
            </Routes>
        </BrowserRouter>
    )

}