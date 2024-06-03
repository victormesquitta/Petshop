package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.CarrinhoCompras;
import br.senac.tads.petshop.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrinhoComprasRepository extends JpaRepository<CarrinhoCompras, Integer> {
    Optional<CarrinhoCompras> findByCliente(Cliente cliente);

}
