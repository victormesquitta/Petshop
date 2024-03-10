package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.EnderecoDTO;
import br.senac.tads.petshop.models.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDTOMapper {

    @Autowired
    private final ModelMapper modelMapper;

    public EnderecoDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Endereco toEntity(EnderecoDTO enderecoDTO) {
        return modelMapper.map(enderecoDTO, Endereco.class);
    }
    public EnderecoDTO toDTO(Endereco endereco) {
        return modelMapper.map(endereco, EnderecoDTO.class);
    }
}
