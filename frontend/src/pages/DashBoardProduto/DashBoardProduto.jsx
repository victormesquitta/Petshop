import * as S from './styles';
import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { produtoService } from '../../services/produto.service';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { FaUserAlt, FaObjectGroup, FaList, FaSearch, FaShippingFast, FaTrashAlt } from 'react-icons/fa';
import { Navigate } from 'react-router-dom';

export function DashBoardProduto() {
  const [produtos, setProdutos] = useState([]);
  const [idProduto, setIdProduto] = useState('');
  const navigate = useNavigate();

  // Estado da paginação
  const [paginaAtual, setPaginaAtual] = useState(0); // Começa na página 0
  const [tamanhoPagina, setTamanhoPagina] = useState(15); // Tamanho da página
  const [totalPaginas, setTotalPaginas] = useState(1); // Total de páginas

  // Funções para controlar a navegação
  const proximaPagina = () => {
    if (paginaAtual < totalPaginas - 1) {
      setPaginaAtual(paginaAtual + 1);
      buscarProdutos(); // Busca os dados da próxima página
    }
  };

  const paginaAnterior = () => {
    if (paginaAtual > 0) {
      setPaginaAtual(paginaAtual - 1);
    }
  };

  const cadastroProduto = () => {
    navigate('/cadastroProduto')
  };


  async function buscarProdutos() {
    try {
      const data = await produtoService.findAllProducts(paginaAtual, tamanhoPagina, 'codProduto', 'asc');
      setProdutos(data.content);
      setTotalPaginas(data.totalPages);
    } catch (error) {
      console.error('Erro ao buscar produtos:', error);
      toast.error('Erro ao buscar produtos. Tente novamente mais tarde.');
    }
  };

  async function buscarProdutoPorId() {
    try {
      const produto = await produtoService.findProductById(idProduto);
      // Adicione o produto encontrado à lista atual
      setProdutos([produto]);
    } catch (error) {
      console.error('Erro ao buscar produto por ID:', error);
      toast.error('Erro ao buscar produto por ID:', error);
    }
  }

  async function deletarProduto(id) {
    if (window.confirm("Tem certeza que deseja deletar este produto?")) { // Confirmação antes de deletar
      try {
        await produtoService.deleteById(id);
        toast.success('Produto deletado com sucesso.');
        buscarProdutos(); // Atualiza a lista de produtos
      } catch (error) {
        console.error(`Erro ao deletar produto com ID ${id}:`, error);
        toast.error('Erro ao deletar produto.');
      }
    }
  }

  useEffect(() => {
    buscarProdutos();
  }, [paginaAtual]);

  return (
    <S.ContainerPai>
      <ToastContainer className='toastContainer' />
      <div className='divDashBoard'>
        <h1>DashBoard</h1>
        <Link to={'/cadastrafuncionario'} className='Link'><FaUserAlt className='icons' />Funcionario</Link>
        <Link to={'/cadastroproduto'} className='Link'><FaObjectGroup className='icons' />Produtos</Link>
        <Link to={''} className='Link'><FaList className='icons' />Categoria</Link>
        <Link to={'/adminpedidos'} className='Link'><FaShippingFast className='icons' />Pedidos</Link>
      </div>

      <div className='divPrincipal'>
        <section className='section1'>
          <input placeholder='Pesquisar' className='InputPesquisar' />
          <FaSearch className="IconLupa" />
        </section>

        <section className='sectionButtons'>
          <button type="button" onClick={buscarProdutos}>Buscar Todos</button>
          <input
            type="number"
            placeholder="Código do Produto"
            value={idProduto}
            onChange={e => setIdProduto(e.target.value)}
          />
          <button type="button" onClick={buscarProdutoPorId}>Buscar por ID</button>
          <button type="button" onClick={cadastroProduto}>Cadastrar Produtos</button>
        </section>

        {/* Tabela de Produtos */}
        <table>
          <thead>
            <tr>
              <th>Código</th>
              <th>Código da Sub-Categoria</th>
              <th>Nome</th>
              <th>Descrição</th>
              <th>Preço</th>
              <th>Quantidade em Estoque</th>
              <th>Marca</th>
              <th>Disponível</th>
              <th>Promoção</th>
            </tr>
          </thead>

          <tbody>
            {Array.isArray(produtos) && produtos.map((produto) => (
              <tr key={produto.codProduto}>
                <td>{produto.codProduto}</td>
                <td>{produto.codSubcategoria}</td>
                <td>{produto.nome}</td>
                <td>{produto.descricao}</td>
                <td>{produto.preco}</td>
                <td>{produto.qtdEstoque}</td>
                <td>{produto.marca}</td>
                <td>{produto.disponivel ? 'Sim' : 'Não'}</td>
                <td>{produto.promocao ? 'Sim' : 'Não'}</td>
                <td className='tdLixeira'>
                  {/* Botão de Deletar */}
                  <button type="button" onClick={() => deletarProduto(produto.codProduto)}>
                    <FaTrashAlt className='iconLixeira'/> {/* Ícone de lixeira */}
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