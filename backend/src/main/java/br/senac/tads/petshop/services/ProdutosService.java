package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.petshop.dtos.ProdutosDTO;
import br.senac.tads.petshop.mappers.ProdutosDTOMapper;
import br.senac.tads.petshop.models.Produtos;
import br.senac.tads.petshop.repositories.ProdutosRepository;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository produtosRepository;
    
    @Autowired
    private ProdutosDTOMapper produtosMapper;

    public ProdutosService(ProdutosRepository produtosRepository, ProdutosDTOMapper produtosMapper){
        this.produtosRepository = produtosRepository;
        this.produtosMapper = produtosMapper;
    }

    public List<Produtos> listarProdutos(){
        List<Produtos> produtos = produtosRepository.findAll();
        return produtos;
    }

    public List<ProdutosDTO> listarProdutosDTOs(){
        List<Produtos> produtos = produtosRepository.findAll();
        return produtos.stream()
                    .map(produtosMapper::toDTO)
                    .collect(Collectors.toList());        
    }

    public Produtos obterProdutoPorId(Integer id){
        Optional<Produtos> produtoOptional = produtosRepository.findById(id);

        if (produtoOptional.isEmpty()) {
            throw new IllegalArgumentException("O produto não existe");
        }

        return produtoOptional.get();
    }

    public ProdutosDTO obterProdutoDTOporId(Integer id){
        Optional<Produtos> produtoOptional = produtosRepository.findById(id);
        return produtoOptional.map(produtosMapper::toDTO).orElse(null);
    }

    public void criarProduto(ProdutosDTO produtoDTO){
        Produtos produto = produtosMapper.toEntity(produtoDTO);
        produto.setDt_criacao(LocalDate.now());
        produto.setDt_modificacao(null);
        produtosRepository.save(produto);
    }

    public void atualizarProduto(Integer id, ProdutosDTO produtoDTO){
        Produtos produto = produtosMapper.toEntity(produtoDTO, id);
        produto.setDt_modificacao(LocalDate.now());
        produtosRepository.save(produto);
    }

    public void excluirProduto(Integer id, ProdutosDTO produtoDTO){
        produtosRepository.deleteById(id);
    }

    /* 
    falta verificar se existe 
    falta obter por categoria
    falta criar as categorias
    etc etc
    */

}