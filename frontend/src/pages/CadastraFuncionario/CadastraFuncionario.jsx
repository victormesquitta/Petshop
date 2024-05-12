import * as S from './styles';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import ImgPerfilFuncionario from '../../assets/images/ImgPerfilFuncionario.png';
import { Link } from 'react-router-dom';
import { FaList, FaObjectGroup, FaSearch, FaUserAlt } from 'react-icons/fa';
import { useState } from 'react';
import { funcionarioService } from '../../services/funcionario.service';

export function CadastraFuncionario() {
    const [nomeFun, setNomeFun] = useState('');
    const [senhaFun, setSenhaFun] = useState('');
    const [ativoFun, setAtivoFun] = useState('');
    const [emailFun, setEmailFun] = useState('');
    const [nivelAcessoFun, setNivelAcessoFun] = useState('');
    const [cargoFun, setCargoFun] = useState('');

    const novoFuncionario = {
        nome: nomeFun,
        senha: senhaFun,
        ativo: ativoFun,
        email: emailFun,
        nivelAcesso: nivelAcessoFun,
        cargo: cargoFun
    };

    async function criarFuncionario() {
        try {
            const response = await funcionarioService.createFuncionario(novoFuncionario);
            console.log('Funcionário criado com sucesso:', response.data);
            // Limpe o formulário após a criação
            setNome('');
            setRegistro('');
            // Redirecione o usuário ou exiba uma mensagem de sucesso
        } catch (error) {
            console.error('Erro ao criar funcionário:', error);
            // Exiba uma mensagem de erro ao usuário
        }
    }

    return (
        <>
            <S.ContainerPai>
                <div className='divDashBoard'>
                    <img src={ImgLogo} alt="Logo" />
                    <h1>DashBoard</h1>
                    <Link to={'/cadastrafuncionario'} className='Link' ><FaUserAlt className='icons' />Funcionario</Link>
                    <Link to={'/cadastroproduto'} className='Link' ><FaObjectGroup className='icons' /> Produtos</Link>
                    <Link to={''} className='Link'><FaList className='icons' /> Categoria</Link>
                </div>
                <div className='divPrincipal'>
                    <section className='section1'>
                        <input placeholder='Pesquisar' className='InputPesquisar' />
                        <FaSearch className="IconLupa" />
                        <img src={ImgPerfilFuncionario} alt="Perfil do Funcionário" />
                    </section>
                    <section className='section2'>
                        <h1>Novo Funcionário</h1>
                        <label htmlFor="nome">Nome Completo</label>
                        <input
                            id="nome"
                            className='InputNomeFun'
                            value={nomeFun}
                            onChange={e => setNomeFun(e.target.value)}
                        />

                        <label htmlFor="senha">Senha Funcionário</label>
                        <input
                            id="senha"
                            className='InputSenha'
                            value={senhaFun}
                            onChange={e => setSenhaFun(e.target.value)}
                        />

                        <label htmlFor="email">Email do Funcionário</label>
                        <input
                            id="email"
                            className='InputEmail'
                            value={emailFun}
                            onChange={e => setEmailFun(e.target.value)}
                        />

                        <label htmlFor="nivelAcesso">Nivel de Acesso</label>
                        <input
                            id="nivelAcesso"
                            className='InputNivelAcesso'
                            value={nivelAcessoFun}
                            onChange={e => setNivelAcessoFun(e.target.value)}
                        />

                        <label htmlFor="ativo">Funcionário Ativo</label>
                        <input
                            id="ativo"
                            className='InputAtivo'
                            value={ativoFun}
                            onChange={e => setAtivoFun(e.target.value)}
                        />

                        <label htmlFor="cargo">Cargo Funcionário</label>
                        <input
                            id="cargo"
                            className='InputCargo'
                            value={cargoFun}
                            onChange={e => setCargoFun(e.target.value)}
                        />
                        <button onClick={criarFuncionario}>Criar Funcionário</button>
                    </section>
                </div>
            </S.ContainerPai>
        </>
    );
}