package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.FuncionarioDTO;
import br.senac.tads.petshop.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping()
    public ResponseEntity<Object> listarFuncionario() {
        List<FuncionarioDTO> listarFuncionarioDTO = funcionarioService.listarFuncionariosDTOs();
        return ResponseEntity.ok(listarFuncionarioDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterFuncionarioPeloId(@PathVariable Integer id) {
        FuncionarioDTO funcionarioDTO = funcionarioService.obterFuncionarioDTOPorId(id);
        return ResponseEntity.ok(funcionarioDTO);
    }

    @PostMapping()
    public ResponseEntity<Object> criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.criarFuncionario(funcionarioDTO);
        return new ResponseEntity<>("Funcionario criada com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarFuncionario(@PathVariable Integer id, @RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.atualizarFuncionario(id, funcionarioDTO);
        return new ResponseEntity<>("Funcionario atualizada com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirFuncionario(@PathVariable Integer id) {
        funcionarioService.excluirFuncionario(id);
        return new ResponseEntity<>("Funcionario excluida com sucesso.", HttpStatus.OK);
    }
}
