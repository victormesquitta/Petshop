package br.senac.tads.petshop.security;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.senac.tads.petshop.repositories.ClienteRepository;
import br.senac.tads.petshop.repositories.FuncionarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{

        var token = this.recoverToken(request);
    if (token != null) {
        var subject = tokenService.valideToken(token);

        UserDetails userio = null;
        
        // Tente encontrar o usuário no repositório de clientes
        userio = clienteRepository.findByEmail(subject);
        
        // Se não encontrado no repositório de clientes, tente no repositório de funcionários
        if (userio == null) {
            userio = funcionarioRepository.findByEmail(subject);
        }

        // Se um usuário foi encontrado, autentique-o
        if (userio != null) {
            var authentication = new UsernamePasswordAuthenticationToken(userio, null, userio.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
    filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authReader = request.getHeader("Authorization");
        if (authReader == null) return null;
        return authReader.replace("Bearer ", "");
    }
    
}
