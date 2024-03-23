import { FaEye, FaEyeSlash } from "react-icons/fa";
import * as S from "./styles";
import { useState } from 'react';
import ValidationError from "../validation-error/ValidationError";

export function InputSenhaComponent() {
    const [showPassword, setShowPassword] = useState(false);
    const [email, setEmail] = useState('');
    const [form, setForm] = useState({
        email: {
          hasChanged: false,
          value: ""
        },
        password: {
          hasChanged: false,
          value: ""
        }
      })
    const handleLogin = () => {

    }
    const togglePasswordVisibility = () => {
        setShowPassword(!showPassword);
    };

    return (
        <S.InputSenha onSubmit={handleLogin}>
            <input type="email" placeholder="Informe seu email" value={form.email.value}
          onChange={event => setForm({...form, email: {
            hasChanged: true, value: event.target.value
          }})}
          data-testid='email' />
        <ValidationError
          hasChanged={form.email.hasChanged}
          errorMessage='Email é obrigatório'
          testId='email-required'
          type='required'
          value={form.email.value}/>
        <ValidationError
          hasChanged={form.email.hasChanged}
          errorMessage='Email é inválido'
          testId='email-invalid'
          type='email'
          value={form.email.value}/>

            <div className="divOlhoAbertoOuFechado">
                <input type={showPassword ? 'text' : 'password'}
                    placeholder="Informe sua senha" />
                <div onClick={togglePasswordVisibility} className="OlhoAbertoOuFechado">
                    {showPassword ? <FaEye size={20} color="gray" /> : <FaEyeSlash size={20} color="white" />}
                </div>
            </div>

            <div className="divButton">
                <button type="submit">Logar</button>
            </div>

        </S.InputSenha>
    )
}