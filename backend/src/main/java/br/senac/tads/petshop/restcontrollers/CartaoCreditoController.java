package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.CartaoCreditoDTO;
import br.senac.tads.petshop.mappers.CartaoCreditoDTOMapper;
import br.senac.tads.petshop.models.CartaoCredito;
import br.senac.tads.petshop.services.CartaoCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cartoescredito")
public class CartaoCreditoController {

    @Autowired
    private CartaoCreditoService cartaoCreditoService;

    @Autowired
    private CartaoCreditoDTOMapper cartaoCreditoDTOMapper;

    @PostMapping()
    public ResponseEntity<Object> criarCartaoCredito(@RequestBody CartaoCreditoDTO cartaoCreditoDTO) {
        cartaoCreditoService.criarCartaoCredito(cartaoCreditoDTO);
        return new ResponseEntity<>("Cartão de crédito criado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> listarCartoesCredito() {
        List<CartaoCreditoDTO> listaCartoesCreditoDTO = cartaoCreditoService.listarCartoesCreditoDTO();
        return ResponseEntity.ok(listaCartoesCreditoDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterCartaoCreditoPeloId(@PathVariable Integer id) {
        CartaoCreditoDTO cartaoCreditoDTO = cartaoCreditoService.obterCartaoCreditoDTOPorId(id);
        return ResponseEntity.ok(cartaoCreditoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCartaoCredito(@PathVariable Integer id, @RequestBody CartaoCreditoDTO cartaoCreditoDTO) {
        cartaoCreditoService.atualizarCartaoCredito(id, cartaoCreditoDTO);
        return new ResponseEntity<>("Cartão de crédito atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCartaoCredito(@PathVariable Integer id) {
        cartaoCreditoService.excluirCartaoCredito(id);
        return new ResponseEntity<>("Cartão de crédito excluído com sucesso.", HttpStatus.OK);
    }
}
