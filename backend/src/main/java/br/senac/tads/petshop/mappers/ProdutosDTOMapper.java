package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.ProdutoDTO;
import br.senac.tads.petshop.models.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutosDTOMapper {

    @Autowired
    private final ModelMapper modelMapper;

    public ProdutosDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Produto toEntity(ProdutoDTO ProdutoDTO) {
        return modelMapper.map(ProdutoDTO, Produto.class);
    }

    public Produto toEntity(ProdutoDTO ProdutoDTO, Integer id) {
        Produto Produto = modelMapper.map(ProdutoDTO, Produto.class);
        Produto.setCodprodutos(id);
        return Produto;
    }


    public ProdutoDTO toDTO(Produto Produto) {
        return modelMapper.map(Produto, ProdutoDTO.class);
    }

}
