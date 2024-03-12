package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.EnderecoDTO;
import br.senac.tads.petshop.models.Endereco;
import br.senac.tads.petshop.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDTOMapper {
    private final ModelMapper modelMapper;
    private final ClienteService clienteService;

    @Autowired
    public EnderecoDTOMapper(ModelMapper modelMapper, ClienteService clienteService) {
        this.modelMapper = modelMapper;
        this.clienteService = clienteService;
    }

    public Endereco toEntity(EnderecoDTO enderecoDTO) {
        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
        endereco.setCliente(clienteService.obterClientePorId(enderecoDTO.getCodCliente()));
        return endereco;
    }

    public Endereco toEntity(EnderecoDTO enderecoDTO, Integer id) {
        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
        endereco.setCliente(clienteService.obterClientePorId(enderecoDTO.getCodCliente()));
        endereco.setCodEndereco(id);
        return endereco;
    }

    public EnderecoDTO toDTO(Endereco endereco) {
        return modelMapper.map(endereco, EnderecoDTO.class);
    }

}