package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.ItemPedidoDTO;
import br.senac.tads.petshop.services.ItemPedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/itenspedidos")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping()
    public ResponseEntity<Page<ItemPedidoDTO>> listarItensPedido(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "20") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ItemPedidoDTO> itensPedidoDTO = itemPedidoService.listarItensPedidoDTO(pageable);
        return ResponseEntity.ok(itensPedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> obterItemPedidoPorId(@PathVariable Integer id) {
        ItemPedidoDTO itemPedidoDTO = itemPedidoService.obterItemPedidoDTOPorId(id);
        return ResponseEntity.ok(itemPedidoDTO);
    }

    @PostMapping()
    public ResponseEntity<String> cadastrarItemPedido(@RequestBody @Valid ItemPedidoDTO itemPedidoDTO) {
        itemPedidoService.criarItemPedido(itemPedidoDTO);
        return new ResponseEntity<>("Item de pedido criado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarItemPedido(@PathVariable Integer id, @RequestBody @Valid ItemPedidoDTO itemPedidoDTO) {
        itemPedidoService.atualizarItemPedido(id, itemPedidoDTO);
        return new ResponseEntity<>("Item de pedido atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirItemPedido(@PathVariable Integer id) {
        itemPedidoService.excluirItemPedido(id);
        return new ResponseEntity<>("Item de pedido excluído com sucesso.", HttpStatus.OK);
    }
}
