package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.CarrinhoComprasDTO;
import br.senac.tads.petshop.dtos.PedidoDTO;
import br.senac.tads.petshop.mappers.PedidoDTOMapper;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.models.ItemCarrinho;
import br.senac.tads.petshop.models.Pedido;
import br.senac.tads.petshop.services.CarrinhoComprasService;
import br.senac.tads.petshop.services.ClienteService;
import br.senac.tads.petshop.services.ItemCarrinhoService;
import br.senac.tads.petshop.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoDTOMapper pedidoDTOMapper;

    @Autowired
    private CarrinhoComprasService carrinhoComprasService;

    @Autowired
    private ItemCarrinhoService itemCarrinhoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<Object> listarPedidos(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "20") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<PedidoDTO> listaPedidoDTO = pedidoService.listarPedidosDTO(pageable);
        return ResponseEntity.ok(listaPedidoDTO);
    }

    @GetMapping(value = "cliente/{clienteId}", produces = "application/json")
    public ResponseEntity<List<PedidoDTO>> getPedidosByClienteId(@PathVariable Integer clienteId) {
        List<Pedido> pedidos = pedidoService.findPedidosByClienteId(clienteId);
        List<PedidoDTO> pedidoDTOs = new ArrayList<>();
        for (Pedido p : pedidos) {
            PedidoDTO i = pedidoDTOMapper.toDTO(p);
            pedidoDTOs.add(i);
        }
        return ResponseEntity.ok(pedidoDTOs);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<PedidoDTO> obterPedidoPeloId(@PathVariable Integer id) {
        PedidoDTO pedidoDTO = pedidoService.obterPedidoDTOPorId(id);
        return ResponseEntity.ok(pedidoDTO);
    }

    @PostMapping(value = "/{codCliente}", produces = "application/json")
    public ResponseEntity<String> cadastrarPedido(@PathVariable Integer codCliente, @RequestBody @Valid PedidoDTO pedidoDTO) {


        // pega os itens do carrinho de compras
        List<ItemCarrinho> itensCarrinho = itemCarrinhoService.listarItensCarrinhoPorCodCliente(codCliente);
//        List<ItemCarrinho> itensCarrinho = new ArrayList<>();
//        ItemCarrinho itemCarrinho = itemCarrinhoService.obterItemCarrinhoPorId(1);
//        itensCarrinho.add(itemCarrinho);

//        if (itensCarrinho.isEmpty()) {
//            return new ResponseEntity<>("O carrinho está vazio.", HttpStatus.BAD_REQUEST);
//        }

        // começa a criar o pedido a partir dos itens que estavam no carrinho
        Pedido pedido = pedidoService.cadastrarPedido(itensCarrinho, codCliente, pedidoDTO);

        // pega o codigo do carrinho pra poder apagar e recriar o carrinho de compras do cliente
        Integer codCarrinho = itensCarrinho.get(0).getCarrinhoCompras().getCodCarrinho();
        Cliente cliente = carrinhoComprasService.limparCarrinho(codCarrinho);
        carrinhoComprasService.criarCarrinhoComprasComCliente(cliente);

        return new ResponseEntity<>("Pedido criado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPedido(@PathVariable Integer id, @RequestBody @Valid PedidoDTO pedidoDTO) {
        pedidoService.atualizarPedido(id, pedidoDTO);
        return new ResponseEntity<>("Pedido atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirPedido(@PathVariable Integer id) {
        pedidoService.excluirPedido(id);
        return new ResponseEntity<>("Pedido excluído com sucesso.", HttpStatus.OK);
    }
}