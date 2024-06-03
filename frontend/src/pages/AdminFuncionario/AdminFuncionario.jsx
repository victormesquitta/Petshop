import * as S from './styles';
import React, { useState } from 'react';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import ImgPerfilFuncionario from '../../assets/images/ImgPerfilFuncionario.png'
import { Link } from 'react-router-dom';
import { funcionarioService } from '../../services/funcionario.service';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { FaArrowLeft, FaList, FaObjectGroup, FaSearch, FaShippingFast, FaUserAlt } from 'react-icons/fa';

export function AdminFuncionario() {
    const [nomeFun, setNomeFun] = useState('');
    const [senhaFun, setSenhaFun] = useState('');
    const [ativoFun, setAtivoFun] = useState(false); // Use boolean para ativo/inativo
    const [emailFun, setEmailFun] = useState('');
    const [nivelAcessoFun, setNivelAcessoFun] = useState('');
    const [cargoFun, setCargoFun] = useState('');
    const [idFuncionario, setIdFuncionario] = useState('');
    const [carregando, setCarregando] = useState(false);

    async function atualizarFuncionario(id) {
        setCarregando(true);

        if (!id || !nomeFun || !senhaFun || !emailFun || !nivelAcessoFun || !cargoFun || ativoFun === null) {
            toast.error('Preencha todos os campos!');
            setCarregando(false);
            return;
        }

        const funcionarioAtualizado = {
            nome: nomeFun,
            senha: senhaFun,
            ativo: ativoFun,
            email: emailFun,
            nvlacesso: nivelAcessoFun,
            cargo: cargoFun,
        };

        try {
            await funcionarioService.updateFuncionario(id, funcionarioAtualizado);
            console.log(`Funcionário com ID ${id} atualizado com sucesso!`);
            toast.success(`Funcionário com ID ${id} atualizado com sucesso!`);
            // Limpe o formulário após a atualização
            setNomeFun('');
            setSenhaFun('');
            setAtivoFun(false);
            setEmailFun('');
            setNivelAcessoFun('');
            setCargoFun('');
            setIdFuncionario(null);
        } catch (error) {
            console.error(`Erro ao atualizar funcionário com ID ${id}:`, error);
            toast.error(`Erro ao atualizar funcionário: ${error.message}`);
        } finally {
            setCarregando(false);
        }
    }

    async function criarFuncionario() {
        setCarregando(true);

        if (!nomeFun || !senhaFun || !emailFun || !nivelAcessoFun || !cargoFun || ativoFun === null) {
            toast.error('Preencha todos os campos!');
            setCarregando(false);
            return;
        }

        const novoFuncionario = {
            nome: nomeFun,
            senha: senhaFun,
            email: emailFun,
            cargo: cargoFun,
            nvlacesso: nivelAcessoFun,
            ativo: ativoFun,
        };

        try {
            await funcionarioService.createFuncionario(novoFuncionario);
            toast.success('Funcionário criado com sucesso!');
            // Limpe o formulário após a criação
            setNomeFun('');
            setSenhaFun('');
            setAtivoFun(false);
            setEmailFun('');
            setNivelAcessoFun('');
            setCargoFun('');
        } catch (error) {
            console.error('Erro ao criar funcionário:', error);
            toast.error(`Erro ao criar funcionário: ${error.message}`);
        } finally {
            setCarregando(false);
        }
    }

    async function deletarFuncionarioPorId(id) {
        if (!id) {
            toast.error('Digite um ID para deletar!');
            return;
        }

        if (window.confirm('Tem certeza que deseja deletar este funcionário?')) {
            try {
                await funcionarioService.deleteById(id);
                console.log(`Funcionário com ID ${id} deletado com sucesso.`);
                toast.success(`Funcionário com ID ${id} deletado com sucesso.`);
            } catch (error) {
                console.error(`Erro ao deletar funcionário com ID ${id}:`, error);
                toast.error(`Erro ao deletar funcionário com ID ${id}:`, error);
            }
        }
    }

    return (
        <>
            <S.ContainerPai>
                <ToastContainer />
                <div className='divDashBoard'>
                    <img src={ImgLogo} alt="Logo" />
                    <h1>DashBoard</h1>

                    <Link to={'/dashboardfuncionario'} className='Link'><FaArrowLeft className='icons' />Voltar</Link>

                </div>
                <div className='divPrincipal'>
                    <section className='section1'>
                        <input placeholder='Pesquisar' className='InputPesquisar' />
                        <FaSearch className="IconLupa" />
                        <img src={ImgPerfilFuncionario} alt="Perfil do Funcionário" />
                    </section>

                    <section className='section2'>
                        <h1>Novo Funcionário</h1>

                        <section className='section3'>
                            <section >
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
                            </section>

                            <section>
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
                            </section>

                            <section>
                                <label htmlFor="ativo">Funcionário Ativo</label>
                                <input
                                    id="ativo"
                                    className='InputAtivo'
                                    type="checkbox" // Use um checkbox para ativo/inativo
                                    checked={ativoFun}
                                    onChange={e => setAtivoFun(e.target.checked)}
                                />

                                <label htmlFor="cargo">Cargo Funcionário</label>
                                <input
                                    id="cargo"
                                    className='InputCargo'
                                    value={cargoFun}
                                    onChange={e => setCargoFun(e.target.value)}
                                />
                            </section>
                        </section>
                        <div>
                            <input
                                type='number'
                                placeholder='ID do Funcionario'
                                value={idFuncionario}
                                onChange={e => setIdFuncionario(e.target.value === '' ? '' : parseInt(e.target.value, 10) || null)}
                            />
                            <button type='button' onClick={() => deletarFuncionarioPorId(idFuncionario)} >Deletar por ID</button>
                            <button type='button' onClick={() => atualizarFuncionario(idFuncionario)} >Atualizar por ID</button>
                            <button type='button' onClick={criarFuncionario}>Criar Funcionario</button>
                        </div>
                    </section>
                </div>
            </S.ContainerPai>
        </>
    );
}