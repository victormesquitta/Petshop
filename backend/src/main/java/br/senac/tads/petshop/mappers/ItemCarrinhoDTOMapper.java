package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.ItemCarrinhoDTO;
import br.senac.tads.petshop.models.ItemCarrinho;
import br.senac.tads.petshop.services.CarrinhoComprasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemCarrinhoDTOMapper {

    private final ModelMapper modelMapper;
    private final CarrinhoComprasService carrinhoComprasService;

    @Autowired
    public ItemCarrinhoDTOMapper(ModelMapper modelMapper, CarrinhoComprasService carrinhoComprasService) {
        this.modelMapper = modelMapper;
        this.carrinhoComprasService = carrinhoComprasService;
    }

    // Usado para post -> não precisa de id porque ainda não foi criado
    public ItemCarrinho toEntity(ItemCarrinhoDTO itemCarrinhoDTO) {
        ItemCarrinho itemCarrinho =  modelMapper.map(itemCarrinhoDTO, ItemCarrinho.class);
        itemCarrinho.setCarrinhoCompras(carrinhoComprasService.obterCarrinhoComprasPorId(itemCarrinhoDTO.getCodCarrinho()));
        return itemCarrinho;
    }

    // Usado para put -> o id foi criado e deve ser mantido
    public ItemCarrinho toEntity(ItemCarrinhoDTO itemCarrinhoDTO, Integer id) {
        ItemCarrinho itemCarrinho = modelMapper.map(itemCarrinhoDTO, ItemCarrinho.class);
        itemCarrinho.setCodItemCarrinho(id);
        return itemCarrinho;
    }

    public ItemCarrinhoDTO toDTO(ItemCarrinho entity) {
        return modelMapper.map(entity, ItemCarrinhoDTO.class);
    }
}
