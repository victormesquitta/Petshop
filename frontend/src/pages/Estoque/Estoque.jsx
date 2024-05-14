import * as S from './styles';
import React, { useState, useEffect } from 'react';
import { produtoService } from '../../services/produto.service';
import { toast, ToastContainer } from 'react-toastify'; // Importe o toast
import 'react-toastify/dist/ReactToastify.css'; // Importe o CSS do toast
function Estoque() {
  const [produtos, setProdutos] = useState([]);
  const [exibirProdutos, setExibirProdutos] = useState(false);
  const [idProduto, setIdProduto] = useState('');
  const [showModal, setShowModal] = useState(false); 

  const buscarProdutos = async () => {
    // Lógica para buscar todos os produtos (substitua com sua implementação)
    const produtos = await fetch('https://api.example.com/produtos').then(res => res.json());
    setProdutos(produtos);
    setExibirProdutos(true);
    setShowModal(true); 
  };

  const buscarProdutoPorId = async () => {
    // Lógica para buscar um produto por ID (substitua com sua implementação)
    const produto = await fetch(`https://api.example.com/produtos/${idProduto}`).then(res => res.json());
    setProdutos([produto]); // Define um array com o produto encontrado
    setExibirProdutos(true);
    setShowModal(true); 
  };

  const closeModal = () => {
    setShowModal(false);
  };

  return (
    <S.ContainerPai>
      <ToastContainer />
      <h1>Produtos</h1>

      <S.Botoes>
        <S.Botao type="button" onClick={buscarProdutos} >Buscar Todos</S.Botao>
        <S.Input type="number" placeholder="ID do Produto" value={idProduto} onChange={e => setIdProduto(e.target.value)} />
        <S.Botao type="button" onClick={() => buscarProdutoPorId(idProduto)} >Buscar por ID</S.Botao>
      </S.Botoes>

      {showModal && (
        <S.Modal className={showModal ? 'show' : ''}>
          <S.ModalContent>
            <S.CloseButton onClick={closeModal}>×</S.CloseButton>
            {exibirProdutos && (
              <S.Tabela>
                <S.CabecalhoTabela>
                  <S.LinhaTabela>
                    <th>Código do Produto</th>
                    <th>Nome do Produto</th>
                    <th>Descrição</th>
                    <th>Preço</th>
                    <th>Quantidade em Estoque</th>
                    <th>Marca</th>
                    <th>Disponível</th>
                    <th>Código da Categoria</th>
                    <th>Promoção</th>
                  </S.LinhaTabela>
                </S.CabecalhoTabela>
                <tbody>
                  {Array.isArray(produtos) && produtos.map((produto) => (
                    <S.LinhaTabela key={produto.id}>
                      <td>{produto.codProduto}</td>
                      <td>{produto.nome}</td>
                      <td>{produto.descricao}</td>
                      <td>{produto.preco}</td>
                      <td>{produto.qtdEstoque}</td>
                      <td>{produto.marca}</td>
                      <td>{produto.disponivel ? 'Sim' : 'Não'}</td>
                      <td>{produto.cod}</td>
                      <td>{produto.promocao ? 'Sim' : 'Não'}</td>
                    </S.LinhaTabela>
                  ))}
                </tbody>
              </S.Tabela>
            )}
          </S.ModalContent>
        </S.Modal>
      )}
    </S.ContainerPai>
  );
}