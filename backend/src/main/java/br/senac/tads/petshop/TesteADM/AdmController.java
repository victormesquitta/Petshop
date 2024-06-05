package br.senac.tads.petshop.TesteADM;

import br.senac.tads.petshop.dtos.*;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.repositories.ClienteRepository;
import br.senac.tads.petshop.security.TokenService;
import br.senac.tads.petshop.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
@CrossOrigin(origins = "http://localhost:5173") // Permita somente a origem do seu
public class AdmController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository usersRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public String init(final Model model) {
        model.addAttribute("users", new Cliente());
        return "login"; // Certifique-se de que 'login' seja o nome correto do seu template
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> register(@RequestBody @Valid ClienteDTO dto){
        if(this.usersRepository.findByEmail(dto.getEmail()) != null) {
            return ResponseEntity.badRequest().build();
        }

        clienteService.criarCliente(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build(); // Use 201 Created
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO dto) {
        UsernamePasswordAuthenticationToken userSenha = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        Authentication auth = this.authenticationManager.authenticate(userSenha); // Authentication object

        String token = tokenService.generateToken((Cliente) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}