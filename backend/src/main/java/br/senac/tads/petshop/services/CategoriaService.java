package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.senac.tads.petshop.dtos.CategoriaDTO;
import br.senac.tads.petshop.mappers.CategoriaDTOMapper;
import br.senac.tads.petshop.models.Categoria;
import br.senac.tads.petshop.repositories.CategoriaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final CategoriaDTOMapper categoriaDTOMapper;

    @Autowired
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

    @Transactional
    public Categoria cadastrarCategoria(CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaDTOMapper.toEntity(categoriaDTO);
        categoria.setDtCriacao(LocalDate.now());
        if(!categoriaRepository.existsByNome(categoriaDTO.getNome())){
            return categoriaRepository.save(categoria);
        } else{
            throw new DataIntegrityViolationException("Nome de categoria já em uso: " + categoriaDTO.getNome());
        }
    }

    @Transactional
    public void atualizarCategoria(Integer id, CategoriaDTO categoriaDTO){
        categoriaExiste(id);
        Categoria categoria = categoriaDTOMapper.toEntity(categoriaDTO, id);
        LocalDate dataCriacao = obterCategoriaDTOPorId(id).getDtCriacao();
        categoria.setDtCriacao(dataCriacao);
        categoria.setCodCategoria(id);
        categoriaRepository.save(categoria);
    }

    @Transactional
    public void excluirCategoria(Integer id){
        categoriaExiste(id);
        categoriaRepository.deleteById(id);
    }


    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validaçaõ
    public boolean categoriaExiste(Integer id){
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if(optionalCategoria.isEmpty()){
            throw new EntityNotFoundException("Nenhuma categoria encontrada para o ID fornecido.");
        }
        return true;
    }
    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência
    public boolean categoriaExiste(Optional<Categoria> optionalCategoria){
        if(optionalCategoria.isEmpty()){
            throw new EntityNotFoundException("Nenhuma categoria encontrada para o ID fornecido.");
        }
        return true;
    }
}
