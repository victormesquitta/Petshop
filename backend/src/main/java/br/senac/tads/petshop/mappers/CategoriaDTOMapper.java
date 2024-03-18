package br.senac.tads.petshop.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.senac.tads.petshop.dtos.CategoriaDTO;
import br.senac.tads.petshop.models.Categoria;

public class CategoriaDTOMapper {
    
    private final ModelMapper modelMapper;

    @Autowired
    public CategoriaDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Categoria toEntity(CategoriaDTO CategoriaDTO) {
        return modelMapper.map(CategoriaDTO, Categoria.class);
    }

    public Categoria toEntity(CategoriaDTO CategoriaDTO, Integer id) {
        Categoria Categoria = modelMapper.map(CategoriaDTO, Categoria.class);
        Categoria.setCodCategorias(id);
        return Categoria;
    }

    public CategoriaDTO toDTO(Categoria Categoria) {
        return modelMapper.map(Categoria, CategoriaDTO.class);
    }
}
