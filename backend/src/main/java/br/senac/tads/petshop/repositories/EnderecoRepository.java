package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    List<Endereco> findByClienteId(Integer clienteId);
}
