package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.ListaDesejos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaDesejosRepository extends JpaRepository<ListaDesejos, Integer> {
}
