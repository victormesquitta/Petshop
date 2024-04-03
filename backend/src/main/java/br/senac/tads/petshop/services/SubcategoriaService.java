package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.petshop.dtos.SubcategoriaDTO;
import br.senac.tads.petshop.mappers.SubcategoriaDTOMapper;
import br.senac.tads.petshop.models.Subcategoria;
import br.senac.tads.petshop.repositories.SubcategoriaRepository;

@Service
public class SubcategoriaService {
    
    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private SubcategoriaDTOMapper subcategoriaMapper;

    public SubcategoriaService(SubcategoriaRepository subcategoriaRepository, SubcategoriaDTOMapper subcategoriaMapper){
        this.subcategoriaRepository = subcategoriaRepository;
        this.subcategoriaMapper = subcategoriaMapper;
    }

    public List<Subcategoria> listarSubcategorias(){
        List<Subcategoria> subcategorias = subcategoriaRepository.findAll();
        return subcategorias;
    }

    public List<SubcategoriaDTO> listarSubcategoriasDTOs(){
        List<Subcategoria> subcategorias = subcategoriaRepository.findAll();
        return subcategorias.stream()
                    .map(subcategoriaMapper::toDTO)
                    .collect(Collectors.toList());        
    }

    public SubcategoriaDTO obterSubcategoriaDTOPorId(Integer id){
        Optional<Subcategoria> subcategoriaOptional = subcategoriaRepository.findById(id);
        return subcategoriaOptional.map(subcategoriaMapper::toDTO).orElse(null);
    }

    public void criarSubcategoria(SubcategoriaDTO subcategoriaDTO){
        Subcategoria subcategoria = subcategoriaMapper.toEntity(subcategoriaDTO);
/*
testar isso aqui 
 Categoria categoria = categoriaRepository.findById(subcategoriaDTO.getCodcategorias()).orElseThrow(() -> new IllegalArgumentException("A Categoria com ID " + subcategoriaDTO.getCodcategorias() + " não existe."));
 */
        subcategoria.setDtCriacao(LocalDate.now());
        subcategoria.setDtModificacao(null);
        subcategoriaRepository.save(subcategoria);
    }

    public void atualizarSubcategoria(Integer id, SubcategoriaDTO subcategoriaDTO){
        Subcategoria subcategoria = subcategoriaMapper.toEntity(subcategoriaDTO, id);
        subcategoria.setDtModificacao(LocalDate.now());
        subcategoriaRepository.save(subcategoria);
    }

    public void excluirSubcategoria(Integer id){
        subcategoriaRepository.deleteById(id);
    }
}
