package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.CategoriaDTO;
import br.senac.tads.petshop.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Object> listarCategoria() {
        List<CategoriaDTO> listarCategoriaDTO = categoriaService.listarCategoriasDTOs();
        return ResponseEntity.ok(listarCategoriaDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterCategoriaPeloId(@PathVariable Integer id) {
        CategoriaDTO CategoriaDTO = categoriaService.obterCategoriaDTOPorId(id);
        return ResponseEntity.ok(CategoriaDTO);
    }

    @PostMapping()
    public ResponseEntity<Object> criarCategoria(@RequestBody @Valid CategoriaDTO CategoriaDTO) {
        categoriaService.cadastrarCategoria(CategoriaDTO);
        return new ResponseEntity<>("Categoria criada com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO CategoriaDTO) {
        categoriaService.atualizarCategoria(id, CategoriaDTO);
        return new ResponseEntity<>("Categoria atualizada com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCategoria(@PathVariable Integer id) {
        categoriaService.excluirCategoria(id);
        return new ResponseEntity<>("Categoria excluida com sucesso.", HttpStatus.OK);
    }
}
