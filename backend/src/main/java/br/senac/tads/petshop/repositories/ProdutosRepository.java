package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {
}