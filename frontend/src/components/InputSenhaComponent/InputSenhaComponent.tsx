import { FaEye, FaEyeSlash } from "react-icons/fa";
import * as S from "./styles";
import { useState } from 'react';

export function InputSenhaComponent() {
    const [showPassword, setShowPassword] = useState(false);

    const togglePasswordVisibility = () => {
        setShowPassword(!showPassword);
    };

    return (
        <S.InputSenha>
            <input type="email" placeholder="Informe seu email" />

            <div className="divOlhoAbertoOuFechado">
                <input type={showPassword ? 'text' : 'password'}
                    placeholder="Informe sua senha" />
                <div onClick={togglePasswordVisibility} className="OlhoAbertoOuFechado">
                    {showPassword ? <FaEye size={20} color="gray"/> : <FaEyeSlash size={20} color="white"/>}
                </div>
            </div>

        </S.InputSenha>
    )
}