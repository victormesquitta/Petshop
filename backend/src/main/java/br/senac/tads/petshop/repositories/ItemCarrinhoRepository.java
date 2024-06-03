package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Integer> {
    List<ItemCarrinho> findByCarrinhoComprasCodCarrinho(Integer codCarrinho);
}
