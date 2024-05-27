package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.senac.tads.petshop.dtos.AvaliacaoDTO;
import br.senac.tads.petshop.mappers.AvaliacaoDTOMapper;
import br.senac.tads.petshop.models.Avaliacao;
import br.senac.tads.petshop.repositories.AvaliacaoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AvaliacaoService {
    

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoDTOMapper avaliacaoDTOMapper;
    private final ProdutoService produtoService;

    @Autowired
    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, AvaliacaoDTOMapper avaliacaoDTOMapper, ProdutoService produtoService){
        this.avaliacaoRepository = avaliacaoRepository;
        this.avaliacaoDTOMapper = avaliacaoDTOMapper;
        this.produtoService = produtoService;
    }

    public Page<Avaliacao> listarAvaliacoes(Pageable pageable){
        return avaliacaoRepository.findAll(pageable);
    }

    public Page<AvaliacaoDTO> listarAvaliacoesDTOs(Pageable pageable){
        Page<Avaliacao> avaliacoesPage = listarAvaliacoes(pageable);
        List<AvaliacaoDTO> avaliacoesDTO = avaliacoesPage.stream()
                    .map(avaliacaoDTOMapper::toDTO)
                    .collect(Collectors.toList());
        return new PageImpl<>(avaliacoesDTO, pageable, avaliacoesPage.getTotalElements());
    }

    public AvaliacaoDTO obterAvaliacaoDTOPorId(Integer id){
        Optional<Avaliacao> avaliacaoOptional = avaliacaoRepository.findById(id);
        avaliacaoExiste(avaliacaoOptional);
        return avaliacaoOptional.map(avaliacaoDTOMapper::toDTO).orElse(null);
    }

    public Avaliacao obterAvaliacaoPorId(Integer id){
        Optional<Avaliacao> avaliacaoOptional = avaliacaoRepository.findById(id);
        avaliacaoExiste(avaliacaoOptional);
        return avaliacaoOptional.get();
    }

    @Transactional
    public void cadastrarAvaliacao(AvaliacaoDTO avaliacaoDTO){
        // valida se o produto passado existe
        if(!produtoService.produtoExiste(avaliacaoDTO.getCodProduto())){
            throw new DataIntegrityViolationException("Não é possível adicionar uma avaliação a um produto que não existe.");
        }
        Avaliacao avaliacao = avaliacaoDTOMapper.toEntity(avaliacaoDTO);
        avaliacao.setDtAvaliacao(LocalDate.now());
        avaliacaoRepository.save(avaliacao);
    }

    @Transactional
    public void atualizarAvaliacao(Integer id, AvaliacaoDTO avaliacaoDTO){
        // valida a existência da avaliação
        Avaliacao avaliacaoExistente = obterAvaliacaoPorId(id);

        // valida se a subcategoria passada existe
        if(!produtoService.produtoExiste(avaliacaoDTO.getCodProduto())){
            throw new DataIntegrityViolationException("Não é possível adicionar uma avaliação a um produto que não existe.");
        }
        LocalDate dataCriacao = avaliacaoExistente.getDtAvaliacao();
        Avaliacao avaliacao = avaliacaoDTOMapper.toEntity(avaliacaoDTO, id);
        avaliacao.setDtAvaliacao(dataCriacao);

        // não tem como transferir a avaliação pra outro produto
        avaliacao.setProduto(avaliacaoExistente.getProduto());
        avaliacaoRepository.save(avaliacao);
    }

    @Transactional
    public void excluirAvaliacao(Integer id){
        avaliacaoExiste(id);
        avaliacaoRepository.deleteById(id);
    }

    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validação
    public boolean avaliacaoExiste(Integer id){
        Optional<Avaliacao> optionalAvaliacao = avaliacaoRepository.findById(id);
        if(optionalAvaliacao.isEmpty()){
            throw new EntityNotFoundException("Nenhuma avaliação encontrada para o ID fornecido.");
        }
        return true;
    }
    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência
    public boolean avaliacaoExiste(Optional<Avaliacao> optionalAvaliacao){
        if(optionalAvaliacao.isEmpty()){
            throw new EntityNotFoundException("Nenhuma avaliação encontrada para o ID fornecido.");
        }
        return true;
    }

}
