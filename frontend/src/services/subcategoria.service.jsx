import { backend } from "./api.axios";

export class SubCategoriaService {

  async findAllSubCategorias(paginaAtual, tamanhoPagina, sortBy, sortOrder) {
    try {
      const response = await backend.get(`${'http://localhost:8080/api'}/subcategorias`, {
        params: {
          page: paginaAtual,
          size: tamanhoPagina,
          sortBy: sortBy,
          sortOrder: sortOrder
        }
      });
  
      // Validar a resposta da API
      if (response.data && response.data.content) { // Verifica se 'content' existe
        return response.data.content; // Retorna a lista de subcategorias da página atual
      } else {
        throw new Error('Resposta inválida da API.');
      }
    } catch (error) {
      throw new Error(`Erro ao buscar subcategorias: ${error.message}`);
    }
  }

  async findSubCategoriaById(id) { // Método para buscar por ID
    try {
      const response = await backend.get(`${'http://localhost:8080/api'}/subcategorias/${id}`);
      return response.data;
    } catch (error) {
      console.error(`Erro ao buscar subcategoria com ID ${id}:`, error);
      throw error;
    }
  }

  async deleteById(id) {
    console.log("ID a ser deletado:", id); // Verifique o valor do ID aqui

    try {
      const response = await backend.delete(`${'http://localhost:8080/api'}/subcategorias/${id}`);
      return response.data; // Pode retornar dados ou apenas uma confirmação
    } catch (error) {
      console.error(`Erro ao deletar subcategoria com ID ${id}:`, error);
      throw error;
    }
  }

  async update(id, subCategoria) {
    try {
      const response = await backend.put(`${'http://localhost:8080/api'}/subcategorias/${id}`, subCategoria);
      return response.data;
    } catch (error) {
      console.error(`Erro ao atualizar subcategoria com ID ${id}:`, error);
      throw error;
    }
  }

  async create(subCategoria) {
    try {
      const response = await backend.post(`${'http://localhost:8080/api'}/subcategorias`, subCategoria);
      return response.data;
    } catch (error) {
      console.error('Erro ao criar subcategoria:', error);
      throw error;
    }
  }
}

const subcategoriaService = new SubCategoriaService();
export { subcategoriaService };