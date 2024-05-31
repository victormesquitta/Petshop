package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.CategoriaDTO;
import br.senac.tads.petshop.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<Page<CategoriaDTO>> listarCategoria(Pageable pageable) {
        Page<CategoriaDTO> listarCategoriaDTO = categoriaService.listarCategoriasDTOs(pageable);
        return ResponseEntity.ok(listarCategoriaDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CategoriaDTO> obterCategoriaPeloId(@PathVariable Integer id) {
        CategoriaDTO CategoriaDTO = categoriaService.obterCategoriaDTOPorId(id);
        return ResponseEntity.ok(CategoriaDTO);
    }

    @PostMapping()
    public ResponseEntity<String> criarCategoria(@RequestBody @Valid CategoriaDTO CategoriaDTO) {
        categoriaService.cadastrarCategoria(CategoriaDTO);
        return new ResponseEntity<>("Categoria criada com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCategoria(@PathVariable Integer id, @RequestBody @Valid CategoriaDTO CategoriaDTO) {
        categoriaService.atualizarCategoria(id, CategoriaDTO);
        return new ResponseEntity<>("Categoria atualizada com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCategoria(@PathVariable Integer id) {
        categoriaService.excluirCategoria(id);
        return new ResponseEntity<>("Categoria excluida com sucesso.", HttpStatus.OK);
    }
}
