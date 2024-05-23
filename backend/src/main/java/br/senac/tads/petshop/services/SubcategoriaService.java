package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.senac.tads.petshop.dtos.SubcategoriaDTO;
import br.senac.tads.petshop.mappers.SubcategoriaDTOMapper;
import br.senac.tads.petshop.models.Subcategoria;
import br.senac.tads.petshop.repositories.SubcategoriaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubcategoriaService {

    private final CategoriaService categoriaService;
    private final SubcategoriaRepository subcategoriaRepository;
    private final SubcategoriaDTOMapper subcategoriaMapper;

    @Autowired
    public SubcategoriaService(SubcategoriaRepository subcategoriaRepository, CategoriaService categoriaService, SubcategoriaDTOMapper subcategoriaMapper){
        this.subcategoriaRepository = subcategoriaRepository;
        this.categoriaService = categoriaService;
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
        subcategoriaExiste(subcategoriaOptional);
        SubcategoriaDTO subcategoriaDTO = subcategoriaOptional.map(subcategoriaMapper::toDTO).orElse(null);
        System.out.println(subcategoriaDTO);
        return subcategoriaDTO;
    }

    public Subcategoria obterSubcategoriaPorId(Integer id){
        Optional<Subcategoria> subcategoriaOptional = subcategoriaRepository.findById(id);
        subcategoriaExiste(subcategoriaOptional);
        return subcategoriaOptional.get();
    }


    @Transactional
    public Subcategoria cadastrarSubcategoria(SubcategoriaDTO subcategoriaDTO){
        // valida se a categoria passada existe
        if(!categoriaService.categoriaExiste(subcategoriaDTO.getCodCategoria())){
            throw new DataIntegrityViolationException("Não é possível adicionar uma subcategoria a uma categoria que não existe.");
        }
        Subcategoria subcategoria = subcategoriaMapper.toEntity(subcategoriaDTO);
        subcategoria.setDtCriacao(LocalDate.now());
        if(!subcategoriaRepository.existsByNome(subcategoriaDTO.getNome())){
            return subcategoriaRepository.save(subcategoria);
        } else{
            throw new DataIntegrityViolationException("Nome de categoria já em uso: " + subcategoriaDTO.getNome());
        }
    }

    @Transactional
    public void atualizarSubcategoria(Integer id, SubcategoriaDTO subcategoriaDTO){
        subcategoriaExiste(id);
        // valida se a categoria passada existe
        if(!categoriaService.categoriaExiste(subcategoriaDTO.getCodCategoria())){
            throw new DataIntegrityViolationException("Não é possível adicionar uma subcategoria a uma categoria que não existe.");
        }
        Subcategoria subcategoria = subcategoriaMapper.toEntity(subcategoriaDTO, id);
        LocalDate dataCriacao = obterSubcategoriaDTOPorId(id).getDtCriacao();
        subcategoria.setDtCriacao(dataCriacao);
        subcategoria.setCodSubcategoria(id);
        subcategoriaRepository.save(subcategoria);
    }

    @Transactional
    public void excluirSubcategoria(Integer id){
        subcategoriaExiste(id);
        subcategoriaRepository.deleteById(id);
    }

    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validaçaõ
    public boolean subcategoriaExiste(Integer id){
        Optional<Subcategoria> optionalSubcategoria = subcategoriaRepository.findById(id);
        if(optionalSubcategoria.isEmpty()){
            throw new EntityNotFoundException("Nenhuma subcategoria encontrada para o ID fornecido.");
        }
        return true;
    }
    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência
    public boolean subcategoriaExiste(Optional<Subcategoria> optionalSubcategoria){
        if(optionalSubcategoria.isEmpty()){
            throw new EntityNotFoundException("Nenhuma subcategoria encontrada para o ID fornecido.");
        }
        return true;
    }

}
