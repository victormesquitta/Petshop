package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.ItemCarrinhoDTO;
import br.senac.tads.petshop.models.CarrinhoCompras;
import br.senac.tads.petshop.models.ItemCarrinho;
import br.senac.tads.petshop.services.CarrinhoComprasService;
import br.senac.tads.petshop.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemCarrinhoDTOMapper {

    private final ModelMapper modelMapper;
    private final CarrinhoComprasService carrinhoComprasService;
    private final ProdutoService produtoService;

    @Autowired
    public ItemCarrinhoDTOMapper(ModelMapper modelMapper, CarrinhoComprasService carrinhoComprasService, ProdutoService produtoService) {
        this.modelMapper = modelMapper;
        this.carrinhoComprasService = carrinhoComprasService;
        this.produtoService = produtoService;
    }

    // Usado para post -> não precisa de id porque ainda não foi criado
    public ItemCarrinho toEntity(ItemCarrinhoDTO itemCarrinhoDTO) {
        ItemCarrinho itemCarrinho =  modelMapper.map(itemCarrinhoDTO, ItemCarrinho.class);
        itemCarrinho.setCarrinhoCompras(carrinhoComprasService.obterCarrinhoComprasPorId(itemCarrinhoDTO.getCodCarrinho()));
        itemCarrinho.setProduto(produtoService.obterProdutoPorId(itemCarrinhoDTO.getCodProduto()));
        return itemCarrinho;
    }

    // Usado para put -> o id foi criado e deve ser mantido
    // o item não pode ser transferido pra outro carrinho
    public ItemCarrinho toEntity(ItemCarrinhoDTO itemCarrinhoDTO, Integer id, CarrinhoCompras carrinhoCompras) {
        ItemCarrinho itemCarrinho = modelMapper.map(itemCarrinhoDTO, ItemCarrinho.class);
        itemCarrinho.setCodItemCarrinho(id);
        itemCarrinho.setCarrinhoCompras(carrinhoCompras);
        itemCarrinho.setProduto(produtoService.obterProdutoPorId(itemCarrinhoDTO.getCodProduto()));
        return itemCarrinho;
    }

    public ItemCarrinhoDTO toDTO(ItemCarrinho itemCarrinho) {
        ItemCarrinhoDTO itemCarrinhoDTO = modelMapper.map(itemCarrinho, ItemCarrinhoDTO.class);
        itemCarrinhoDTO.setCodProduto(itemCarrinho.getProduto().getCodProduto());
        itemCarrinhoDTO.setCodCarrinho(itemCarrinho.getCarrinhoCompras().getCodCarrinho());
        return itemCarrinhoDTO;
    }
}
