import { GlobalStyle } from "./styles/global";
import { useEffect, useState } from "react";
import { Loading } from "./components/Loading/Loading";
import { AuthService } from "./services/AuthService";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import { AdminLogin } from "./pages/AdminLogin/AdminLogin";
import { Home } from "./pages/Home/Home";
import { CadastraFuncionario } from "./pages/CadastraFuncionario/CadastraFuncionario";
import { Carrinho } from "./pages/Carrinho/Carrinho";
import { Produto } from "./pages/Produto/Produto";
import { RegistrarConta } from "./pages/RegistrarConta/RegistrarConta";
import { Login } from "./pages/Login/Login";
import { Favoritos } from "./pages/Favoritos/Favoritos";
import { MeusPedidos } from "./pages/MeusPedidos/MeusPedidos";
import { CadastroProduto } from "./pages/CadastroProduto/CadastroProduto";

type AppProps = {
  authService: AuthService;
}

export function App(props: AppProps) {
  const [isLoadingLoggedUser, setIsLoadingLoggedUser] = useState(true);
  const [user, setUser] = useState(null as any);

  useEffect(() => {
    props.authService.getLoggedUser()
      .then(user => {
        setIsLoadingLoggedUser(false);
        setUser(user);
      })
      .catch(error => {
        console.log(error);
        setIsLoadingLoggedUser(false);
      })
  }, []);

  return (
    <>
      <GlobalStyle />
      {
        !isLoadingLoggedUser &&
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home authService={props.authService} />} />
            <Route path="/login" element={<Login />} />
            <Route path='/adminlogin' element={<AdminLogin />} />
            <Route path="/cadastrafuncionario" element={<CadastraFuncionario />} />
            <Route path="/cadastroproduto" element={<CadastroProduto />} />
            <Route path="/carrinho" element={<Carrinho authService={props.authService} />} />
            <Route path="/favoritos" element={<Favoritos authService={props.authService} />} />
            <Route path="/meuspedidos" element={<MeusPedidos authService={props.authService} />} />
            <Route path="/produto" element={<Produto authService={props.authService} />} />
            <Route path="/registrarconta" element={<RegistrarConta />} />
          </Routes>
        </BrowserRouter>
      }

      {isLoadingLoggedUser && <Loading />}
    </>

  );
}

