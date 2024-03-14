package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Integer> {
}
