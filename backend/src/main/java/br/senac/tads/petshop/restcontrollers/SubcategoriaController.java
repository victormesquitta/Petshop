package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.SubcategoriaDTO;
import br.senac.tads.petshop.services.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/subcategoria")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping()
    public ResponseEntity<Object> listarSubcategoria() {
        List<SubcategoriaDTO> listarSubcategoriaDTO = subcategoriaService.listarSubcategoriasDTOs();
        return ResponseEntity.ok(listarSubcategoriaDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterSubcategoriaPeloId(@PathVariable Integer id) {
        SubcategoriaDTO subcategoriaDTO = subcategoriaService.obterSubcategoriaDTOPorId(id);
        return ResponseEntity.ok(subcategoriaDTO);
    }

    @PostMapping()
    public ResponseEntity<Object> criarSubcategoria(@RequestBody SubcategoriaDTO subcategoriaDTO) {
        subcategoriaService.criarSubcategoria(subcategoriaDTO);
        return new ResponseEntity<>("Subcategoria criada com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarSubcategoria(@PathVariable Integer id, @RequestBody SubcategoriaDTO subcategoriaDTO) {
        subcategoriaService.atualizarSubcategoria(id, subcategoriaDTO);
        return new ResponseEntity<>("Subcategoria atualizada com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirSubcategoria(@PathVariable Integer id) {
        subcategoriaService.excluirSubcategoria(id);
        return new ResponseEntity<>("Subcategoria excluida com sucesso.", HttpStatus.OK);
    }
}
