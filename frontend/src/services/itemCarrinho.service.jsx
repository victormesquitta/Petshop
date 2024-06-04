import { backend } from "./api.axios"; // Assuming this is your configured Axios instance

export class CarrinhoService {
  async obterCarrinho() { 
    try {
      const response = await backend.get(`${'http://localhost:8080/api'}/carrinho`); // Ajustar a rota
      return response.data;
    } catch (error) {
      console.error('Erro ao obter o carrinho:', error);
      throw error; 
    }
  }

  async adicionarProduto(produtoId, quantidade = 1) {
    try {
      const response = await backend.post(`${'http://localhost:8080/api'}/carrinho/adicionar`, { 
        produtoId,
        quantidade 
      });
      return response.data; 
    } catch (error) {
      console.error('Erro ao adicionar produto ao carrinho:', error);
      throw error;
    }
  }

  async atualizarQuantidadeProduto(itemId, novaQuantidade) {
    try {
      const response = await backend.put(`${'http://localhost:8080/api'}/carrinho/atualizar/${itemId}`, { 
        quantidade: novaQuantidade 
      });
      return response.data;
    } catch (error) {
      console.error('Erro ao atualizar quantidade do produto:', error);
      throw error;
    }
  }

  async removerProduto(itemId) {
    try {
      const response = await backend.delete(`${'http://localhost:8080/api'}/carrinho/remover/${itemId}`);
      return response.data;
    } catch (error) {
      console.error('Erro ao remover produto do carrinho:', error);
      throw error;
    }
  }

  async limparCarrinho() {
    try {
      const response = await backend.delete(`${'http://localhost:8080/api'}/carrinho/limpar`);
      return response.data; 
    } catch (error) {
      console.error('Erro ao limpar o carrinho:', error);
      throw error;
    }
  }
}

const carrinhoService = new CarrinhoService();
export { carrinhoService };