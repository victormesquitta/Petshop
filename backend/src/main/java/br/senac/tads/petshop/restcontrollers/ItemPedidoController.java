package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.ItemPedidoDTO;
import br.senac.tads.petshop.mappers.ItemPedidoDTOMapper;
import br.senac.tads.petshop.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/itenspedidos")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;
    private final ItemPedidoDTOMapper itemPedidoDTOMapper;

    @Autowired
    public ItemPedidoController(ItemPedidoService itemPedidoService, ItemPedidoDTOMapper itemPedidoDTOMapper) {
        this.itemPedidoService = itemPedidoService;
        this.itemPedidoDTOMapper = itemPedidoDTOMapper;
    }

    @PostMapping()
    public ResponseEntity<Object> criarItemPedido(@RequestBody ItemPedidoDTO itemPedidoDTO) {
        itemPedidoService.criarItemPedido(itemPedidoDTO);
        return new ResponseEntity<>("Item de pedido criado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> listarItensPedido() {
        List<ItemPedidoDTO> itensPedidoDTO = itemPedidoService.listarItensPedidoDTO();
        return ResponseEntity.ok(itensPedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterItemPedidoPorId(@PathVariable Integer id) {
        ItemPedidoDTO itemPedidoDTO = itemPedidoService.obterItemPedidoDTOPorId(id);
        return ResponseEntity.ok(itemPedidoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarItemPedido(@PathVariable Integer id, @RequestBody ItemPedidoDTO itemPedidoDTO) {
        itemPedidoService.atualizarItemPedido(id, itemPedidoDTO);
        return new ResponseEntity<>("Item de pedido atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirItemPedido(@PathVariable Integer id) {
        itemPedidoService.excluirItemPedido(id);
        return new ResponseEntity<>("Item de pedido excluído com sucesso.", HttpStatus.OK);
    }
}
