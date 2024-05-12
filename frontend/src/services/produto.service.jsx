import { backend } from "./api.axios";

export class ProdutoService {

   async findAllProducts() {
        return new Promise((resolve, reject) => {
            backend.get(`${'http://localhost:8080/api'}/produtos`)
                .then(data => {
                    console.log("Dados do backend:", data.data); // Adicione este console.log
                    resolve(data.data);
                })
                .catch(error => reject(error));
        })
    }
}

const produtoService = new ProdutoService();
export { produtoService };