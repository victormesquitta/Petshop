package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
