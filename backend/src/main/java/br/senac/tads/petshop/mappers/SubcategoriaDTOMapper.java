package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.SubcategoriaDTO;
import br.senac.tads.petshop.models.Subcategoria;
import br.senac.tads.petshop.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubcategoriaDTOMapper {
    
    private final ModelMapper modelMapper;
    private final CategoriaService categoriaService;

    @Autowired
    public SubcategoriaDTOMapper(ModelMapper modelMapper, CategoriaService categoriaService) {
        this.modelMapper = modelMapper;
        this.categoriaService = categoriaService;
    }

    public Subcategoria toEntity(SubcategoriaDTO subcategoriaDTO) {
        Subcategoria subcategoria = modelMapper.map(subcategoriaDTO, Subcategoria.class);
        subcategoria.setCategoria(categoriaService.obterCategoriaPorId(subcategoriaDTO.getCodCategoria()));
        return subcategoria;
    }

    public Subcategoria toEntity(SubcategoriaDTO subcategoriaDTO, Integer id) {
        Subcategoria subcategoria = modelMapper.map(subcategoriaDTO, Subcategoria.class);
        subcategoria.setCategoria(categoriaService.obterCategoriaPorId(id));
        return subcategoria;
    }

    public SubcategoriaDTO toDTO(Subcategoria subcategoria) {
        SubcategoriaDTO subcategoriaDTO = modelMapper.map(subcategoria, SubcategoriaDTO.class);
        subcategoriaDTO.setCodCategoria(subcategoria.getCategoria().getCodCategoria());
        return subcategoriaDTO;
    }
}
