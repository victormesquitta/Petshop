import * as S from "./styles";
import ImgLogo from "../../assets/images/ImgLogo.svg";
import { FaHeart, FaSearch } from "react-icons/fa";
import { FaBars, FaCartShopping, FaUserAstronaut } from "react-icons/fa6";
import ImgCachorro from "../../assets/images/ImgCachorro.png"
import ImgGato from "../../assets/images/ImgGato.png";
import ImgPassaro from "../../assets/images/ImgPassaro.png";
import ImgOutros from "../../assets/images/ImgOutros.png";
import ImgPeixe from "../../assets/images/ImgPeixe.png"
import { AuthService } from "../../services/AuthService";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Loading } from "../Loading/Loading";

type HomePageProps = {
    authService: AuthService;
}

export function NavBarLogado(props: HomePageProps) {

    const navigate = useNavigate();
    const [isLoggingOut, setIsLoggingOut] = useState(false);

    const logout = () => {
        setIsLoggingOut(true);
        props.authService.logout().then(() => {
            setIsLoggingOut(false);
            navigate('/home');
        })
    }

    return (
        <>
            <S.NavBarLogado>
                <div>
                    <img src={ImgLogo} />

                    <section className="SectionBarraDePesquisa">
                        <input type="text" placeholder="O que deseja pesquisar?" />
                        <FaSearch className="IconLupa" />
                    </section>

                    <section className="SectionIcons">
                        <FaHeart className="IconFavoritos" />
                        <FaCartShopping className="IconCarrinho" />
                    </section>

                    {isLoggingOut ? (
                        <button>Logar</button>
                    ) :
                        (
                        <><button className="BotaoFimTela"><FaUserAstronaut className="IconAdmin" /> Olá, João</button>
                        <button className="BotaoLogout" onClick={logout} >Sair</button>
                        </>

                )
                    }


            </div>

            <div className="DivBotoesDepartamentos">
                <button className="ButtonDepartamentos"><FaBars /> Departamentos</button>
                <button> <img src={ImgCachorro} /> Cachorro</button>
                <button> <img src={ImgGato} /> Gato</button>
                <button> <img src={ImgPassaro} /> Pássaro</button>
                <button> <img src={ImgPeixe} /> Peixe</button>
                <button><img src={ImgOutros} /> Outros Pets</button>
            </div>
        </S.NavBarLogado >
            { isLoggingOut && <Loading />
}
        </>
    );
}