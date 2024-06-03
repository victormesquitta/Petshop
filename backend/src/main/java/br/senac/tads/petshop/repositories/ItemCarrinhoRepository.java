package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.CarrinhoCompras;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.models.ItemCarrinho;
import br.senac.tads.petshop.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Integer> {
    List<ItemCarrinho> findByCarrinhoComprasCodCarrinho(Integer codCarrinho);
    Optional<ItemCarrinho> findByCarrinhoComprasAndProduto(CarrinhoCompras carrinhoCompras, Produto produto);
}
