import { backend } from "./api.axios"; 

export class LoginService {

  async login(email, senha) {
    const API_BASE_URL = 'http://localhost:8080';

    try {
      const response = await backend.post(`${API_BASE_URL}/login`, { 
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

  async registerCliente(clienteData) { // Assuming "clienteData" is an object containing all the form data
    const API_BASE_URL = 'http://localhost:8080';

    try {
      const response = await backend.post(`${API_BASE_URL}/api/clientes`, clienteData, {
        headers: {
          'Content-Type': 'application/json' 
        }
      });

      if (response.status === 201) { // Assuming 201 (Created) for successful registration
        console.log('Cliente registered successfully!');
        return true; 
      } else {
        console.error("Cliente registration failed:", response.status, response.data);

        // Handle specific error codes from the backend (if any)
        if (response.data && response.data.errors) {
          // Example: Display validation errors from Spring Boot
          const errorMessages = response.data.errors.map(error => error.defaultMessage);
          console.error("Validation errors:", errorMessages);
          // ... You could display these errors in your form UI
        }

        return false;
      }
    } catch (error) {
      console.error("Cliente registration error:", error);
      return false;
    }
  }
}

const loginService = new LoginService();
export { loginService }; 