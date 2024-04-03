package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Funcionarios;

import org.springframework.data.jpa.repository.JpaRepository;

    public interface FuncionariosRepository extends JpaRepository<Funcionarios, Integer> {

}
