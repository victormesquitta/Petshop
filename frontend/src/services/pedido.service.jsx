import { backend } from "./api.axios";

export class PedidoService {

  async findAllPedidos(paginaAtual, tamanhoPagina, sortBy, sortOrder) { 
    return new Promise((resolve, reject) => {
      backend.get(`${'http://localhost:8080/api'}/pedidos`, { // Corrigido para /pedidos
        params: {
          page: paginaAtual,
          size: tamanhoPagina,
          sortBy: sortBy, 
          sortOrder: sortOrder 
        }
      })
        .then(data => {
          console.log("Dados do backend:", data.data); 
          resolve(data.data);
        })
        .catch(error => reject(error));
    });
  }

  async findPedidoById(id) {  
    try {
      const response = await backend.get(`${'http://localhost:8080/api'}/pedidos/${id}`); // Corrigido para /pedidos
      return response.data;
    } catch (error) {
      console.error(`Erro ao buscar pedido com ID ${id}:`, error);
      throw error;
    }
  }

  async deleteById(id) {
    try {
      const response = await backend.delete(`${'http://localhost:8080/api'}/pedidos/${id}`); // Corrigido para /pedidos
      return response.data; 
    } catch (error) {
      console.error(`Erro ao deletar pedido com ID ${id}:`, error);
      throw error;
    }
  }

  async update(id, pedido) { // Corrigido o nome do parâmetro para 'pedido'
    try {
      const response = await backend.put(`${'http://localhost:8080/api'}/pedidos/${id}`, pedido);
      return response.data;
    } catch (error) {
      console.error(`Erro ao atualizar pedido com ID ${id}:`, error);
      throw error; 
    }
  }

  async create(pedido) { // Corrigido o nome do parâmetro para 'pedido'
    try {
      const response = await backend.post(`${'http://localhost:8080/api'}/pedidos`, pedido);
      return response.data;
    } catch (error) {
      console.error('Erro ao criar pedido:', error); 
      throw error; 
    }
  }
}

const pedidoService = new PedidoService();
export { pedidoService };