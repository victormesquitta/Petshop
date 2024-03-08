package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.ClienteDTO;
import br.senac.tads.petshop.models.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteDTOMapper {

    @Autowired
    private final ModelMapper modelMapper;

    public ClienteDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Cliente toEntity(ClienteDTO clienteDTO) {
        return modelMapper.map(clienteDTO, Cliente.class);
    }
    public ClienteDTO toDTO(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDTO.class);
    }

}
