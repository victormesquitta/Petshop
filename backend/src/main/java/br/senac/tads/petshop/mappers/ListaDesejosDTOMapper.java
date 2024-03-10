package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.ListaDesejosDTO;
import br.senac.tads.petshop.models.ListaDesejos;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListaDesejosDTOMapper {

    @Autowired
    private final ModelMapper modelMapper;

    public ListaDesejosDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ListaDesejos toEntity(ListaDesejosDTO listaDesejosDTO) {
        return modelMapper.map(listaDesejosDTO, ListaDesejos.class);
    }
    public ListaDesejosDTO toDTO(ListaDesejos listaDesejos) {
        return modelMapper.map(listaDesejos, ListaDesejosDTO.class);
    }
}
