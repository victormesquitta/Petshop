import * as S from './styles';
import React, { useState, useEffect } from 'react';
import { produtoService } from '../../services/produto.service';

export function Estoque() {
    const [produtos, setProdutos] = useState([]);
    const [carregando, setCarregando] = useState(true);
    const [erro, setErro] = useState(null);

    useEffect(() => {
        const buscarProdutos = async () => {
            try {
                const data = await produtoService.findAllProducts();
                setProdutos(data);

            } catch (error) {
                setErro(error);
            } finally {
                setCarregando(false);
            }
        };

        buscarProdutos();
    }, []);

    if (carregando) {
        return <div>Carregando produtos...</div>;
    }

    return (
        <S.ContainerPai>
            <h1>Produtos</h1>

            <ul>
                {Array.isArray(produtos) && produtos.map((produto) => (
                    <li key={produto.id}> {/* Adicione a key aqui */}
                        <h2>Nome do Produto: {produto.nome}</h2>
                        <p>Descrição do Produto: {produto.descricao} </p>
                        <p>Preço do Produto: {produto.preco}</p>
                        <p>Quantidade em Estoque: {produto.qtdEstoque}</p>
                        <p>Marca do Produto: {produto.marca}</p>
                        <p>Disponivel: {produto.disponivel ? 'Sim' : 'Não'}</p>
                        <p>Promoção: {produto.promocao ? 'Sim' : 'Não'}</p>
                    </li>
                ))}
            </ul>
        </S.ContainerPai>
    );
}