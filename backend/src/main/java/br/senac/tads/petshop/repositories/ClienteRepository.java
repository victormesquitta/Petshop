package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    boolean existsByCelular(String celular);
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByUsuario(String usuario);


    // ver como isso será aplicado
//    UserDetails findByUsuario(String usuario); //Metodo usado para consultar os usuarios
}
