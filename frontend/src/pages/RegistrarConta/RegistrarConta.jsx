import * as S from "./styles";
import { useState } from "react";
import { loginService } from "../../services/login.service";
import { useNavigate } from "react-router-dom";
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer, toast } from 'react-toastify';

export function RegistrarConta() {
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [nomeCompleto, setNomeCompleto] = useState('');
    const [cpf, setCpf] = useState('');
    const [celular, setCelular] = useState('');
    const [usuario, setUsuario] = useState('');

    const navigate = useNavigate();
  
    const handleSubmit = async (e) => {
      e.preventDefault();
  
      try {
        const registrationResponse = await loginService.registerCliente({
            usuario,
          nomeCompleto,
          email,
          senha,
          cpf,
          celular,
        });
  
        if (registrationResponse) {
          toast.success('Cadastro realizado com sucesso!!');
          navigate('/login'); // Redireciona para a página de login após o cadastro
        } else {
          toast.error('Ocorreu um erro durante o cadastro. Tente novamente.');
        }
      } catch (error) {
        console.error('Registration error:', error);
        toast.error('Ocorreu um erro durante o cadastro. Tente novamente mais tarde.');
      }
    };
  
    return (
      <S.ContainerPai>
        <ToastContainer />
  
        <S.FormularioLogin onSubmit={handleSubmit}>
          <h2>Registrar Conta</h2>
          <div className='divNome'>
            <label htmlFor="nomeCompleto">Nome Completo:</label>
            <input
              type="text"
              id="nomeCompleto"
              value={nomeCompleto}
              onChange={(e) => setNomeCompleto(e.target.value)}
              required
            />
          </div>
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
          <div className='divUsuario'>
            <label htmlFor="usuario">Usuario:</label>
            <input
              type="text"
              id="usuario"
              value={usuario}
              onChange={(e) => setUsuario(e.target.value)}
              required
            />
          </div>
          <div className='divCpf'>
            <label htmlFor="cpf">CPF:</label>
            <input
              type="text"
              id="cpf"
              value={cpf}
              onChange={(e) => setCpf(e.target.value)}
              required
            />
          </div>
          <div className='divCelular'>
            <label htmlFor="celular">Celular:</label>
            <input
              type="tel"
              id="celular"
              value={celular}
              onChange={(e) => setCelular(e.target.value)}
              required
            />
          </div>
          <button className='buttonRegistrar' type="submit">Registrar</button>
        </S.FormularioLogin>
      </S.ContainerPai>
    );
  }