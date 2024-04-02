package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
}
