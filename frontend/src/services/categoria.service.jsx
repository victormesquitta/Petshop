import { backend } from "./api.axios";

const API_BASE = "http://localhost:8080/api"; 

export class CategoriaService { 

  async findAllCategorias(paginaAtual = 0, tamanhoPagina = 10, sortBy = "id", sortOrder = "asc") {
    try {
      const response = await backend.get(`${API_BASE}/categorias`, { 
        params: {
          page: paginaAtual,
          size: tamanhoPagina,
          sortBy,
          sortOrder,
        },
      });
      return response.data.content;
    } catch (error) {
      console.error("Erro ao buscar categorias:", error); 
      throw error; 
    }
  }

  async findCategoriaById(id) { 
    try {
      const response = await backend.get(`${API_BASE}/categorias/${id}`); 
      return response.data;
    } catch (error) {
      console.error(`Erro ao buscar categoria com ID ${id}:`, error);
      throw error; 
    }
  }

  async deleteCategoriaById(id) { 
    try {
      const response = await backend.delete(`${API_BASE}/categorias/${id}`); 
      return response.data; 
    } catch (error) {
      console.error(`Erro ao deletar categoria com ID ${id}:`, error);
      throw error; 
    }
  }

  async updateCategoria(id, categoria) { 
    try {
      const response = await backend.put(`${API_BASE}/categorias/${id}`, categoria); 
      return response.data; 
    } catch (error) {
      console.error(`Erro ao atualizar categoria com ID ${id}:`, error);
      throw error; 
    }
  }

  async createCategoria(categoria) { 
    try {
      const response = await backend.post(`${API_BASE}/categorias`, categoria); 
      return response.data; 
    } catch (error) {
      console.error("Erro ao criar categoria:", error);
      throw error; 
    }
  }
}

const categoriaService = new CategoriaService(); 
export { categoriaService }; 