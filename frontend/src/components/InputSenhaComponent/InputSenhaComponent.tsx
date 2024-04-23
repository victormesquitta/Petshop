import { FaEye, FaEyeSlash } from "react-icons/fa";
import * as S from "./styles";
import { useState } from 'react';
import ValidationError from "../validation-error/ValidationError";
import { Link, useNavigate } from "react-router-dom";
import { AuthService } from "../../services/AuthService";
import { Loading } from "../Loading/Loading";
import { CheckedBoxComponent } from "../CheckBoxComponent/CheckBoxComponent";

type LoginPageProps = {
  authService: AuthService;
}

export function InputSenhaComponent(props: LoginPageProps) {
  const [showPassword, setShowPassword] = useState(false);
  const [email, setEmail] = useState('');
  const [error, setError] = useState(null as any);
  const [showLoading, setShowLoading] = useState(false);
  const [showRecoverPasswordMessage, setShowRecoverPasswordMessage] = useState(false);
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

  const login = async () => {
    // Exibe o indicador de carregamento
    setShowLoading(true);

    try {
      // Tenta realizar o login
      await props.authService.login(form.email.value, form.password.value);

      // Oculta o indicador de carregamento e redireciona para a home
      setShowLoading(false);
      navigate('/');
    } catch (error) {
      // Oculta o indicador de carregamento
      setShowLoading(false);

      // Define a mensagem de erro (específica ou genérica)
      setError(error || 'Ocorreu um erro durante o login.');
    }
  };
  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  function recoverPassword() {
    setShowLoading(true);
    props.authService.recoverPassword(
      form.email.value
    ).then(() => {
      setShowRecoverPasswordMessage(true);
      setShowLoading(false);
    }).catch(error => {
      setError(error);
      setShowLoading(false);
    })
  }

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
          onChange={event => setForm({
            ...form, password: {
              hasChanged: true, value: event.target.value
            }
          })} />
        <div onClick={togglePasswordVisibility} className="OlhoAbertoOuFechado">
          {showPassword ? <FaEye size={20} color="gray" /> : <FaEyeSlash size={20} color="black" />}
        </div>
      </div>

      {error && <div className="error">{"ERRO!! Usuario ou Senha Incorretos."}</div>}

      <div className="divButton">
        <button type="button" onClick={login}>Logar</button>
      </div>

      <CheckedBoxComponent />

      <Link to={""} className="Links" onClick={recoverPassword}>Esqueci minha senha.</Link>

      {showLoading && <Loading />}
      {
        showRecoverPasswordMessage &&
        <div>
          Verifique sua caixa de email
        </div>
      }

    </S.InputSenha >
  )
}