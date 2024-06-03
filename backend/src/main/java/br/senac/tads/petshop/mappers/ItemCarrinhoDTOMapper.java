package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.CarrinhoComprasDTO;
import br.senac.tads.petshop.dtos.ItemCarrinhoDTO;
import br.senac.tads.petshop.models.CarrinhoCompras;
import br.senac.tads.petshop.models.ItemCarrinho;
import br.senac.tads.petshop.models.Produto;
import br.senac.tads.petshop.services.CarrinhoComprasService;
import br.senac.tads.petshop.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemCarrinhoDTOMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ItemCarrinhoDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

    }

    // Usado para post -> não precisa de id porque ainda não foi criado
    public ItemCarrinho toEntity(ItemCarrinhoDTO itemCarrinhoDTO, CarrinhoCompras carrinhoCompras, Produto produto) {
        ItemCarrinho itemCarrinho =  modelMapper.map(itemCarrinhoDTO, ItemCarrinho.class);
        itemCarrinho.setCarrinhoCompras(carrinhoCompras);
        itemCarrinho.setProduto(produto);
        return itemCarrinho;
    }

    // Usado para put -> o id foi criado e deve ser mantido
    // o item não pode ser transferido pra outro carrinho
    public ItemCarrinho toEntity(ItemCarrinhoDTO itemCarrinhoDTO, Integer id, CarrinhoCompras carrinhoCompras, Produto produto) {
        ItemCarrinho itemCarrinho = modelMapper.map(itemCarrinhoDTO, ItemCarrinho.class);
        itemCarrinho.setCodItemCarrinho(id);
        itemCarrinho.setCarrinhoCompras(carrinhoCompras);
        itemCarrinho.setProduto(produto);
        return itemCarrinho;
    }

    public ItemCarrinhoDTO toDTO(ItemCarrinho itemCarrinho) {
        ItemCarrinhoDTO itemCarrinhoDTO = modelMapper.map(itemCarrinho, ItemCarrinhoDTO.class);
        itemCarrinhoDTO.setCodProduto(itemCarrinho.getProduto().getCodProduto());
        itemCarrinhoDTO.setCodCarrinho(itemCarrinho.getCarrinhoCompras().getCodCarrinho());
        return itemCarrinhoDTO;
    }
}
