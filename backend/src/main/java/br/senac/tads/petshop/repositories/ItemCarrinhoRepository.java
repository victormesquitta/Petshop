package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Integer> {
}
