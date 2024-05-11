package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.ClienteDTO;
import br.senac.tads.petshop.mappers.ClienteDTOMapper;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.services.CarrinhoComprasService;
import br.senac.tads.petshop.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
public class ClienteController {


    private final ClienteService clienteService;
    private final CarrinhoComprasService carrinhoComprasService;


    @Autowired
    public ClienteController(ClienteService clienteService, CarrinhoComprasService carrinhoComprasService) {
        this.clienteService = clienteService;
        this.carrinhoComprasService = carrinhoComprasService;
    }


    @PostMapping()
    public ResponseEntity<Object> insereCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        // cria o cliente
        Cliente cliente = clienteService.criarCliente(clienteDTO);
        // vincula o novo carrinho com o cliente que acabamos de criar
        carrinhoComprasService.criarCarrinhoCompras(cliente);
        return new ResponseEntity<>("Cliente criado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> listarClientes() {
        List<ClienteDTO> listaClientesDTO = clienteService.listarClientesDTO();
        return ResponseEntity.ok(listaClientesDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> obterClientePeloId(@PathVariable Integer id) {
        ClienteDTO clienteDTO = clienteService.obterClienteDTOPorId(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping(value = "/cpf/{cpf}", produces = "application/json")
    public ResponseEntity<Object> obterClientePeloCPF(@PathVariable String cpf) {
        ClienteDTO clienteDTO = clienteService.obterClienteDTOPorCPF(cpf);
        return ResponseEntity.ok(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable Integer id, @RequestBody ClienteDTO cliente) {
        clienteService.atualizarCliente(id, cliente);
        return new ResponseEntity<>("Cliente atualizado com sucesso.", HttpStatus.OK);
    }

    /* Ver a validação disso usando spring security - auth2.0 */
    @PutMapping("/desativar-conta/{id}")
    public ResponseEntity<Object> desativarConta(@PathVariable Integer id, @RequestBody ClienteDTO cliente) {
        clienteService.atualizarCliente(id, cliente);
        return new ResponseEntity<>("Conta ativada com sucesso.", HttpStatus.OK);
    }

    /* Ver a validação disso usando spring security - auth2.0 */
    @PutMapping("/ativar-conta/{id}")
    public ResponseEntity<Object> ativarConta(@PathVariable Integer id, @RequestBody ClienteDTO cliente) {
        clienteService.atualizarCliente(id, cliente);
        return new ResponseEntity<>("Conta desativada com sucesso.", HttpStatus.OK);
    }

    @PutMapping("/trocar-senha/{id}")
    public ResponseEntity<Object> trocarSenha(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        clienteService.trocarSenha(id, clienteDTO);
        return new ResponseEntity<>("Senha do cliente atualizada com sucesso.", HttpStatus.OK);
    }

//    @PutMapping("/alterar-status/{id}")
//    public ResponseEntity<Object> alterarStatus(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
//        clienteService.alterarStatus(id, clienteDTO);
//        return new ResponseEntity<>("Status do cliente atualizada com sucesso.", HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCliente(@PathVariable Integer id) {
        clienteService.excluirCliente(id);
        return new ResponseEntity<>("Cliente excluído com sucesso.", HttpStatus.OK);
    }
}
