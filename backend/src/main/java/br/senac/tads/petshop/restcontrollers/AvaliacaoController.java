package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.AvaliacaoDTO;
import br.senac.tads.petshop.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping()
    public ResponseEntity<Object> listarAvaliacao() {
        List<AvaliacaoDTO> listarAvaliacaoDTO = avaliacaoService.listarAvaliacoesDTOs();
        return ResponseEntity.ok(listarAvaliacaoDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterAvaliacaoPeloId(@PathVariable Integer id) {
        AvaliacaoDTO avaliacaoDTO = avaliacaoService.obterAvaliacaoDTOPorId(id);
        return ResponseEntity.ok(avaliacaoDTO);
    }

    @PostMapping()
    public ResponseEntity<Object> criarAvaliacao(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        avaliacaoService.criarAvaliacao(avaliacaoDTO);
        return new ResponseEntity<>("Avaliação criada com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAvaliacao(@PathVariable Integer id, @RequestBody AvaliacaoDTO avaliacaoDTO) {
        avaliacaoService.atualizarAvaliacao(id, avaliacaoDTO);
        return new ResponseEntity<>("Avaliação atualizada com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirAvaliacao(@PathVariable Integer id) {
        avaliacaoService.excluirAvaliacao(id);
        return new ResponseEntity<>("Avaliação excluida com sucesso.", HttpStatus.OK);
    }
}
