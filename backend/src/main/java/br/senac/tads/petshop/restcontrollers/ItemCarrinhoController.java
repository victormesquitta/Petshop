package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.ItemCarrinhoDTO;
import br.senac.tads.petshop.mappers.ItemCarrinhoDTOMapper;
import br.senac.tads.petshop.services.ItemCarrinhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itenscarrinhos")
public class ItemCarrinhoController {

    @Autowired
    private ItemCarrinhoService itemCarrinhoService;

    @GetMapping()
    public ResponseEntity<Page<ItemCarrinhoDTO>> listarItensCarrinho(@RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ItemCarrinhoDTO> itensCarrinhoDTO = itemCarrinhoService.listarItensCarrinhoDTO(pageable);
        return ResponseEntity.ok(itensCarrinhoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCarrinhoDTO> obterItemCarrinhoPorId(@PathVariable Integer id) {
        ItemCarrinhoDTO itemCarrinhoDTO = itemCarrinhoService.obterItemCarrinhoDTOPorId(id);
        return ResponseEntity.ok(itemCarrinhoDTO);
    }

    @PostMapping()
    public ResponseEntity<String> adicionarItemCarrinho(@RequestBody @Valid ItemCarrinhoDTO itemCarrinhoDTO) {
        itemCarrinhoService.criarItemCarrinho(itemCarrinhoDTO);
        return new ResponseEntity<>("Item de carrinho criado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarItemCarrinho(@PathVariable Integer id, @RequestBody @Valid ItemCarrinhoDTO itemCarrinhoDTO) {
        itemCarrinhoService.atualizarItemCarrinho(id, itemCarrinhoDTO);
        return new ResponseEntity<>("Item de carrinho atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirItemCarrinho(@PathVariable Integer id) {
        itemCarrinhoService.excluirItemCarrinho(id);
        return new ResponseEntity<>("Item de carrinho excluído com sucesso.", HttpStatus.OK);
    }
}
