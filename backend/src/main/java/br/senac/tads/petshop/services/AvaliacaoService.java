package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.petshop.dtos.AvaliacaoDTO;
import br.senac.tads.petshop.mappers.AvaliacaoDTOMapper;
import br.senac.tads.petshop.models.Avaliacao;
import br.senac.tads.petshop.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {
    
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private AvaliacaoDTOMapper avaliacaoDTOMapper;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, AvaliacaoDTOMapper avaliacaoDTOMapper){
        this.avaliacaoRepository = avaliacaoRepository;
        this.avaliacaoDTOMapper = avaliacaoDTOMapper;
    }

    public List<Avaliacao> listarAvaliacoes(){
        List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
        return avaliacoes;
    }

    public List<AvaliacaoDTO> listarAvaliacoesDTOs(){
        List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
        return avaliacoes.stream()
                    .map(avaliacaoDTOMapper::toDTO)
                    .collect(Collectors.toList());        
    }

    public AvaliacaoDTO obterAvaliacaoDTOPorId(Integer id){
        Optional<Avaliacao> avaliacaoOptional = avaliacaoRepository.findById(id);
        return avaliacaoOptional.map(avaliacaoDTOMapper::toDTO).orElse(null);
    }

    public void criarAvaliacao(AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacao = avaliacaoDTOMapper.toEntity(avaliacaoDTO);
        avaliacao.setDtCriacao(LocalDate.now());
        avaliacao.setDtModificacao(null);
        avaliacao.setDtResposta(null);
        avaliacaoRepository.save(avaliacao);
    }

    public void atualizarAvaliacao(Integer id, AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacao = avaliacaoDTOMapper.toEntity(avaliacaoDTO, id);
        avaliacao.setDtModificacao(LocalDate.now());
        avaliacaoRepository.save(avaliacao);
    }

    public void excluirAvaliacao(Integer id){
        avaliacaoRepository.deleteById(id);
    }
}
