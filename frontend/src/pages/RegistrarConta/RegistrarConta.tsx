import * as S from "./styles";
import ImgGoogle from "../../assets/images/ImgGoogle.png";
import ImgLogo from "../../assets/images/ImgLogo.svg";
import { FaApple, FaEye, FaEyeSlash, FaFacebook } from "react-icons/fa";
import { useState } from "react";

export function RegistrarConta() {
    const [showPassword, setShowPassword] = useState(false);

    const togglePasswordVisibility = () => {
        setShowPassword(!showPassword);
    };

    return (

        <>
            <S.ContainerPai>
                <img src={ImgLogo} className="ImgLogo" />
                <S.FormularioLogin>

                    <S.Inputs>
                        <h1>Registre sua Conta</h1>

                        <input type="text" placeholder="Nome Completo" />
                        <input type="email" placeholder="Email" />
                        <input type="tel" placeholder="Celular" />

                        <div className="divOlhoAbertoOuFechado">
                            <input type={showPassword ? 'text' : 'password'}
                                placeholder="Informe sua senha" />
                            <div onClick={togglePasswordVisibility} className="OlhoAbertoOuFechado">
                                {showPassword ? <FaEye size={20} color="gray" /> : <FaEyeSlash size={20} color="white" />}
                            </div>
                        </div>
                    </S.Inputs>

                    <S.NaoTemConta>
                        <div className="divButton">
                            <button type="submit" onClick={false} value="Acessar">Registrar</button>
                        </div>

                        <p>______________ <span className="LogarCom">Logar Com</span> ______________</p>

                    </S.NaoTemConta>

                    <S.ImgsLogos>
                        <div className="divFacebook"><FaFacebook className="ImgFacebook" /> </div>
                        <div className="divGoogle"><img className="ImgGoogle" src={ImgGoogle} /></div>
                        <div className="divApple"><FaApple className="ImgApple" /></div>

                    </S.ImgsLogos>

                </S.FormularioLogin>
            </S.ContainerPai>
        </>
    )
}
