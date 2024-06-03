package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.CartaoDTO;
import br.senac.tads.petshop.models.Cartao;
import br.senac.tads.petshop.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoDTOMapper {

    private final ModelMapper modelMapper;
    private final ClienteService clienteService;

    @Autowired
    public CartaoDTOMapper(ModelMapper modelMapper, ClienteService clienteService) {
        this.modelMapper = modelMapper;
        this.clienteService = clienteService;
    }

    // usado para post -> não precisa de id porque ainda não foi criado
    public Cartao toEntity(CartaoDTO cartaoDTO) {
        Cartao cartao = modelMapper.map(cartaoDTO, Cartao.class);
        cartao.setCliente(clienteService.obterClientePorId(cartaoDTO.getCodCliente()));
        return cartao;
    }

    // usado para put -> o id foi criado e deve ser mantido
    public Cartao toEntity(CartaoDTO cartaoDTO, Integer id) {
        Cartao cartao = modelMapper.map(cartaoDTO, Cartao.class);
        cartao.setCliente(clienteService.obterClientePorId(cartaoDTO.getCodCliente()));
        cartao.setCodCartaoCredito(id);
        return cartao;
    }

    public CartaoDTO toDTO(Cartao cartao) {
        CartaoDTO cartaoDTO = modelMapper.map(cartao, CartaoDTO.class);
        cartaoDTO.setCodCliente(cartao.getCliente().getCodCliente());
        return cartaoDTO;
    }
}
