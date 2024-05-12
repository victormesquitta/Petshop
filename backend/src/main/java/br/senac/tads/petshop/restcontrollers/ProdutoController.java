package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.ProdutoDTO;
import br.senac.tads.petshop.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<Object> listarProdutos() {
        List<ProdutoDTO> listarProdutoDTO = produtoService.listarProdutosDTOs();
        return ResponseEntity.ok(listarProdutoDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterProdutoPeloId(@PathVariable Integer id) {
        ProdutoDTO produtoDTO = produtoService.obterProdutoDTOPorId(id);
        return ResponseEntity.ok(produtoDTO);
    }

    @PostMapping()
    public ResponseEntity<Object> cadastrarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        produtoService.criarProduto(produtoDTO);
        return new ResponseEntity<>("Produto criado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoDTO produtoDTO) {
        produtoService.atualizarProduto(id, produtoDTO);
        return new ResponseEntity<>("Produto atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirProduto(@PathVariable Integer id) {
        produtoService.excluirProduto(id);
        return new ResponseEntity<>("Produto excluído com sucesso.", HttpStatus.OK);
    }
}
