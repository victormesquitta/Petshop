package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.ProdutosDTO;
import br.senac.tads.petshop.models.Produtos;
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

    public Produtos toEntity(ProdutosDTO ProdutosDTO) {
        return modelMapper.map(ProdutosDTO, Produtos.class);
    }

    public Produtos toEntity(ProdutosDTO ProdutosDTO, Integer id) {
        Produtos Produtos = modelMapper.map(ProdutosDTO, Produtos.class);
        Produtos.setCodprodutos(id);
        return Produtos;
    }


    public ProdutosDTO toDTO(Produtos Produtos) {
        return modelMapper.map(Produtos, ProdutosDTO.class);
    }

}
