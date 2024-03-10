package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
