package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
}