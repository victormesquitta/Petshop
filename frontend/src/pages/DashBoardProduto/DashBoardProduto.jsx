import * as S from './styles';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { produtoService } from '../../services/produto.service';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { FaUserAlt, FaObjectGroup, FaList, FaSearch } from 'react-icons/fa';

export function DashBoardProduto() {
  const [produtos, setProdutos] = useState([]);
  const [exibirProdutos, setExibirProdutos] = useState(false);
  const [idProduto, setIdProduto] = useState('');

  async function buscarProdutos() {
    try {
      const data = await produtoService.findAllProducts();
      setProdutos(data);
      setExibirProdutos(true);
      setShowModal(true); // Exiba o modal ao buscar todos os produtos
    } catch (error) {
      console.error('Erro ao buscar produtos:', error);
      toast.error('Erro ao buscar produtos:', error);
    }
  };

  async function buscarProdutoPorId() {
    try {
      const produto = await produtoService.findProductById(idProduto);
      setProdutos([produto]); // Define um array com o produto encontrado
      setExibirProdutos(true); // Exibe os produtos
      setShowModal(true); // Exibe o modal
    } catch (error) {
      console.error('Erro ao buscar produto por ID:', error);
      toast.error('Erro ao buscar produto por ID:', error);
    }
  }

  return (
    <S.ContainerPai>
      <ToastContainer className='toastContainer' />
      <div className='divDashBoard'>
        <h1>DashBoard</h1>
        <Link to={'/cadastrafuncionario'} className='Link'><FaUserAlt className='icons' />Funcionario</Link>
        <Link to={'/cadastroproduto'} className='Link'><FaObjectGroup className='icons' /> Produtos</Link>
        <Link to={''} className='Link'><FaList className='icons' /> Categoria</Link>
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
        </section>

        {/* Tabela de Produtos */}
        <table>
          <thead>
            <tr>
              <th>Código</th>
              <th>Nome</th>
              <th>Descrição</th>
              <th>Preço</th>
              <th>Quantidade em Estoque</th>
              <th>Marca</th>
              <th>Disponível</th>
              <th>Código da Categoria</th>
              <th>Promoção</th>
            </tr>
          </thead>
          
          <tbody>
            {Array.isArray(produtos) && produtos.map((produto) => (
              <tr key={produto.id}>
                <td>{produto.codProduto}</td>
                <td>{produto.nome}</td>
                <td>{produto.descricao}</td>
                <td>{produto.preco}</td>
                <td>{produto.qtdEstoque}</td>
                <td>{produto.marca}</td>
                <td>{produto.disponivel ? 'Sim' : 'Não'}</td>
                <td>{produto.dtCriacao}</td> 
                <td>{produto.promocao ? 'Sim' : 'Não'}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </S.ContainerPai>
  );
}