package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
    List<ItemPedido> findByPedidoCodPedido(Integer codPedido);
    Optional<ItemPedido> findByPedidoAndProduto(Pedido pedido, Produto produto);
}
