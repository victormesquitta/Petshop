package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.ProdutoDTO;
import br.senac.tads.petshop.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<Page<ProdutoDTO>> listarProdutos(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "20") int size,
                                                           @RequestParam(defaultValue = "nome") String sortBy,
                                                           @RequestParam(defaultValue = "ASC") String sortDirection) {
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        Page<ProdutoDTO> listaProdutosDTO = produtoService.listarProdutosDTO(pageable);
        return ResponseEntity.ok(listaProdutosDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProdutoDTO> obterProdutoPeloId(@PathVariable Integer id) {
        ProdutoDTO produtoDTO = produtoService.obterProdutoDTOPorId(id);
        return ResponseEntity.ok(produtoDTO);
    }

    @PostMapping()
    public ResponseEntity<String> cadastrarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        produtoService.cadastrarProduto(produtoDTO);
        return new ResponseEntity<>("Produto cadastrado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Integer id, @RequestBody @Valid ProdutoDTO produtoDTO) {
        produtoService.atualizarProduto(id, produtoDTO);
        return new ResponseEntity<>("Produto atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirProduto(@PathVariable Integer id) {
        produtoService.excluirProduto(id);
        return new ResponseEntity<>("Produto excluído com sucesso.", HttpStatus.OK);
    }
}
