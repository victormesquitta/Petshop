package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.CarrinhoComprasDTO;
import br.senac.tads.petshop.mappers.CarrinhoComprasDTOMapper;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.services.CarrinhoComprasService;
import br.senac.tads.petshop.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/carrinhoscompras")
public class CarrinhoComprasController {

    @Autowired
    private CarrinhoComprasService carrinhoComprasService;

    @Autowired
    private CarrinhoComprasDTOMapper carrinhoComprasDTOMapper;

    @PostMapping()
    public ResponseEntity<Object> criarCarrinhoCompras(@RequestBody Cliente cliente) {
        carrinhoComprasService.criarCarrinhoCompras(cliente);
        return new ResponseEntity<>("Carrinho de compras criado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> listarCarrinhosCompras() {
        List<CarrinhoComprasDTO> listaCarrinhosComprasDTO = carrinhoComprasService.listarCarrinhosComprasDTO();
        return ResponseEntity.ok(listaCarrinhosComprasDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterCarrinhoComprasPeloId(@PathVariable Integer id) {
        CarrinhoComprasDTO carrinhoComprasDTO = carrinhoComprasService.obterCarrinhoComprasDTOPorId(id);
        return ResponseEntity.ok(carrinhoComprasDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCarrinhoCompras(@PathVariable Integer id, @RequestBody CarrinhoComprasDTO carrinhoComprasDTO) {
        carrinhoComprasService.atualizarCarrinhoCompras(id, carrinhoComprasDTO);
        return new ResponseEntity<>("Carrinho de compras atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCarrinhoCompras(@PathVariable Integer id) {
        carrinhoComprasService.excluirCarrinhoCompras(id);
        return new ResponseEntity<>("Carrinho de compras excluído com sucesso.", HttpStatus.OK);
    }
}
