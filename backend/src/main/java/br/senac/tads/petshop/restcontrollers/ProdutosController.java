package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.ProdutoDTO;
import br.senac.tads.petshop.mappers.ProdutoDTOMapper;
import br.senac.tads.petshop.models.Produto;
import br.senac.tads.petshop.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/produtos")
public class ProdutosController {
    
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoDTOMapper produtosMapper;

    @PostMapping()
    public ResponseEntity<Object> criarProduto(@RequestBody ProdutoDTO produtosDTO){
        Produto produto = produtoService.criarProduto(produtosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping()
    public ResponseEntity<Object> listarProdutos() {
        List<ProdutoDTO> listarProdutoDTOs = produtoService.listarProdutosDTOs();
        return ResponseEntity.ok(listarProdutoDTOs);
    }


}