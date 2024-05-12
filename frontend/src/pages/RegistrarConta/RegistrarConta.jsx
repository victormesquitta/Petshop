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

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [displayName, setDisplayName] = useState('');
    const [celular, setCelular] = useState('');

    return (

        <>
            <S.ContainerPai>
                <img src={ImgLogo} className="ImgLogo" />
                <S.FormularioLogin>

                    <S.Inputs>
                        <h1>Registre sua Conta</h1>

                        <input type="text" placeholder="Nome Completo"
                            value={displayName} onChange={(e) => setDisplayName(e.target.value)}
                            id="name" autoComplete="off" required />

                        <input type="email" placeholder="Email"
                            value={email} onChange={(e) => setEmail(e.target.value)}
                            id="email" autoComplete="off"
                            required />

                        <input type="tel" placeholder="Celular" 
                        value={celular} onChange={(e) => setCelular(e.target.value)} 
                        required id="celular" autoComplete="off"/>

                        <div className="divOlhoAbertoOuFechado">
                            <input type={showPassword ? 'text' : 'password'}
                            placeholder="Informe sua senha" 
                            value={password} onChange={(e) => setPassword(e.target.value)} 
                            required autoComplete="current-password" 
                            id="password"/>

                            <div onClick={togglePasswordVisibility} className="OlhoAbertoOuFechado">
                                {showPassword ? <FaEye size={20} color="gray" /> : <FaEyeSlash size={20} color="white" />}
                            </div>
                        </div>
                        <button type="submit">Registrar</button>
                    </S.Inputs>

                    <S.NaoTemConta>
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
