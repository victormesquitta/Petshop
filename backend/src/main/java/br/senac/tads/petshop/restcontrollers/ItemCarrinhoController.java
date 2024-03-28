package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.ItemCarrinhoDTO;
import br.senac.tads.petshop.mappers.ItemCarrinhoDTOMapper;
import br.senac.tads.petshop.services.ItemCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/itenscarrinho")
public class ItemCarrinhoController {

    private final ItemCarrinhoService itemCarrinhoService;
    private final ItemCarrinhoDTOMapper itemCarrinhoDTOMapper;

    @Autowired
    public ItemCarrinhoController(ItemCarrinhoService itemCarrinhoService, ItemCarrinhoDTOMapper itemCarrinhoDTOMapper) {
        this.itemCarrinhoService = itemCarrinhoService;
        this.itemCarrinhoDTOMapper = itemCarrinhoDTOMapper;
    }

    @PostMapping()
    public ResponseEntity<Object> criarItemCarrinho(@RequestBody ItemCarrinhoDTO itemCarrinhoDTO) {
        itemCarrinhoService.criarItemCarrinho(itemCarrinhoDTO);
        return new ResponseEntity<>("Item de carrinho criado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> listarItensCarrinho() {
        List<ItemCarrinhoDTO> itensCarrinhoDTO = itemCarrinhoService.listarItensCarrinhoDTO();
        return ResponseEntity.ok(itensCarrinhoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterItemCarrinhoPorId(@PathVariable Integer id) {
        ItemCarrinhoDTO itemCarrinhoDTO = itemCarrinhoService.obterItemCarrinhoDTOPorId(id);
        return ResponseEntity.ok(itemCarrinhoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarItemCarrinho(@PathVariable Integer id, @RequestBody ItemCarrinhoDTO itemCarrinhoDTO) {
        itemCarrinhoService.atualizarItemCarrinho(id, itemCarrinhoDTO);
        return new ResponseEntity<>("Item de carrinho atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirItemCarrinho(@PathVariable Integer id) {
        itemCarrinhoService.excluirItemCarrinho(id);
        return new ResponseEntity<>("Item de carrinho excluído com sucesso.", HttpStatus.OK);
    }
}
