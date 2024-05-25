package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.SubcategoriaDTO;
import br.senac.tads.petshop.services.SubcategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/subcategorias")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping()
    public ResponseEntity<Object> listarSubcategoria() {
        List<SubcategoriaDTO> listarSubcategoriaDTO = subcategoriaService.listarSubcategoriasDTOs();
        return ResponseEntity.ok(listarSubcategoriaDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<SubcategoriaDTO> obterSubcategoriaPeloId(@PathVariable Integer id) {
        SubcategoriaDTO subcategoriaDTO = subcategoriaService.obterSubcategoriaDTOPorId(id);
        return ResponseEntity.ok(subcategoriaDTO);
    }

    @PostMapping()
    public ResponseEntity<String> criarSubcategoria(@RequestBody @Valid SubcategoriaDTO subcategoriaDTO) {
        subcategoriaService.cadastrarSubcategoria(subcategoriaDTO);
        return new ResponseEntity<>("Subcategoria criada com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarSubcategoria(@PathVariable Integer id, @RequestBody @Valid SubcategoriaDTO subcategoriaDTO) {
        subcategoriaService.atualizarSubcategoria(id, subcategoriaDTO);
        return new ResponseEntity<>("Subcategoria atualizada com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirSubcategoria(@PathVariable Integer id) {
        subcategoriaService.excluirSubcategoria(id);
        return new ResponseEntity<>("Subcategoria excluida com sucesso.", HttpStatus.OK);
    }
}
