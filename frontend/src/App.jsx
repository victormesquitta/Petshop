import { GlobalStyle } from "./styles/global";
import { useEffect, useState } from "react";
import { Loading } from "./components/Loading/Loading";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { AdminLogin } from "./pages/AdminLogin/AdminLogin";
import { Home } from "./pages/Home/Home";
// import { CadastraFuncionario } from "./pages/CadastraFuncionario/CadastraFuncionario";
import { Carrinho } from "./pages/Carrinho/Carrinho";
import { Produto } from "./pages/Produto/Produto";
import { RegistrarConta } from "./pages/RegistrarConta/RegistrarConta";
import { Login } from "./pages/Login/Login";
import { Favoritos } from "./pages/Favoritos/Favoritos";
import { MeusPedidos } from "./pages/MeusPedidos/MeusPedidos";
// import { CadastroProduto } from "./pages/CadastroProduto/CadastroProduto";
import { MeusPets } from "./pages/MeusPets/MeusPets";
import { DashBoardProduto } from "./pages/DashBoardProduto/DashBoardProduto";
import { MeusCartoes } from "./pages/MeusCartoes/MeusCartoes";
import { AdminPedidos } from "./pages/AdminPedidos/AdminPedidos";
import { Adocao } from "./pages/Adocao/adocao";
import { Erro403 } from "./pages/Erro403/Erro403"
import { Erro404 } from "./pages/Erro404/Erro404"


export function App(props) {
  const [isLoadingLoggedUser, setIsLoadingLoggedUser] = useState(true);
  const [user, setUser] = useState();

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
            <Route path="/carrinho" element={<Carrinho authService={props.authService} />} />
            <Route path="/favoritos" element={<Favoritos authService={props.authService} />} />
            <Route path="/meuspedidos" element={<MeusPedidos authService={props.authService} />} />
            <Route path="/meuscartoes" element={<MeusCartoes authService={props.authService} />} />
            <Route path="/meuspets" element={<MeusPets authService={props.authService} />} />
            <Route path="/produto" element={<Produto authService={props.authService} />} />
            <Route path="/erro403" element={<Erro403 authService={props.authService} />} />
            <Route path="/erro404" element={<Erro404 authService={props.authService} />} />
            <Route path="/registrarconta" element={<RegistrarConta />} />
            <Route path="/adocao" element={<Adocao />} />


            {'parte de admin.'}
            {/* <Route path="/cadastroproduto" element={<CadastroProduto />} /> */}
            {/* <Route path="/cadastrofuncionario" element={<CadastraFuncionario />} /> */}
            <Route path="/adminpedidos" element={<AdminPedidos />} />
            <Route path="/dashboardproduto" element={<DashBoardProduto authService={props.authService} />} />
            <Route path='/adminlogin' element={<AdminLogin />} />
            {/* <Route path='/admincategoria' element={<CadastroCategoria />} />  */}

          </Routes>
        </BrowserRouter>
      }

      {isLoadingLoggedUser && <Loading />}

    </>
  );
}

