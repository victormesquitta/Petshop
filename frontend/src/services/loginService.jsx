import { backend } from "./api.axios"; 

export class LoginService {
  
  async login(email, senha) {
    try {
      const response = await backend.post(`${'http://localhost:8080/api'}/login`, { // Ajustar rota se necessário
        email,
        senha,
      });

      if (response.status === 200) {
        const token = response.data.token; // Ajustar se necessário
        return token;
      } else {
        throw new Error(response.data.message || 'Erro ao fazer login');
      }
    } catch (error) {
      console.error('Erro durante o login:', error);
      throw error;
    }
  }
}

const loginService = new LoginService();
export { loginService };