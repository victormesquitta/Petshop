import * as S from './styles';
import React, { useState, useEffect } from 'react';
import { produtoService } from '../../services/produto.service';

export function Estoque() {
    const [produtos, setProdutos] = useState([]);
    const [exibirProdutos, setExibirProdutos] = useState(false); // Estado para controlar a exibição
    const [idProduto, setIdProduto] = useState('');

    async function buscarProdutoPorId(id) {
        try {
            const produto = await produtoService.findById(id);
            console.log(`Produto com ID ${id}:`, produto);
            setProdutos([produto]); // Define o array de produtos com o produto encontrado
            setExibirProdutos(true); // Exibe os produtos
        } catch (error) {
            console.error(`Erro ao buscar produto com ID ${id}:`, error);
        }
    }

    async function buscarProdutos() {
        try {
            const data = await produtoService.findAllProducts();
            setProdutos(data);
            setExibirProdutos(true); // Exibe os produtos
        } catch (error) {
            console.error('Erro ao buscar produtos:', error);
        }
    };

    return (
        <S.ContainerPai>
            <h1>Produtos</h1>

            {exibirProdutos && ( // Renderiza a lista somente se exibirProdutos for true
                <ul>
                    {Array.isArray(produtos) && produtos.map((produto) => (
                        <li key={produto.id}>
                            <p>Codigo do Produto: {produto.codProduto}</p>
                            <p>Nome do Produto: {produto.nome}</p>
                            <p>Descrição do Produto: {produto.descricao} </p>
                            <p>Preço do Produto: {produto.preco}</p>
                            <p>Quantidade em Estoque: {produto.qtdEstoque}</p>
                            <p>Marca do Produto: {produto.marca}</p>
                            <p>Disponivel: {produto.disponivel ? 'Sim' : 'Não'}</p>
                            <p>Codigo da Categoria: {produto.cod}</p>
                            <p>Promoção: {produto.promocao ? 'Sim' : 'Não'}</p>
                        </li>
                    ))}
                </ul>
            )}

            <button type='button' onClick={buscarProdutos} >Buscar Todos</button>

            <input type='number' placeholder='ID do Produto' value={idProduto} onChange={e => setIdProduto(e.target.value)} />
            <button type='button' onClick={() => buscarProdutoPorId(idProduto)} >Buscar por ID</button>

        </S.ContainerPai>
    );
}

