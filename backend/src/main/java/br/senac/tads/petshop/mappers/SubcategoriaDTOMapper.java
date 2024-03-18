package br.senac.tads.petshop.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.senac.tads.petshop.dtos.SubcategoriaDTO;
import br.senac.tads.petshop.models.Subcategoria;

public class SubcategoriaDTOMapper {
    
    private final ModelMapper modelMapper;

    @Autowired
    public SubcategoriaDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Subcategoria toEntity(SubcategoriaDTO SubcategoriaDTO) {
        return modelMapper.map(SubcategoriaDTO, Subcategoria.class);
    }

    public Subcategoria toEntity(SubcategoriaDTO SubcategoriaDTO, Integer id) {
        Subcategoria Subcategoria = modelMapper.map(SubcategoriaDTO, Subcategoria.class);
        Subcategoria.setCodsubCategoria(id);
        return Subcategoria;
    }

    public SubcategoriaDTO toDTO(Subcategoria Subcategoria) {
        return modelMapper.map(Subcategoria, SubcategoriaDTO.class);
    }
}
