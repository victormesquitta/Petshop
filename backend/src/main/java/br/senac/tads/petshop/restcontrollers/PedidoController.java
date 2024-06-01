package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.PedidoDTO;
import br.senac.tads.petshop.mappers.PedidoDTOMapper;
import br.senac.tads.petshop.services.PedidoService;
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
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoDTOMapper pedidoDTOMapper;

    @GetMapping()
    public ResponseEntity<Object> listarPedidos(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "20") int size,
                                                @RequestParam(defaultValue = "nome") String sortBy,
                                                @RequestParam(defaultValue = "ASC") String sortDirection){
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        Page<PedidoDTO> listaPedidoDTO = pedidoService.listarPedidosDTO(pageable);
        return ResponseEntity.ok(listaPedidoDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<PedidoDTO> obterPedidoPeloId(@PathVariable Integer id) {
        PedidoDTO pedidoDTO = pedidoService.obterPedidoDTOPorId(id);
        return ResponseEntity.ok(pedidoDTO);
    }

    @PostMapping()
    public ResponseEntity<String> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        pedidoService.cadastrarPedido(pedidoDTO);
        return new ResponseEntity<>("Pedido criado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPedido(@PathVariable Integer id, @RequestBody PedidoDTO pedidoDTO) {
        pedidoService.atualizarPedido(id, pedidoDTO);
        return new ResponseEntity<>("Pedido atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirPedido(@PathVariable Integer id) {
        pedidoService.excluirPedido(id);
        return new ResponseEntity<>("Pedido excluído com sucesso.", HttpStatus.OK);
    }
}