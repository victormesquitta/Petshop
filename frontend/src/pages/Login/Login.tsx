import * as S from "./styles";
import { Link } from "react-router-dom";
import ImgGoogle from "../../assets/images/ImgGoogle.png";
import { InputSenhaComponent } from "../../components/InputSenhaComponent/InputSenhaComponent";
import { CheckedBoxComponent } from "../../components/CheckBoxComponent/CheckBoxComponent";
import ImgLogo from "../../assets/images/ImgLogo.svg";
import { FaApple, FaFacebook } from "react-icons/fa";

export function Login() {
    return (
        <>
            <S.ContainerPai>
                <img src={ImgLogo} className="ImgLogo" />
                <S.FormularioLogin>

                    <S.Inputs>
                        <h1>Acesse sua Conta</h1>
                        <InputSenhaComponent />
                    </S.Inputs>

                    <CheckedBoxComponent />

                    <S.NaoTemConta>
                        <div>
                            <p className="Links">Não tem uma conta?<Link to={"/RegistrarConta"} className="Links"> Crie uma conta.</Link></p>

                            <Link to={""} className="Links">Esqueci minha senha.</Link>
                        </div>
                        <p>______________ <span className="LogarCom">Logar Com</span> ______________</p>
                        
                    </S.NaoTemConta>

                    <S.ImgsLogos>
                        <div className="divFacebook"><FaFacebook className="ImgFacebook"/> </div>
                        <div className="divGoogle"><img className="ImgGoogle" src={ImgGoogle} /></div>
                        <div className="divApple"><FaApple className="ImgApple"/></div>

                    </S.ImgsLogos>

                </S.FormularioLogin>
            </S.ContainerPai>
        </>
    )
}