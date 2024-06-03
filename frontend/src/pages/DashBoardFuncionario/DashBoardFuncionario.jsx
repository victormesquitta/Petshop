import * as S from './styles';
import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { funcionarioService } from '../../services/funcionario.service'; // Importe o serviço do funcionário
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { FaUserAlt, FaObjectGroup, FaList, FaSearch, FaShippingFast, FaTrashAlt } from 'react-icons/fa';


export function DashBoardFuncionario() {
  const [funcionarios, setFuncionarios] = useState([]);
  const [idFuncionario, setIdFuncionario] = useState('');
  const navigate = useNavigate();

  // Estado da paginação
  const [paginaAtual, setPaginaAtual] = useState(0); // Começa na página 0
  const [tamanhoPagina, setTamanhoPagina] = useState(10); // Tamanho da página
  const [totalPaginas, setTotalPaginas] = useState(1); // Total de páginas

  // Funções para controlar a navegação
  const proximaPagina = () => {
    if (paginaAtual < totalPaginas - 1) {
      setPaginaAtual(paginaAtual + 1);
      buscarFuncionarios(); // Busca os dados da próxima página
    }
  };

  const paginaAnterior = () => {
    if (paginaAtual > 0) {
      setPaginaAtual(paginaAtual - 1);
    }
  };

  const cadastroFuncionario = () => {
    navigate('/adminfuncionario')
  };

  async function buscarFuncionarios() {
    try {
      const data = await funcionarioService.findAllFuncionarios(paginaAtual, tamanhoPagina, 'codFuncionario', 'asc'); // Adapte para o serviço de funcionários
      setFuncionarios(data);
      setTotalPaginas(data.totalPages);
    } catch (error) {
      console.error('Erro ao buscar funcionários:', error);
      toast.error('Erro ao buscar funcionários. Tente novamente mais tarde.');
    }
  };

  async function buscarFuncionarioPorId() {
    try {
      const funcionario = await funcionarioService.findByFuncionarioId(idFuncionario); // Adapte para o serviço de funcionários
      // Adicione o funcionário encontrado à lista atual
      setFuncionarios([funcionario]);
    } catch (error) {
      console.error('Erro ao buscar funcionário por ID:', error);
      toast.error('Erro ao buscar funcionário por ID:', error);
    }
  }

  async function deletarFuncionario(id) {
    if (window.confirm("Tem certeza que deseja deletar este funcionário?")) { // Confirmação antes de deletar
      try {
        await funcionarioService.deleteById(id); // Adapte para o serviço de funcionários
        toast.success('Funcionário deletado com sucesso.');
        buscarFuncionarios(); // Atualiza a lista de funcionários
      } catch (error) {
        console.error(`Erro ao deletar funcionário com ID ${id}:`, error);
        toast.error('Erro ao deletar funcionário.');
      }
    }
  }

  useEffect(() => {
    buscarFuncionarios();
  }, [paginaAtual]);

  return (
    <S.ContainerPai>
      <ToastContainer className='toastContainer' />
      <div className='divDashBoard'>
        <h1>DashBoard</h1>

        <Link to={'/dashboardfuncionario'} className='Link'><FaUserAlt className='icons' />Funcionario</Link>
        <Link to={'/dashboardproduto'} className='Link'><FaObjectGroup className='icons' /> Produtos</Link>
        <Link to={'/dashboardcategoria'} className='Link'><FaList className='icons' /> Categoria</Link>
        <Link to={'/dashboardpedidos'} className='Link'><FaShippingFast className='icons' />Pedidos</Link>
        <Link to={'/dashboardsubcategoria'} className='Link'><FaList className='icons' /> Sub-Categoria</Link>
      </div>

      <div className='divPrincipal'>
        <section className='section1'>
          <input placeholder='Pesquisar' className='InputPesquisar' />
          <FaSearch className="IconLupa" />
        </section>

        <section className='sectionButtons'>
          <button type="button" onClick={buscarFuncionarios}>Buscar Todos</button>
          <input
            type="number"
            placeholder="ID do Funcionário" 
            value={idFuncionario}
            onChange={e => setIdFuncionario(e.target.value)}
          />
          <button type="button" onClick={buscarFuncionarioPorId}>Buscar por ID</button>
          <button type="button" onClick={cadastroFuncionario}>Cadastrar Funcionários</button>
        </section>

        {/* Tabela de Funcionários */}
        <table>
          <thead>
            <tr>
              <th>Código</th>
              <th>Nome</th>
              <th>Email</th>
              <th>Cargo</th>
              <th>Nivel de Acesso</th>
              <th>Ativo</th>
              <th>Data de Modificação</th>
              <th>Data de Criação</th>
            </tr>
          </thead>

          <tbody>
            {Array.isArray(funcionarios) && funcionarios.map((funcionario) => (
              <tr key={funcionario.codFuncionario}>
                <td>{funcionario.codFuncionario}</td>
                <td>{funcionario.nome}</td>
                <td>{funcionario.email}</td>
                <td>{funcionario.cargo}</td>
                <td>{funcionario.nvlacesso}</td>
                <td>{funcionario.ativo ? 'Sim' : 'Não'}</td>
                <td>{funcionario.dtModificacao}</td>
                <td>{funcionario.dtCriacao}</td>
                <td className='tdLixeira'>
                  {/* Botão de Deletar */}
                  <button type="button" onClick={() => deletarFuncionario(funcionario.codFuncionario)}>
                    <FaTrashAlt className='iconLixeira' /> {/* Ícone de lixeira */}
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        {/* Botões de paginação */}
        <div className='paginacao'>
          <button disabled={paginaAtual === 0} onClick={paginaAnterior}>Anterior</button>
          <span>Página {paginaAtual + 1} de {totalPaginas}</span>
          <button disabled={paginaAtual === totalPaginas - 1} onClick={proximaPagina}>Próxima</button>
        </div>
      </div>
    </S.ContainerPai>
  );
}