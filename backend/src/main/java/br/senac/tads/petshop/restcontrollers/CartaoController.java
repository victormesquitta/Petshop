package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.CartaoDTO;
import br.senac.tads.petshop.mappers.CartaoDTOMapper;
import br.senac.tads.petshop.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private CartaoDTOMapper cartaoDTOMapper;

    @PostMapping()
    public ResponseEntity<Object> criarCartaoCredito(@RequestBody CartaoDTO cartaoDTO) {
        cartaoService.criarCartao(cartaoDTO);
        return new ResponseEntity<>("Cartão de crédito criado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> listarCartoesCredito() {
        List<CartaoDTO> listaCartoesCreditoDTO = cartaoService.listarCartoesDTO();
        return ResponseEntity.ok(listaCartoesCreditoDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterCartaoCreditoPeloId(@PathVariable Integer id) {
        CartaoDTO cartaoDTO = cartaoService.obterCartaoDTOPorId(id);
        return ResponseEntity.ok(cartaoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCartaoCredito(@PathVariable Integer id, @RequestBody CartaoDTO cartaoDTO) {
        cartaoService.atualizarCartao(id, cartaoDTO);
        return new ResponseEntity<>("Cartão de crédito atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCartaoCredito(@PathVariable Integer id) {
        cartaoService.excluirCartao(id);
        return new ResponseEntity<>("Cartão de crédito excluído com sucesso.", HttpStatus.OK);
    }
}
