import * as S from './styles';
import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { categoriaService } from '../../services/categoria.service'; // Importe o serviço de categoria
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { FaUserAlt, FaObjectGroup, FaList, FaSearch, FaShippingFast, FaTrashAlt } from 'react-icons/fa';


export function DashBoardCategoria() {
  const [categorias, setCategorias] = useState([]);
  const [idCategoria, setIdCategoria] = useState('');
  const navigate = useNavigate();

  // Estado da paginação
  const [paginaAtual, setPaginaAtual] = useState(0); // Começa na página 0
  const [tamanhoPagina, setTamanhoPagina] = useState(10); // Tamanho da página
  const [totalPaginas, setTotalPaginas] = useState(1); // Total de páginas

  // Funções para controlar a navegação
  const proximaPagina = () => {
    if (paginaAtual < totalPaginas - 1) {
      setPaginaAtual(paginaAtual + 1);
      buscarCategorias(); // Busca os dados da próxima página
    }
  };

  const paginaAnterior = () => {
    if (paginaAtual > 0) {
      setPaginaAtual(paginaAtual - 1);
    }
  };

  const cadastroCategoria = () => {
    navigate('/cadastroCategoria')
  };

  async function buscarCategorias() {
    try {
      const data = await categoriaService.findAllCategorias(paginaAtual, tamanhoPagina, 'codCategoria', 'asc'); // Adapte para o serviço de categorias
      setCategorias(data.content);
      setTotalPaginas(data.totalPages);
    } catch (error) {
      console.error('Erro ao buscar categorias:', error);
      toast.error('Erro ao buscar categorias. Tente novamente mais tarde.');
    }
  };

  async function buscarCategoriaPorId() {
    try {
      const categoria = await categoriaService.findCategoriaById(idCategoria); // Adapte para o serviço de categorias
      // Adicione a categoria encontrada à lista atual
      setCategorias([categoria]);
    } catch (error) {
      console.error('Erro ao buscar categoria por ID:', error);
      toast.error('Erro ao buscar categoria por ID:', error);
    }
  }

  async function deletarCategoria(id) {
    if (window.confirm("Tem certeza que deseja deletar esta categoria?")) { // Confirmação antes de deletar
      try {
        await categoriaService.deleteById(id); // Adapte para o serviço de categorias
        toast.success('Categoria deletada com sucesso.');
        buscarCategorias(); // Atualiza a lista de categorias
      } catch (error) {
        console.error(`Erro ao deletar categoria com ID ${id}:`, error);
        toast.error('Erro ao deletar categoria.');
      }
    }
  }

  useEffect(() => {
    buscarCategorias();
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
          <button type="button" onClick={buscarCategorias}>Buscar Todos</button>
          <input
            type="number"
            placeholder="Código da Categoria" // Altere o placeholder
            value={idCategoria}
            onChange={e => setIdCategoria(e.target.value)}
          />
          <button type="button" onClick={buscarCategoriaPorId}>Buscar por ID</button>
          <button type="button" onClick={cadastroCategoria}>Cadastrar Categorias</button>
        </section>

        {/* Tabela de Categorias */}
        <table>
          <thead>
            <tr>
              <th>Código</th>
              <th>Nome</th>
              <th>Descrição</th>
            </tr>
          </thead>

          <tbody>
            {Array.isArray(categorias) && categorias.map((categoria) => (
              <tr key={categoria.codCategoria}>
                <td>{categoria.codCategoria}</td>
                <td>{categoria.nome}</td>
                <td>{categoria.descricao}</td>
                <td className='tdLixeira'>
                  {/* Botão de Deletar */}
                  <button type="button" onClick={() => deletarCategoria(categoria.codCategoria)}>
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