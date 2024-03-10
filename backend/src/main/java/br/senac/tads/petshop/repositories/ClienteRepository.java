package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    boolean existsByCelular(String celular);
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByUsuario(String usuario);
    Cliente findByCpf(String cpf);

    // ver como isso será aplicado
//    UserDetails findByUsuario(String usuario); //Metodo usado para consultar os usuarios
}
