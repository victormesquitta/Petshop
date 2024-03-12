package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.ListaDesejosDTO;
import br.senac.tads.petshop.models.ListaDesejos;
import br.senac.tads.petshop.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListaDesejosDTOMapper {
    private final ModelMapper modelMapper;
    private final ClienteService clienteService;
    @Autowired
    public ListaDesejosDTOMapper(ModelMapper modelMapper, ClienteService clienteService) {
        this.modelMapper = modelMapper;
        this.clienteService = clienteService;
    }

    public ListaDesejos toEntity(ListaDesejosDTO listaDesejosDTO) {
        ListaDesejos listaDesejos = modelMapper.map(listaDesejosDTO, ListaDesejos.class);
        listaDesejos.setCliente(clienteService.obterClientePorId(listaDesejosDTO.getCodCliente()));
        return listaDesejos;
    }
    public ListaDesejosDTO toDTO(ListaDesejos listaDesejos) {
        return modelMapper.map(listaDesejos, ListaDesejosDTO.class);
    }
}
