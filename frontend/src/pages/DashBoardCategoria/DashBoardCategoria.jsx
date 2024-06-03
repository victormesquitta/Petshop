import * as S from './styles';
import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { categoriaService } from '../../services/categoria.service';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { 
  FaUserAlt, 
  FaSearch, 
  FaTrashAlt,
  FaObjectGroup,
  FaList,
  FaShippingFast,
} from 'react-icons/fa';

export function DashBoardCategoria() {
  const [categorias, setCategorias] = useState([]);
  const [idCategoria, setIdCategoria] = useState('');
  const [termoBusca, setTermoBusca] = useState('');
  const navigate = useNavigate();

  const [paginaAtual, setPaginaAtual] = useState(0);
  const [tamanhoPagina, setTamanhoPagina] = useState(10);
  const [totalPaginas, setTotalPaginas] = useState(1);

  const proximaPagina = () => {
    if (paginaAtual < totalPaginas - 1) {
      setPaginaAtual(paginaAtual + 1);
    }
  };

  const paginaAnterior = () => {
    if (paginaAtual > 0) {
      setPaginaAtual(paginaAtual - 1);
    }
  };

  const cadastroCategoria = () => {
    navigate('/admincategoria'); 
  };

  async function buscarCategorias() {
    try {
      const data = await categoriaService.findAllCategorias(
        paginaAtual, 
        tamanhoPagina, 
        'codCategoria',
        'asc', 
        termoBusca 
      );
      setCategorias(data); 
      console.log(data);
      setTotalPaginas(data.totalPages); 
    } catch (error) {
      console.error('Erro ao buscar categorias:', error);
      toast.error('Erro ao buscar categorias. Tente novamente mais tarde.');
    }
  };

  async function buscarCategoriaPorId() {
    try {
      const categoria = await categoriaService.findCategoriaById(idCategoria);
      setCategorias([categoria]); // Display the fetched category
    } catch (error) {
      console.error('Erro ao buscar categoria por ID:', error);
      toast.error('Erro ao buscar categoria por ID.');
    }
  }

  async function deletarCategoria(id) {
    if (window.confirm("Tem certeza que deseja deletar esta categoria?")) {
      try {
        await categoriaService.deleteCategoriaById(id);
        toast.success('Categoria deletada com sucesso.');
        buscarCategorias(); // Refresh category list after deletion
      } catch (error) {
        console.error(`Erro ao deletar categoria com ID ${id}:`, error);
        toast.error('Erro ao deletar categoria.');
      }
    }
  }

  useEffect(() => {
    buscarCategorias(); // Fetch categories on component mount and page change
  }, [paginaAtual, tamanhoPagina, termoBusca]); 

  return (
    <S.ContainerPai>
      <ToastContainer className="toastContainer" />
      <div className="divDashBoard">
        <h1>DashBoard</h1>

        <Link to={'/dashboardfuncionario'} className='Link'><FaUserAlt className='icons' />Funcionario</Link>
        <Link to={'/dashboardproduto'} className='Link'><FaObjectGroup className='icons' /> Produtos</Link>
        <Link to={'/dashboardcategoria'} className='Link'><FaList className='icons' /> Categoria</Link>
        <Link to={'/dashboardpedidos'} className='Link'><FaShippingFast className='icons' />Pedidos</Link>
        <Link to={'/dashboardsubcategoria'} className='Link'><FaList className='icons' /> Sub-Categoria</Link>
      </div>

      <div className="divPrincipal">
        <section className="section1">
          <input
            type="text"
            placeholder="Pesquisar Categorias..."
            className="InputPesquisar"
            value={termoBusca}
            onChange={(e) => setTermoBusca(e.target.value)}
          />
          <FaSearch className="IconLupa" />
        </section>

        <section className="sectionButtons">
          <button type="button" onClick={buscarCategorias}>
            Buscar Todos
          </button>
          <input
            type="number"
            placeholder="Código da Categoria"
            value={idCategoria}
            onChange={(e) => setIdCategoria(e.target.value)}
          />
          <button type="button" onClick={buscarCategoriaPorId}>
            Buscar por ID
          </button>
          <button type="button" onClick={cadastroCategoria}> 
             Cadastrar Categoria 
          </button>
        </section>

        {/* Table for displaying categories */}
        <table>
          <thead>
            <tr>
              <th>Código</th>
              <th>Nome</th>
              <th>Descrição</th>
              <th>Destaque</th>
              <th>Ativa</th>
              <th>Data de Criação</th>
            </tr>
          </thead>
          <tbody>
          {Array.isArray(categorias) && categorias.map((categoria) => (
              <tr key={categoria.codCategoria}>
                <td>{categoria.codCategoria}</td>
                <td>{categoria.nome}</td>
                <td>{categoria.descricao}</td>
                <td>{categoria.destaque ? 'Sim' : 'Não'}</td> 
                <td>{categoria.ativa ? 'Sim' : 'Não'}</td> 
                <td>{categoria.dtCriacao}</td> 
                  <button type="button" onClick={() => deletarCategoria(categoria.codCategoria)}>
                    <FaTrashAlt className="iconLixeira" />
                  </button>
              </tr>
            ))}
          </tbody>
        </table>

        {/* Pagination controls */}
        <div className="paginacao">
          <button disabled={paginaAtual === 0} onClick={paginaAnterior}>
            Anterior
          </button>
          <span>
            Página {paginaAtual + 1} de {totalPaginas}
          </span>
          <button
            disabled={paginaAtual === totalPaginas - 1}
            onClick={proximaPagina}
          >
            Próxima
          </button>
        </div>
      </div>
    </S.ContainerPai>
  );
}