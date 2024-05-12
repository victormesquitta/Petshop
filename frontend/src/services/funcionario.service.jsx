import { backend } from "./api.axios";

export class FuncionarioService {
    async findByFuncionarioId(id) {
        try {
            const response = await backend.get(`/funcionario/${id}`);
            return response.data;
        } catch (error) {
            console.error('Erro ao buscar funcionário:', error);
            throw error; // Propaga o erro para ser tratado pelo chamador
        }
    }


    async  createFuncionario(novoFuncionario) {
        try {
          const response = await backend.post(`${'http://localhost:8080/api'}/funcionario`, novoFuncionario);
          console.log(response.data); // Exibe a mensagem do backend no console
          // Faça algo após a criação, como atualizar a lista de funcionários
        } catch (error) {
          console.error('Erro ao criar funcionário:', error);
          // Trate o erro adequadamente
        }
      }
}

const funcionarioService = new FuncionarioService();

export { funcionarioService };