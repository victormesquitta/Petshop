package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.ItemPedidoDTO;
import br.senac.tads.petshop.models.ItemPedido;
import br.senac.tads.petshop.models.Pedido;
import br.senac.tads.petshop.models.Produto;
import br.senac.tads.petshop.services.PedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoDTOMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ItemPedidoDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

    }

    // Usado para post -> não precisa de id porque ainda não foi criado
    public ItemPedido toEntity(ItemPedidoDTO itemPedidoDTO, Pedido pedido, Produto produto) {
        ItemPedido itemPedido =  modelMapper.map(itemPedidoDTO, ItemPedido.class);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        return itemPedido;
    }

    // Usado para put -> o id foi criado e deve ser mantido
    // o item não pode ser transferido pra outro carrinho
    public ItemPedido toEntity(ItemPedidoDTO itemPedidoDTO, Integer id, Pedido pedido, Produto produto) {
        ItemPedido itemPedido = modelMapper.map(itemPedidoDTO, ItemPedido.class);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setCodItemPedido(id);
        return itemPedido;
    }

    public ItemPedidoDTO toDTO(ItemPedido itemPedido) {
        ItemPedidoDTO itemPedidoDTO = modelMapper.map(itemPedido, ItemPedidoDTO.class);
        itemPedidoDTO.setCodProduto(itemPedido.getProduto().getCodProduto());
        itemPedidoDTO.setCodPedido(itemPedido.getPedido().getCodPedido());
        return itemPedidoDTO;
    }
}
