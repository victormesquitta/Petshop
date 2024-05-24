package br.senac.tads.petshop.TesteADM;
import br.senac.tads.petshop.dtos.*;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.repositories.ClienteRepository;
import br.senac.tads.petshop.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AdmController {

    @Autowired
    private ClienteRepository usersRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private
    TokenService tokenService;

    @GetMapping
    public String init(final Model model) {
        model.addAttribute("users", new Cliente());
        return "login";
    }
    @PostMapping("/cadastro")
    public ResponseEntity register(@RequestBody @Valid RegistroDTO dto){
        if(this.usersRepository.findByEmail(dto.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());
        Cliente novoUsers = new Cliente(dto.email(), encryptedPassword, dto.role());

        this.usersRepository.save(novoUsers);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity  login(@RequestBody @Valid AuthenticationDTO dto) {
        var userSenha = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        var auth = this.authenticationManager.authenticate(userSenha);

        var token = tokenService.generateToken((Cliente) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}