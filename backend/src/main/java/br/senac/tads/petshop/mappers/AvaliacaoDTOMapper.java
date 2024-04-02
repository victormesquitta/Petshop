package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.AvaliacaoDTO;
import br.senac.tads.petshop.models.Avaliacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoDTOMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public AvaliacaoDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Avaliacao toEntity(AvaliacaoDTO avaliacaoDTO) {
        return modelMapper.map(avaliacaoDTO, Avaliacao.class);
    }

    public Avaliacao toEntity(AvaliacaoDTO avaliacaoDTO, Integer id) {
        Avaliacao avaliacao = modelMapper.map(avaliacaoDTO, Avaliacao.class);
        avaliacao.setCodAvaliacao(id);
        return avaliacao;
    }

    public AvaliacaoDTO toDTO(Avaliacao avaliacao) {
        return modelMapper.map(avaliacao, AvaliacaoDTO.class);
    }
}
