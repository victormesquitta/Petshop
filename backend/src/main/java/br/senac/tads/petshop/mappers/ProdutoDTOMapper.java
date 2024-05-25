package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.ProdutoDTO;
import br.senac.tads.petshop.models.Produto;
import br.senac.tads.petshop.services.SubcategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDTOMapper {

    private final ModelMapper modelMapper;
    private final SubcategoriaService subcategoriaService;

    @Autowired
    public ProdutoDTOMapper(ModelMapper modelMapper, SubcategoriaService subcategoriaService) {
        this.modelMapper = modelMapper;
        this.subcategoriaService = subcategoriaService;
    }

    public Produto toEntity(ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produto.setSubcategoria(subcategoriaService.obterSubcategoriaPorId(produtoDTO.getCodSubcategoria()));
        return produto;
    }

    public Produto toEntity(ProdutoDTO produtoDTO, Integer id) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produto.setCodProduto(id);
        return produto;
    }


    public ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO produtoDTO =  modelMapper.map(produto, ProdutoDTO.class);
        produtoDTO.setCodSubcategoria(produto.getSubcategoria().getCodSubcategoria());
        return produtoDTO;
    }

}
