package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

    public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
