package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.ListaDesejosDTO;
import br.senac.tads.petshop.mappers.ListaDesejosDTOMapper;
import br.senac.tads.petshop.models.ListaDesejos;
import br.senac.tads.petshop.services.ListaDesejosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/listadesejos")
public class ListaDesejosController {
    private final ListaDesejosService listaDesejosService;
    private final ListaDesejosDTOMapper listaDesejosDTOMapper;
    @Autowired
    public ListaDesejosController(ListaDesejosService listaDesejosService, ListaDesejosDTOMapper listaDesejosDTOMapper) {
        this.listaDesejosService = listaDesejosService;
        this.listaDesejosDTOMapper = listaDesejosDTOMapper;
    }

    @PostMapping()
    public ResponseEntity<Object> criarListaDesejos(@RequestBody ListaDesejosDTO listaDesejosDTO) {
        listaDesejosService.criarListaDesejos(listaDesejosDTO);
        return new ResponseEntity<>("Lista de desejos criada com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> listarListaDesejos() {
        List<ListaDesejosDTO> listarListaDesejosDTO = listaDesejosService.listarListaDesejosDTO();
        return ResponseEntity.ok(listarListaDesejosDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterListaDesejosPeloId(@PathVariable Integer id) {
        ListaDesejosDTO listaDesejosDTO = listaDesejosService.obterListaDesejosDTOPorId(id);
        return ResponseEntity.ok(listaDesejosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarListaDesejos(@PathVariable Integer id, @RequestBody ListaDesejosDTO listaDesejosDTO) {
        listaDesejosService.atualizarListaDesejos(id, listaDesejosDTO);
        return new ResponseEntity<>("Lista de desejos atualizada com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirListaDesejos(@PathVariable Integer id) {
        listaDesejosService.excluirListaDesejos(id);
        return new ResponseEntity<>("Lista de desejos excluída com sucesso.", HttpStatus.OK);
    }
}
