package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.EnderecoDTO;
import br.senac.tads.petshop.services.EnderecoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping()
    public ResponseEntity<Page<EnderecoDTO>> listarEnderecos(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "20") int size,
                                                             @RequestParam(defaultValue = "endereco") String sortBy,
                                                             @RequestParam(defaultValue = "ASC") String sortDirection) {

        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        Page<EnderecoDTO> listarEnderecoDTO = enderecoService.listarEnderecosDTO(pageable);
        return ResponseEntity.ok(listarEnderecoDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<EnderecoDTO> obterEnderecoPeloId(@PathVariable Integer id) {
        EnderecoDTO enderecoDTO = enderecoService.obterEnderecoDTOPorId(id);
        return ResponseEntity.ok(enderecoDTO);
    }

    @GetMapping(value = "cliente/{clienteId}", produces = "application/json")
    public ResponseEntity<List<EnderecoDTO>> getEnderecosByClienteId(@PathVariable Integer clienteId) {
        List<EnderecoDTO> enderecos = enderecoService.findEnderecosByClienteId(clienteId);
        return ResponseEntity.ok(enderecos);
    }


    @PostMapping()
    public ResponseEntity<String> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        enderecoService.cadastrarEndereco(enderecoDTO);
        return new ResponseEntity<>("Endereço criado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarEndereco(@PathVariable Integer id, @RequestBody EnderecoDTO enderecoDTO) {
        enderecoService.atualizarEndereco(id, enderecoDTO);
        return new ResponseEntity<>("Endereco atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirEndereco(@PathVariable Integer id) {
        enderecoService.excluirEndereco(id);
        return new ResponseEntity<>("Endereco excluído com sucesso.", HttpStatus.OK);
    }
}
