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

    // usado para post -> não precisa de id porque ainda não foi criado
    public Endereco toEntity(EnderecoDTO enderecoDTO) {
        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
        endereco.setCliente(clienteService.obterClientePorId(enderecoDTO.getCodCliente()));
        return endereco;
    }

    // usado para put -> o id foi criado e deve ser mantido
    public Endereco toEntity(EnderecoDTO enderecoDTO, Integer id) {
        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
        endereco.setCliente(clienteService.obterClientePorId(enderecoDTO.getCodCliente()));
        endereco.setCodEndereco(id);
        return endereco;
    }

    public EnderecoDTO toDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
        enderecoDTO.setCodCliente(endereco.getCliente().getCodCliente());
        return enderecoDTO;
    }

}