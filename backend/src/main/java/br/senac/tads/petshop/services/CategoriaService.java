package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
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
    private CategoriaDTOMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaDTOMapper categoriaMapper){
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public List<Categoria> listarCategorias(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    public List<CategoriaDTO> listarCategoriasDTOs(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                    .map(categoriaMapper::toDTO)
                    .collect(Collectors.toList());        
    }

    public void criarCategoria(CategoriaDTO CategoriaDTO){
        Categoria Categoria = categoriaMapper.toEntity(CategoriaDTO);
        Categoria.setDtCriacao(LocalDate.now());
        Categoria.setDtModificacao(null);
        categoriaRepository.save(Categoria);
    }

    public void atualizarCategoria(Integer id, CategoriaDTO CategoriaDTO){
        Categoria Categoria = categoriaMapper.toEntity(CategoriaDTO, id);
        Categoria.setDtModificacao(LocalDate.now());
        categoriaRepository.save(Categoria);
    }

    public void excluirCategoria(Integer id, CategoriaDTO categoriaDTO){
        categoriaRepository.deleteById(id);
    }
}
