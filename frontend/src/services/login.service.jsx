import { backend } from "./api.axios"; 

export class LoginService {

  async login(email, senha) {
    const API_BASE_URL = 'http://localhost:8080';

    try {
      const response = await backend.post(`${API_BASE_URL}/auth/login`, { 
        email,
        senha 
      });

      if (response.status === 200) {
        const token = response.data.token;
        localStorage.setItem('token', token); // Store the token
        return true; // Login successful
      } else {
        // Handle non-200 responses (e.g., 401 Unauthorized)
        console.error("Login failed:", response.status); 
        return false;
      } 
    } catch (error) {
      console.error("Login error:", error);
      return false; // Login failed
    }
  }

  async register(email, senha, role) {
    const API_BASE_URL = 'http://localhost:8080';
    try {
      const response = await backend.post(`${API_BASE_URL}/auth/cadastro`, { 
        email,
        senha,
        role
      });

      if (response.status === 200) {
        return true; // Registration successful
      } else {
        console.error("Registration failed:", response.status);
        return false; 
      }
    } catch (error) {
      console.error("Registration error:", error);
      return false;
    }
  }

  // ... other potential methods like logout, getUserInfo (if needed)
}

const loginService = new LoginService();
export { loginService }; 