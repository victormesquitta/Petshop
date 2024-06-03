package br.senac.tads.petshop.repositories;

import br.senac.tads.petshop.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    boolean existsByNome(String nome);
    Produto findByNome(String nome);

    // ver a necessidade desse método
//    Page<Produto> findAll(Pageable pageable);
}