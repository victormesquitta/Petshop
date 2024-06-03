package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Cartao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
    List<Cartao> findByClienteId(Integer clienteId);
}
