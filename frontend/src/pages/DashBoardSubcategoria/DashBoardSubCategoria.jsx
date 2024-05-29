import * as S from './styles';
import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { subcategoriaService } from '../../services/subcategoria.service'; // Importe o serviço de subcategoria
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { FaUserAlt, FaObjectGroup, FaList, FaSearch, FaShippingFast, FaTrashAlt } from 'react-icons/fa';


export function DashBoardSubCategoria() {
  const [subCategorias, setSubCategorias] = useState([]);
  const [idSubCategoria, setIdSubCategoria] = useState('');
  const [termoBusca, setTermoBusca] = useState(''); // Estado para o termo de busca
  const navigate = useNavigate();

  // Estado da paginação
  const [paginaAtual, setPaginaAtual] = useState(0); // Começa na página 0
  const [tamanhoPagina, setTamanhoPagina] = useState(10); // Tamanho da página
  const [totalPaginas, setTotalPaginas] = useState(1); // Total de páginas

  // Funções para controlar a navegação
  const proximaPagina = () => {
    if (paginaAtual < totalPaginas - 1) {
      setPaginaAtual(paginaAtual + 1);
      buscarSubCategorias(); // Busca os dados da próxima página
    }
  };

  const paginaAnterior = () => {
    if (paginaAtual > 0) {
      setPaginaAtual(paginaAtual - 1);
    }
  };

  const cadastroSubCategoria = () => {
    navigate('/adminsubcategoria')
  };

  async function buscarSubCategorias() {
    try {
      const data = await subcategoriaService.findAllSubCategorias(paginaAtual, tamanhoPagina, 'codSubCategoria', 'asc', termoBusca); // Adicione termoBusca
      setSubCategorias(data);
      console.log(data);
      setTotalPaginas(data.totalPages);
    } catch (error) {
      console.error('Erro ao buscar subcategorias:', error);
      toast.error('Erro ao buscar subcategorias. Tente novamente mais tarde.');
    }
  };

  async function buscarSubCategoriaPorId() {
    try {
      const subCategoria = await subcategoriaService.findSubCategoriaById(idSubCategoria);
      setSubCategorias([subCategoria]);

      // Atualiza o estado subCategorias com todas as subcategorias, incluindo a encontrada por ID
    } catch (error) {
      console.error('Erro ao buscar subcategoria por ID:', error);
      toast.error('Erro ao buscar subcategoria por ID.');
    }
  }

  async function deletarSubCategoria(id) {
    if (window.confirm("Tem certeza que deseja deletar esta subcategoria?")) {
      try {
        console.log(`ID da Subcategoria a ser deletada: ${id}`); // Use console.log para verificar o ID

        await subcategoriaService.deleteById(id);
        toast.success('Subcategoria deletada com sucesso.');
        buscarSubCategorias();
      } catch (error) {
        console.error(`Erro ao deletar subcategoria com ID ${id}:`, error);
        toast.error('Erro ao deletar subcategoria.');
      }
    }
  }

  useEffect(() => {
    buscarSubCategorias();
  }, [paginaAtual, termoBusca]);

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
          <button type="button" onClick={buscarSubCategorias}>Buscar Todos</button>
          <input
            type="number"
            placeholder="Código da Sub-Categoria"
            value={idSubCategoria}
            onChange={e => setIdSubCategoria(e.target.value)}
          />
          <button type="button" onClick={buscarSubCategoriaPorId}>Buscar por ID</button>
          <button type="button" onClick={cadastroSubCategoria}>Cadastrar Sub-Categorias</button>
        </section>

        {/* Tabela de Sub-Categorias */}
        <table>
          <thead>
            <tr>
              <th>Código</th>
              <th>Código Categoria</th>
              <th>Nome</th>
              <th>Descrição</th>
              <th>Destaque</th>
              <th>Ativa</th>
              <th>Data de Criação</th>
            </tr>
          </thead>

          <tbody>
            {Array.isArray(subCategorias) && subCategorias.map((subCategoria) => (
              <tr key={subCategoria.codSubcategoria}>
                <td>{subCategoria.codSubcategoria}</td>
                <td>{subCategoria.codCategoria}</td>
                <td>{subCategoria.nome}</td>
                <td>{subCategoria.descricao}</td>
                <td>{subCategoria.destaque ? 'Sim' : 'Não'}</td>
                <td>{subCategoria.ativa ? 'Sim' : 'Não'}</td>
                <td>{subCategoria.dtCriacao}</td>
                <td className='tdLixeira'>
                  {/* Botão de Deletar */}
                  <button type="button" onClick={() => deletarSubCategoria(subCategoria.codSubcategoria)}>
                    <FaTrashAlt className='iconLixeira' />
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