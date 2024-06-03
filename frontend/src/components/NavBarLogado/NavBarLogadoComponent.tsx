import * as S from "./styles";
import ImgLogo from "../../assets/images/ImgLogo.svg";
import { FaHeart, FaSearch } from "react-icons/fa";
import { FaBars, FaCartShopping, FaUserAstronaut } from "react-icons/fa6";
import ImgCachorro from "../../assets/images/ImgCachorro.png";
import ImgGato from "../../assets/images/ImgGato.png";
import ImgPassaro from "../../assets/images/ImgPassaro.png";
import ImgOutros from "../../assets/images/ImgOutros.png";
import ImgPeixe from "../../assets/images/ImgPeixe.png";
import { AuthService } from "../../services/AuthService";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Loading } from "../Loading/Loading";
import { auth } from "../../FirebaseConfig";
import { Link } from 'react-router-dom';

type HomePageProps = {
    authService: AuthService;
}

export function NavBarLogado(props: HomePageProps) {
    const navigate = useNavigate();
    const [isLoggingOut, setIsLoggingOut] = useState(false);
    const [isFakeLoggingOut, setIsFakeLoggingOut] = useState(false);
    const currentUser = auth.currentUser;

    const logout = () => {
        setIsLoggingOut(true);
        setIsFakeLoggingOut(true);
        props.authService.logout().then(() => {
            setIsFakeLoggingOut(false);
            //navigate('/login');
        })
    }

    const login = () => {
        navigate('/login');
    }

    const favoritos = () => {
        navigate('/favoritos');
    }

    const carrinho = () => {
        navigate('/carrinho');
    }

    const dashBoardProduto = () => {
        navigate('/dashboardproduto')
    }

    const [isOpen, setIsOpen] = useState(false);

    const toggleDropdown = () => {
        setIsOpen(!isOpen);
    };

    return (
        <>
            <S.NavBarLogado>
                <div>
                    <Link to="/">
                        <img src={ImgLogo} alt="Logo" />
                    </Link>

                    <section className="SectionBarraDePesquisa">
                        <input type="text" placeholder="O que deseja pesquisar?" />
                        <FaSearch className="IconLupa" />
                    </section>

                    <section className="SectionIcons">
                        <FaHeart className="IconFavoritos" onClick={favoritos} />
                        <FaCartShopping className="IconCarrinho" onClick={carrinho} />
                    </section>

                    {!currentUser ? (
                        <button className="BotaoLogin" onClick={login}>Logar</button>
                    ) : (
                        <>
                            <button onClick={dashBoardProduto} className="BotaoFimTela">
                                <FaUserAstronaut className="IconAdmin" />
                                {currentUser?.email && extractNameFromEmail(currentUser.email)}
                            </button>

                            <button className="BotaoLogout" onClick={logout}>Sair</button>
                        </>
                    )}
                </div>

                <S.DivBotoesDepartamentos isOpen={isOpen}>
                    <div className="Dropdown">
                        <button onClick={toggleDropdown} className="ButtonDepartamentos">
                            <span className="iconDepartamento">☰</span> Departamentos
                            {isOpen && (
                                <ul id="dropdown-menu" className="dropdown-menu">
                                    <li><button> <img src={ImgCachorro} alt="Cachorro" /> Cachorro</button></li>
                                    <li><button> <img src={ImgGato} alt="Gato" /> Gato</button></li>
                                    <li><button> <img src={ImgPassaro} alt="Pássaro" /> Pássaro</button></li>
                                    <li><button> <img src={ImgPeixe} alt="Peixe" /> Peixe</button></li>
                                    <li><button> <img src={ImgOutros} alt="Outros Pets" /> Outros Pets</button></li>
                                </ul>
                            )}
                        </button>
                    </div>
                    <div className="menu">
                        <button className="menu-button">🐶 Cachorro</button>
                        <button className="menu-button">🐱 Gato</button>
                        <button className="menu-button">🐦 Pássaros</button>
                        <button className="menu-button">🐟 Peixe</button>
                        <button className="menu-button">🐰 Outros Pets</button>
                    </div>
                </S.DivBotoesDepartamentos>
            </S.NavBarLogado>
            {isFakeLoggingOut && <Loading />}
        </>
    );
}

function extractNameFromEmail(email: string): string | null {
    email = email.trim();
    const nameRegex = /^(?<name>[^\s]+)\@[\w\d.-]+\.[a-z]{2,}$/;
    const match = email.match(nameRegex);

    return match ? match.groups!.name : "";
}
