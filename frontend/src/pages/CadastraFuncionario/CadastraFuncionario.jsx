import * as S from './styles';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import ImgPerfilFuncionario from '../../assets/images/ImgPerfilFuncionario.png';
import { Link } from 'react-router-dom';
import { FaList, FaObjectGroup, FaSearch, FaShippingFast, FaUserAlt } from 'react-icons/fa';
import { useState } from 'react';
import { funcionarioService } from '../../services/funcionario.service';

export function CadastraFuncionario() {
    const [nomeFun, setNomeFun] = useState('');
    const [senhaFun, setSenhaFun] = useState('');
    const [ativoFun, setAtivoFun] = useState('');
    const [emailFun, setEmailFun] = useState('');
    const [nivelAcessoFun, setNivelAcessoFun] = useState('');
    const [cargoFun, setCargoFun] = useState('');
    const [idFuncionario, setIdFuncionario] = useState(null); // Adicione um estado para o ID do funcionário

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
            setNomeFun('');
            setSenhaFun('');
            setAtivoFun('');
            setEmailFun('');
            setNivelAcessoFun('');
            setCargoFun('');

        } catch (error) {
            console.error('Erro ao criar funcionário:', error);
            // Exiba uma mensagem de erro ao usuário
        }
    }
    
    async function deletarFuncionarioPorId(id) {
        try {
            await funcionarioService.deleteFuncionario(id);
            console.log('Funcionário com ID ' + id + ' deletado com sucesso');
            // Adicione lógica para atualizar a lista de funcionários, se necessário
        } catch (error) {
            console.error('Erro ao deletar funcionário:', error);
            // Exiba uma mensagem de erro ao usuário
        }
    }

    async function atualizarFuncionario(id) {
        try {
            const funcionarioAtualizado = {
                nome: nomeFun,
                senha: senhaFun,
                ativo: ativoFun,
                email: emailFun,
                nivelAcesso: nivelAcessoFun,
                cargo: cargoFun
            };

            await funcionarioService.updateFuncionario(id, funcionarioAtualizado);
            console.log('Funcionário com ID ' + id + ' atualizado com sucesso');
            // Adicione lógica para atualizar a lista de funcionários, se necessário
        } catch (error) {
            console.error('Erro ao atualizar funcionário:', error);
            // Exiba uma mensagem de erro ao usuário
        }
    }


    return (
        <>
            <S.ContainerPai>
                <div className='divDashBoard'>
                    <img src={ImgLogo} alt="Logo" />
                    <h1>DashBoard</h1>

                    <Link to={'/cadastrofuncionario'} className='Link'><FaUserAlt className='icons' />Funcionario</Link>
                    <Link to={'/dashboardproduto'} className='Link'><FaObjectGroup className='icons' /> Produtos</Link>
                    <Link to={'/admincategoria'} className='Link'><FaList className='icons' /> Categoria</Link>
                    <Link to={'/adminpedidos'} className='Link'><FaShippingFast className='icons' />Pedidos</Link>

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
                            </section>
                        </section>
                        <div>
                            <input
                                type='number'
                                placeholder='ID do Funcionario'
                                value={idFuncionario}
                                onChange={e => setIdFuncionario(parseInt(e.target.value, 10) || null)} // Converte para número ou null
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