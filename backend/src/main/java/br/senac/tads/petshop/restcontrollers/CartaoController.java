package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.CartaoDTO;
import br.senac.tads.petshop.services.CartaoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping()
    public ResponseEntity<Page<CartaoDTO>> listarCartoesCredito(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "20") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<CartaoDTO> listaCartoesCreditoDTO = cartaoService.listarCartoesDTO(pageable);
        return ResponseEntity.ok(listaCartoesCreditoDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CartaoDTO> obterCartaoCreditoPeloId(@PathVariable Integer id) {
        CartaoDTO cartaoDTO = cartaoService.obterCartaoDTOPorId(id);
        return ResponseEntity.ok(cartaoDTO);
    }

    @GetMapping(value = "cliente/{clienteId}", produces = "application/json")
    public ResponseEntity<List<CartaoDTO>> getCartoesByClienteId(@PathVariable Integer clienteId) {
        List<CartaoDTO> cartoesDTO = cartaoService.findCartoesByClienteId(clienteId);
        return ResponseEntity.ok(cartoesDTO);
    }

    @PostMapping()
    public ResponseEntity<String> criarCartaoCredito(@RequestBody CartaoDTO cartaoDTO) {
        cartaoService.cadastrarCartao(cartaoDTO);
        return new ResponseEntity<>("Cartão de crédito criado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCartaoCredito(@PathVariable Integer id, @RequestBody CartaoDTO cartaoDTO) {
        cartaoService.atualizarCartao(id, cartaoDTO);
        return new ResponseEntity<>("Cartão de crédito atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCartaoCredito(@PathVariable Integer id) {
        cartaoService.excluirCartao(id);
        return new ResponseEntity<>("Cartão de crédito excluído com sucesso.", HttpStatus.OK);
    }
}
