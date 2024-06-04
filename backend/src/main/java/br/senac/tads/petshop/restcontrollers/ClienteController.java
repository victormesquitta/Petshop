package br.senac.tads.petshop.restcontrollers;

import br.senac.tads.petshop.dtos.ClienteDTO;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.services.CarrinhoComprasService;
import br.senac.tads.petshop.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    public ResponseEntity<Page<ClienteDTO>> listarClientes(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ClienteDTO> listaClientesDTO = clienteService.listarClientesDTO(pageable);
        return ResponseEntity.ok(listaClientesDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ClienteDTO> obterClientePeloId(@PathVariable Integer id) {
        ClienteDTO clienteDTO = clienteService.obterClienteDTOPorId(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping()
    public ResponseEntity<String> insereCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        // cria o cliente
        Cliente cliente = clienteService.criarCliente(clienteDTO);
        // vincula o novo carrinho com o cliente que acabamos de criar
        carrinhoComprasService.criarCarrinhoComprasComCliente(cliente);
        return new ResponseEntity<>("Cliente criado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping(value = "/cpf/{cpf}", produces = "application/json")
    public ResponseEntity<ClienteDTO> obterClientePeloCPF(@PathVariable String cpf) {
        ClienteDTO clienteDTO = clienteService.obterClienteDTOPorCPF(cpf);
        return ResponseEntity.ok(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCliente(@PathVariable Integer id, @RequestBody @Valid ClienteDTO cliente) {
        clienteService.atualizarCliente(id, cliente);
        return new ResponseEntity<>("Cliente atualizado com sucesso.", HttpStatus.OK);
    }

    /* Ver a validação disso usando spring security - auth2.0 */
    @PutMapping("/desativar-conta/{id}")
    public ResponseEntity<String> desativarConta(@PathVariable Integer id, @RequestBody @Valid ClienteDTO cliente) {
        clienteService.atualizarCliente(id, cliente);
        return new ResponseEntity<>("Conta ativada com sucesso.", HttpStatus.OK);
    }

    /* Ver a validação disso usando spring security - auth2.0 */
    @PutMapping("/ativar-conta/{id}")
    public ResponseEntity<String> ativarConta(@PathVariable Integer id, @RequestBody @Valid ClienteDTO cliente) {
        clienteService.atualizarCliente(id, cliente);
        return new ResponseEntity<>("Conta desativada com sucesso.", HttpStatus.OK);
    }

    @PutMapping("/trocar-senha/{id}")
    public ResponseEntity<String> trocarSenha(@PathVariable Integer id, @RequestBody @Valid ClienteDTO clienteDTO) {
        clienteService.trocarSenha(id, clienteDTO);
        return new ResponseEntity<>("Senha do cliente atualizada com sucesso.", HttpStatus.OK);
    }

//    @PutMapping("/alterar-status/{id}")
//    public ResponseEntity<Object> alterarStatus(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
//        clienteService.alterarStatus(id, clienteDTO);
//        return new ResponseEntity<>("Status do cliente atualizada com sucesso.", HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCliente(@PathVariable Integer id) {
        clienteService.excluirCliente(id);
        return new ResponseEntity<>("Cliente excluído com sucesso.", HttpStatus.OK);
    }
}
