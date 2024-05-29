import { backend } from "./api.axios";

export class SubCategoriaService {

  async findAllSubCategorias(paginaAtual, tamanhoPagina, sortBy, sortOrder) {
    return new Promise((resolve, reject) => {
      backend.get(`${'http://localhost:8080/api'}/subcategorias`, {
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