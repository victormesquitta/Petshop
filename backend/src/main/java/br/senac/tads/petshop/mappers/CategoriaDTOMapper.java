package br.senac.tads.petshop.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.senac.tads.petshop.dtos.CategoriaDTO;
import br.senac.tads.petshop.models.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaDTOMapper {
    
    private final ModelMapper modelMapper;

    @Autowired
    public CategoriaDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Categoria toEntity(CategoriaDTO categoriaDTO) {
        return modelMapper.map(categoriaDTO, Categoria.class);
    }

    public Categoria toEntity(CategoriaDTO categoriaDTO, Integer id) {
        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        categoria.setCodCategoria(id);
        return categoria;
    }

    public CategoriaDTO toDTO(Categoria categoria) {
        return modelMapper.map(categoria, CategoriaDTO.class);
    }
}
