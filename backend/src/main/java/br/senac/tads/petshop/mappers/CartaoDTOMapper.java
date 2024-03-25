package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.CartaoDTO;
import br.senac.tads.petshop.models.Cartao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoDTOMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public CartaoDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Cartao toEntity(CartaoDTO cartaoDTO) {
        return modelMapper.map(cartaoDTO, Cartao.class);
    }

    public Cartao toEntity(CartaoDTO cartaoDTO, Integer id) {
        Cartao cartao = modelMapper.map(cartaoDTO, Cartao.class);
        cartao.setCodCartaoCredito(id);
        return cartao;
    }

    public CartaoDTO toDTO(Cartao cartao) {
        return modelMapper.map(cartao, CartaoDTO.class);
    }
}
