package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer> {
    boolean existsByNome(String nome);
}
