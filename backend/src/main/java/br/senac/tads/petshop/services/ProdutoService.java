package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.ProdutoDTO;
import br.senac.tads.petshop.mappers.ProdutoDTOMapper;
import br.senac.tads.petshop.models.Produto;
import br.senac.tads.petshop.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<Produto> listarProdutos(Pageable pageable){
        return produtosRepository.findAll(pageable);
    }

    public Page<ProdutoDTO> listarProdutosDTO(Pageable pageable){
        Page<Produto> produtosPage = listarProdutos(pageable);
        List<ProdutoDTO> produtosDTO = produtosPage.stream()
                    .map(produtosDTOMapper::toDTO)
                    .collect(Collectors.toList());
        return new PageImpl<>(produtosDTO, pageable, produtosPage.getTotalElements());
    }

    public Produto obterProdutoPorId(Integer id){
        Optional<Produto> produtoOptional = produtosRepository.findById(id);
        produtoExiste(produtoOptional);
        return produtoOptional.get();
    }

    public ProdutoDTO obterProdutoDTOPorId(Integer id){
        Optional<Produto> produtoOptional = produtosRepository.findById(id);
        produtoExiste(produtoOptional);
        return produtoOptional.map(produtosDTOMapper::toDTO).orElse(null);
    }

    public Produto obterProdutoPorNome(String nome){
        try {
            Produto produto = produtosRepository.findByNome(nome);
            if (produto == null) {
                throw new EntityNotFoundException("Produto não encontrado para o nome fornecido: " + nome);
            }
            return produto;
        } catch (Exception e) {
            throw new EntityNotFoundException("Erro ao buscar produto pelo nome: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Produto cadastrarProduto(ProdutoDTO produtoDTO){
        // valida se a subcategoria passada existe
        if(!subcategoriaService.subcategoriaExiste(produtoDTO.getCodSubcategoria())){
            throw new EntityNotFoundException("Não é possível adicionar um produto a uma subcategoria que não existe.");
        }
        Produto produto = produtosDTOMapper.toEntity(produtoDTO);
        produto.setDtCriacao(LocalDate.now());
        if(!produtosRepository.existsByNome(produtoDTO.getNome())){
            return produtosRepository.save(produto);
        } else{
            throw new DataIntegrityViolationException("Nome de produto já em uso: " + produtoDTO.getNome());
        }
    }

    @Transactional
    public void atualizarProduto(Integer id, ProdutoDTO produtoDTO){
        // valida a existência do produto
        Produto produtoExistente = obterProdutoPorId(id);

        // valida se a subcategoria passada existe
        if(!subcategoriaService.subcategoriaExiste(produtoDTO.getCodSubcategoria())){
            throw new EntityNotFoundException("Não é possível adicionar um produto a uma subcategoria que não existe.");
        }
        LocalDate dataCriacao = produtoExistente.getDtCriacao();
        Produto produto = produtosDTOMapper.toEntity(produtoDTO, id);
        produto.setDtCriacao(dataCriacao);
        produtosRepository.save(produto);
    }

    @Transactional
    public void excluirProduto(Integer id){
        produtoExiste(id);
        produtosRepository.deleteById(id);
    }

    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validação
    public boolean produtoExiste(Integer id){
        Optional<Produto> optionalProduto = produtosRepository.findById(id);
        if(optionalProduto.isEmpty()){
            throw new EntityNotFoundException("Nenhum produto encontrado para o ID fornecido.");
        }
        return true;
    }
    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência
    public boolean produtoExiste(Optional<Produto> optionalProduto){
        if(optionalProduto.isEmpty()){
            throw new EntityNotFoundException("Nenhum produto encontrado para o ID fornecido.");
        }
        return true;
    }
}