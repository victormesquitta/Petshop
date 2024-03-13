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
    // usado para post -> não precisa de id porque ainda não foi criado
    public ListaDesejos toEntity(ListaDesejosDTO listaDesejosDTO) {
        ListaDesejos listaDesejos = modelMapper.map(listaDesejosDTO, ListaDesejos.class);
        listaDesejos.setCliente(clienteService.obterClientePorId(listaDesejosDTO.getCodCliente()));
        return listaDesejos;
    }


    // usado para put -> o id foi criado e deve ser mantido
    public ListaDesejos toEntity(ListaDesejosDTO listaDesejosDTO, Integer id) {
        ListaDesejos listaDesejos = modelMapper.map(listaDesejosDTO, ListaDesejos.class);
        listaDesejos.setCliente(clienteService.obterClientePorId(listaDesejosDTO.getCodCliente()));
        listaDesejos.setCodListaDesejos(id);
        return listaDesejos;
    }


    public ListaDesejosDTO toDTO(ListaDesejos listaDesejos) {
        return modelMapper.map(listaDesejos, ListaDesejosDTO.class);
    }
}
