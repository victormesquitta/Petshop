package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.PedidoDTO;
import br.senac.tads.petshop.mappers.PedidoDTOMapper;
import br.senac.tads.petshop.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoDTOMapper pedidoDTOMapper;

    @GetMapping()
    public ResponseEntity<Object> listarPedidos() {
        List<PedidoDTO> listarPedidoDTO = pedidoService.listarPedidosDTO();
        return ResponseEntity.ok(listarPedidoDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterPedidoPeloId(@PathVariable Integer id) {
        PedidoDTO pedidoDTO = pedidoService.obterPedidoDTOPorId(id);
        return ResponseEntity.ok(pedidoDTO);
    }

    @PostMapping()
    public ResponseEntity<Object> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        pedidoService.criarPedido(pedidoDTO);
        return new ResponseEntity<>("Pedido criado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPedido(@PathVariable Integer id, @RequestBody PedidoDTO pedidoDTO) {
        pedidoService.atualizarPedido(id, pedidoDTO);
        return new ResponseEntity<>("Pedido atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPedido(@PathVariable Integer id) {
        pedidoService.excluirPedido(id);
        return new ResponseEntity<>("Pedido excluído com sucesso.", HttpStatus.OK);
    }
}