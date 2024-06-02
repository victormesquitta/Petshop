import { backend } from "./api.axios";

export class ProdutoService {

  async findAllProducts(paginaAtual, tamanhoPagina, sortBy, sortOrder) {
    return new Promise((resolve, reject) => {
      backend.get(`${'http://localhost:8080/api'}/produtos`, {
        params: {
          page: paginaAtual,
          size: tamanhoPagina,
          sortBy: sortBy, // Passar o campo de ordenação
          sortOrder: sortOrder // Passar a ordem de ordenação
        }
      })
        .then(data => {
          console.log("Dados do backend:", data.data); // Adicione este console.log
          resolve(data.data);
        })
        .catch(error => reject(error));
    })
  }

  async findProductById(id) { // Método para buscar por ID
    try {
      const response = await backend.get(`${'http://localhost:8080/api'}/produtos/${id}`);
      return response.data;
    } catch (error) {
      console.error(`Erro ao buscar produto com ID ${id}:`, error);
      throw error;
    }
  }

  async deleteById(id) {
    try {
      const response = await backend.delete(`${'http://localhost:8080/api'}/produtos/${id}`);
      return response.data; // Pode retornar dados ou apenas uma confirmação
    } catch (error) {
      console.error(`Erro ao deletar produto com ID ${id}:`, error);
      throw error;
    }
  }

  async update(id, produto) {
    try {
      const response = await backend.put(`${'http://localhost:8080/api'}/produtos/${id}`, produto);
      return response.data;
    } catch (error) {
      console.error(`Erro ao atualizar produto com ID ${id}:`, error);
      throw error;
    }
  }

  async create(produto) {
    try {
      const response = await backend.post(`${'http://localhost:8080/api'}/produtos`, produto, { // Envia 'produto' diretamente
        headers: {
          'Content-Type': 'application/json' // Define o Content-Type como JSON
        }
      });
      return response.data;
    } catch (error) {
      console.error('Erro ao criar produto:', error);
      throw error;
    }
  }
}

const produtoService = new ProdutoService();
export { produtoService };