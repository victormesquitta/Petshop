import * as S from './styles';
import React, { useState } from 'react';
import { produtoService } from '../../services/produto.service';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export function Estoque() {
  const [produtos, setProdutos] = useState([]);
  const [exibirProdutos, setExibirProdutos] = useState(false);
  const [idProduto, setIdProduto] = useState('');
  const [showModal, setShowModal] = useState(false);

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
  
  const closeModal = () => {
    setShowModal(false);
  };

  return (
    <S.ContainerPai>
      <ToastContainer />
      <h1>Produtos</h1>

      <section className='sectionButtons'>
        <button type="button" onClick={buscarProdutos} >Buscar Todos</button>
        <input type="number" placeholder="Código do Produto" value={idProduto} onChange={e => setIdProduto(e.target.value)} />
        <button type="button" onClick={buscarProdutoPorId} >Buscar por ID</button>
      </section>

      {showModal && (
        <div className={showModal ? 'show' : ''}>
          <div>
            <button onClick={closeModal}>×</button>
            {exibirProdutos && (
              <table>
                <thead>
                  <tr>
                    <th>Código do Produto</th>
                    <th>Nome do Produto</th>
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
            )}
          </div>
        </div>
      )}
    </S.ContainerPai>
  );
}