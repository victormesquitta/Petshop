package br.senac.tads.petshop.TesteADM;

import br.senac.tads.petshop.dtos.*;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.repositories.ClienteRepository;
import br.senac.tads.petshop.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173") // Permita somente a origem do seu
public class AdmController {

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
    public ResponseEntity<Void> register(@RequestBody @Valid RegistroDTO dto){
        if(this.usersRepository.findByEmail(dto.email()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());
        Cliente novoUsers = new Cliente(dto.email(), encryptedPassword, dto.role());

        this.usersRepository.save(novoUsers);

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