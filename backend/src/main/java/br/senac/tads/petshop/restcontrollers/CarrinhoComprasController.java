package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.CarrinhoComprasDTO;
import br.senac.tads.petshop.mappers.CarrinhoComprasDTOMapper;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.services.CarrinhoComprasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping()
    public ResponseEntity<Page<CarrinhoComprasDTO>> listarCarrinhosCompras(@RequestParam(defaultValue = "0") int page,
                                                                           @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CarrinhoComprasDTO> listaCarrinhosComprasDTO = carrinhoComprasService.listarCarrinhosComprasDTO(pageable);
        return ResponseEntity.ok(listaCarrinhosComprasDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CarrinhoComprasDTO> obterCarrinhoComprasPeloId(@PathVariable Integer id) {
        CarrinhoComprasDTO carrinhoComprasDTO = carrinhoComprasService.obterCarrinhoComprasDTOPorId(id);
        return ResponseEntity.ok(carrinhoComprasDTO);
    }

    @PostMapping()
    public ResponseEntity<String> criarCarrinhoCompras(@RequestBody @Valid Cliente cliente) {
        carrinhoComprasService.criarCarrinhoCompras(cliente);
        return new ResponseEntity<>("Carrinho de compras criado com sucesso.", HttpStatus.CREATED);
    }

    /*
    * ver a necessidade de ter um endpoint de atualização:
    * - codcarrinho é gerado automaticamente
    * - codcliente é pré-estabelecido no começo e não pode mudar pra outro cliente
    * - qtdProdutos é calculado automaticamente
    * - subtotal é calculado automaticamente
    * */
//    @PutMapping("/{id}")
//    public ResponseEntity<String> atualizarCarrinhoCompras(@PathVariable Integer id, @RequestBody @Valid CarrinhoComprasDTO carrinhoComprasDTO) {
//        carrinhoComprasService.atualizarCarrinhoCompras(id, carrinhoComprasDTO);
//        return new ResponseEntity<>("Carrinho de compras atualizado com sucesso.", HttpStatus.OK);
//    }

//    @PutMapping("/limpar-carrinho/{id}")
//    public ResponseEntity<String> limparCarrinho(@PathVariable Integer id, @RequestBody @Valid CarrinhoComprasDTO carrinhoComprasDTO) {
//        carrinhoComprasService.atualizarCarrinhoCompras(id, carrinhoComprasDTO);
//        return new ResponseEntity<>("Carrinho de compras limpo com sucesso.", HttpStatus.OK);
//    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> excluirCarrinhoCompras(@PathVariable Integer id) {
//        carrinhoComprasService.excluirCarrinhoCompras(id);
//        return new ResponseEntity<>("Carrinho de compras excluído com sucesso.", HttpStatus.OK);
//    }
}
