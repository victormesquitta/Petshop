package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.AvaliacaoDTO;
import br.senac.tads.petshop.services.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping()
    public ResponseEntity<Page<AvaliacaoDTO>> listarAvaliacao(Pageable pageable) {
        Page<AvaliacaoDTO> listaAvaliacoesDTO = avaliacaoService.listarAvaliacoesDTOs(pageable);
        return ResponseEntity.ok(listaAvaliacoesDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<AvaliacaoDTO> obterAvaliacaoPeloId(@PathVariable Integer id) {
        AvaliacaoDTO avaliacaoDTO = avaliacaoService.obterAvaliacaoDTOPorId(id);
        return ResponseEntity.ok(avaliacaoDTO);
    }

    @PostMapping()
    public ResponseEntity<String> cadastrarAvaliacao(@RequestBody @Valid AvaliacaoDTO avaliacaoDTO) {
        avaliacaoService.cadastrarAvaliacao(avaliacaoDTO);
        return new ResponseEntity<>("Avaliação criada com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAvaliacao(@PathVariable Integer id, @RequestBody @Valid AvaliacaoDTO avaliacaoDTO) {
        avaliacaoService.atualizarAvaliacao(id, avaliacaoDTO);
        return new ResponseEntity<>("Avaliação atualizada com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirAvaliacao(@PathVariable Integer id) {
        avaliacaoService.excluirAvaliacao(id);
        return new ResponseEntity<>("Avaliação excluída com sucesso.", HttpStatus.OK);
    }
}
