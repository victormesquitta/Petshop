import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { loginService } from '../../services/login.service';
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer, toast } from 'react-toastify';
import * as S from './styles';

export function Login() {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const loginResponse = await loginService.login(email, senha);

      if (loginResponse) {
        toast.success('Login realizado com sucesso!!')

        setTimeout(() => {
          navigate('/');
        }, 4000); // Redireciona após 1 segundo

        navigate('/');
      } else {
        // Use toast para exibir a mensagem de erro
        toast.error('Credenciais inválidas. Tente novamente.');
      }
    } catch (error) {
      console.error('Login error:', error);
      // Exiba mensagens de erro mais específicas com base no erro
      if (error.response && error.response.status === 401) {
        toast.error('Credenciais inválidas. Tente novamente.');
      } else {
        toast.error('Ocorreu um erro durante o login. Tente novamente mais tarde.');
      }
    }
  };

  return (
    <S.ContainerPai>
      <ToastContainer />
      
      <S.FormularioLogin onSubmit={handleSubmit}>
        <h2>Login</h2>
        <div className='divEmail'>
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className='divSenha'>
          <label htmlFor="senha">Senha:</label>
          <input
            type="password"
            id="senha"
            value={senha}
            onChange={(e) => setSenha(e.target.value)}
            required
          />
        </div>
        <button className='button' type="submit">Login</button>
      </S.FormularioLogin>
    </S.ContainerPai>
  );
}