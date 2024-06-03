package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.ItemPedidoDTO;
import br.senac.tads.petshop.models.ItemPedido;
import br.senac.tads.petshop.services.PedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoDTOMapper {

    private final ModelMapper modelMapper;
    private final PedidoService pedidoService;

    @Autowired
    public ItemPedidoDTOMapper(ModelMapper modelMapper, PedidoService pedidoService) {
        this.modelMapper = modelMapper;
        this.pedidoService = pedidoService;
    }

    // Usado para post -> não precisa de id porque ainda não foi criado
    public ItemPedido toEntity(ItemPedidoDTO itemPedidoDTO) {
        ItemPedido itemPedido =  modelMapper.map(itemPedidoDTO, ItemPedido.class);
        itemPedido.setPedido(pedidoService.obterPedidoPorId(itemPedidoDTO.getCodPedido()));
        return itemPedido;
    }

    // Usado para put -> o id foi criado e deve ser mantido
    public ItemPedido toEntity(ItemPedidoDTO itemPedidoDTO, Integer id) {
        ItemPedido itemPedido = modelMapper.map(itemPedidoDTO, ItemPedido.class);
        itemPedido.setCodItemPedido(id);
        return itemPedido;
    }

    public ItemPedidoDTO toDTO(ItemPedido itemPedido) {
        return modelMapper.map(itemPedido, ItemPedidoDTO.class);
    }
}
