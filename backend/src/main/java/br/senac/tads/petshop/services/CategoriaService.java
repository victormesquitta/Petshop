package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.petshop.dtos.CategoriaDTO;
import br.senac.tads.petshop.mappers.CategoriaDTOMapper;
import br.senac.tads.petshop.models.Categoria;
import br.senac.tads.petshop.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaDTOMapper categoriaDTOMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaDTOMapper categoriaDTOMapper){
        this.categoriaRepository = categoriaRepository;
        this.categoriaDTOMapper = categoriaDTOMapper;
    }

    public List<Categoria> listarCategorias(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    public List<CategoriaDTO> listarCategoriasDTOs(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                    .map(categoriaDTOMapper::toDTO)
                    .collect(Collectors.toList());        
    }

    public CategoriaDTO obterCategoriaDTOPorId(Integer id){
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        return categoriaOptional.map(categoriaDTOMapper::toDTO).orElse(null);
    }

    public void criarCategoria(CategoriaDTO CategoriaDTO){
        Categoria Categoria = categoriaDTOMapper.toEntity(CategoriaDTO);
        Categoria.setDtCriacao(LocalDate.now());
        categoriaRepository.save(Categoria);
    }

    public void atualizarCategoria(Integer id, CategoriaDTO CategoriaDTO){
        Categoria Categoria = categoriaDTOMapper.toEntity(CategoriaDTO, id);
        categoriaRepository.save(Categoria);
    }

    public void excluirCategoria(Integer id){
        categoriaRepository.deleteById(id);
    }
}
