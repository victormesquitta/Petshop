package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.EnderecoDTO;
import br.senac.tads.petshop.mappers.EnderecoDTOMapper;
import br.senac.tads.petshop.models.Endereco;
import br.senac.tads.petshop.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoDTOMapper enderecoDTOMapper;

    @PostMapping()
    public ResponseEntity<Object> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        enderecoService.criarEndereco(enderecoDTO);
        return new ResponseEntity<>("Endereço criado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> listarEnderecos() {
        List<EnderecoDTO> listarEnderecoDTO = enderecoService.listarEnderecosDTO();
        return ResponseEntity.ok(listarEnderecoDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterEnderecoPeloId(@PathVariable Integer id) {
        EnderecoDTO enderecoDTO = enderecoService.obterEnderecoDTOPorId(id);
        return ResponseEntity.ok(enderecoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarEndereco(@PathVariable Integer id, @RequestBody EnderecoDTO enderecoDTO) {
        enderecoService.atualizarEndereco(id, enderecoDTO);
        return new ResponseEntity<>("Endereco atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirEndereco(@PathVariable Integer id) {
        enderecoService.excluirEndereco(id);
        return new ResponseEntity<>("Endereco excluído com sucesso.", HttpStatus.OK);
    }
}
