package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.ProdutoDTO;
import br.senac.tads.petshop.mappers.ProdutoDTOMapper;
import br.senac.tads.petshop.models.Produto;
import br.senac.tads.petshop.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final SubcategoriaService subcategoriaService;
    private final ProdutoRepository produtosRepository;
    private final ProdutoDTOMapper produtosDTOMapper;

    @Autowired
    public ProdutoService(SubcategoriaService subcategoriaService, ProdutoRepository produtosRepository, ProdutoDTOMapper produtosDTOMapper){
        this.subcategoriaService = subcategoriaService;
        this.produtosRepository = produtosRepository;
        this.produtosDTOMapper = produtosDTOMapper;
    }

    public List<Produto> listarProdutos(){
        List<Produto> produtos = produtosRepository.findAll();
        return produtos;
    }

    public List<ProdutoDTO> listarProdutosDTO(){
        List<Produto> produtos = produtosRepository.findAll();
        return produtos.stream()
                    .map(produtosDTOMapper::toDTO)
                    .collect(Collectors.toList());        
    }

    public ProdutoDTO obterProdutoPorId(Integer id){
        Optional<Produto> produtoOptional = produtosRepository.findById(id);
        produtoExiste(produtoOptional);
        return produtoOptional.map(produtosDTOMapper::toDTO).orElse(null);
    }

    public ProdutoDTO obterProdutoDTOPorId(Integer id){
        Optional<Produto> produtoOptional = produtosRepository.findById(id);
        produtoExiste(produtoOptional);
        return produtoOptional.map(produtosDTOMapper::toDTO).orElse(null);
    }

    @Transactional
    public Produto cadastrarProduto(ProdutoDTO produtoDTO){
        // valida se a categoria passada existe
        if(!subcategoriaService.subcategoriaExiste(produtoDTO.getCodProduto())){
            throw new DataIntegrityViolationException("Não é possível adicionar um produto a uma subcategoria que não existe.");
        }
        Produto produto = produtosDTOMapper.toEntity(produtoDTO);
        produto.setDtCriacao(LocalDate.now());
        if(!produtosRepository.existsByNome(produtoDTO.getNome())){
            return produtosRepository.save(produto);
        } else{
            throw new DataIntegrityViolationException("Nome de produto já em uso: " + produtoDTO.getNome());
        }
    }

    public void atualizarProduto(Integer id, ProdutoDTO produtoDTO){
        produtoExiste(id);
        Produto produto = produtosDTOMapper.toEntity(produtoDTO, id);
        produto.setDtCriacao(produto.getDtCriacao());
        produto.setCodProduto(id);
        produtosRepository.save(produto);
    }

    public void excluirProduto(Integer id){
        produtoExiste(id);
        produtosRepository.deleteById(id);
    }

    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validaçaõ
    public void produtoExiste(Integer id){
        Optional<Produto> optionalProduto = produtosRepository.findById(id);
        if(optionalProduto.isEmpty()){
            throw new EntityNotFoundException("Nenhum produto encontrado para o ID fornecido.");
        }
    }
    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência
    public void produtoExiste(Optional<Produto> optionalProduto){
        if(optionalProduto.isEmpty()){
            throw new EntityNotFoundException("Nenhum produto encontrado para o ID fornecido.");
        }
    }
}