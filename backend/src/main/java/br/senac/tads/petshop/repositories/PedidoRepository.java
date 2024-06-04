package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.models.Pedido;

import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByClienteCodCliente(Integer codCliente);
    Optional<Pedido> findByCliente(Cliente cliente);
}
