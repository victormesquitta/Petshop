import { FaEye, FaEyeSlash } from "react-icons/fa";
import * as S from "./styles";
import { useState } from 'react';
import ValidationError from "../validation-error/ValidationError";
import { useNavigate } from "react-router-dom";
import { AuthService } from "../../services/AuthService";
import { Loading } from "../Loading/Loading";

type LoginPageProps = {
  authService: AuthService;
}

export function InputSenhaComponent(props: LoginPageProps) {
  const [showPassword, setShowPassword] = useState(false);
  const [email, setEmail] = useState('');
  const [error, setError] = useState(null as any);
  const [showLoading, setShowLoading] = useState(false);
  const navigate = useNavigate();
  
  const [form, setForm] = useState({
    email: {
      hasChanged: false,
      value: ""
    },
    password: {
      hasChanged: false,
      value: ""
    }
  })

  const login = () => {
    setShowLoading(true);
    
    props.authService.login(
      form.email.value, form.password.value
    ).then(() => {
      setShowLoading(false);
      navigate('/');
    }).catch(error => {
      setShowLoading(false);
      setError(error);
    });
  }
  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  return (
    <S.InputSenha>
      <input type="email" placeholder="Informe seu email" value={form.email.value}
        onChange={event => setForm({
          ...form, email: {
            hasChanged: true, value: event.target.value
          }
        })}
        data-testid='email' />
      <ValidationError
        hasChanged={form.email.hasChanged}
        errorMessage='Email é obrigatório'
        testId='email-required'
        type='required'
        value={form.email.value}
      />
      <ValidationError
        hasChanged={form.email.hasChanged}
        errorMessage='Email é inválido'
        testId='email-invalid'
        type='email'
        value={form.email.value}
      />

      <div className="divOlhoAbertoOuFechado">
        <input type={showPassword ? 'text' : 'password'}
          placeholder="Informe sua senha" value={form.password.value}
          onChange={event => setForm({...form, password: {
            hasChanged: true, value: event.target.value
          }})}/>
        <div onClick={togglePasswordVisibility} className="OlhoAbertoOuFechado">
          {showPassword ? <FaEye size={20} color="gray" /> : <FaEyeSlash size={20} color="white" />}
        </div>
      </div>

      { error && <div className="error">{error.message}</div>}

      <div className="divButton">
        <button type="button" onClick={login}>Logar</button>
      </div>
      {showLoading && <Loading />}

    </S.InputSenha>
  )
}