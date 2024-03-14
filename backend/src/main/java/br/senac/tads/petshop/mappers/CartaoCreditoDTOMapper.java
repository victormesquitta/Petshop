package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.CartaoCreditoDTO;
import br.senac.tads.petshop.models.CartaoCredito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoCreditoDTOMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public CartaoCreditoDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CartaoCredito toEntity(CartaoCreditoDTO cartaoCreditoDTO) {
        return modelMapper.map(cartaoCreditoDTO, CartaoCredito.class);
    }

    public CartaoCredito toEntity(CartaoCreditoDTO cartaoCreditoDTO, Integer id) {
        CartaoCredito cartaoCredito = modelMapper.map(cartaoCreditoDTO, CartaoCredito.class);
        cartaoCredito.setCodCartaoCredito(id);
        return cartaoCredito;
    }

    public CartaoCreditoDTO toDTO(CartaoCredito cartaoCredito) {
        return modelMapper.map(cartaoCredito, CartaoCreditoDTO.class);
    }
}
