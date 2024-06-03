package br.senac.tads.petshop.models;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.senac.tads.petshop.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_funcionarios")
public class Funcionario implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codfuncionario")
    private Integer codFuncionario;

    private String nome;

    private String senha;

    private String email;

    private Role role;

    private boolean ativo;

    private LocalDate dtCriacao;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      if(this.role == Role.MASTER) return List.of(new SimpleGrantedAuthority("ROLE_MASTER"));
      else return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
      return senha;
    }

    @Override
    public String getUsername() {
      return email;
    }

    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
      return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public boolean isEnabled() {
      return true;
    }
}
