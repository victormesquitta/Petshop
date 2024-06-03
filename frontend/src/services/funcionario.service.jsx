import { backend } from "./api.axios";

export class FuncionarioService {
  async findAllFuncionarios(paginaAtual, tamanhoPagina, sortBy, sortOrder) {
    return new Promise((resolve, reject) => {
      backend
        .get(`${'http://localhost:8080/api'}/funcionario`, {
          // Certifique-se de que o endpoint da API está correto
          params: {
            page: paginaAtual,
            size: tamanhoPagina,
            sortBy: sortBy,
            sortOrder: sortOrder,
          },
        })
        .then((data) => {
          console.log('Dados do backend:', data.data);
          resolve(data.data);
        })
        .catch((error) => reject(error));
    });
  }

  async findByFuncionarioId(id) {
    try {
      const response = await backend.get(
        `${'http://localhost:8080/api'}/funcionario/${id}`
      );
      return response.data;
    } catch (error) {
      console.error(`Erro ao buscar funcionário com ID ${id}:`, error);
      throw error;
    }
  }

  async deleteById(id) {
    try {
      const response = await backend.delete(
        `${'http://localhost:8080/api'}/funcionario/${id}`
      );
      return response.data;
    } catch (error) {
      console.error(`Erro ao deletar funcionário com ID ${id}:`, error);
      throw error;
    }
  }

  async updateFuncionario(id, funcionario) {
    try {
      const response = await backend.put(
        `${'http://localhost:8080/api'}/funcionario/${id}`,
        funcionario
      );
      return response.data;
    } catch (error) {
      console.error(
        `Erro ao atualizar funcionário com ID ${id}:`,
        error
      );
      throw error;
    }
  }

  async createFuncionario(funcionario) {
    try {
      const response = await backend.post(
        `${'http://localhost:8080/api'}/funcionario`,
        funcionario
      );
      return response.data;
    } catch (error) {
      console.error('Erro ao criar funcionário:', error);
      throw error;
    }
  }
}

const funcionarioService = new FuncionarioService();
export { funcionarioService };