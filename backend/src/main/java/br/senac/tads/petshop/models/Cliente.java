package br.senac.tads.petshop.models;

import br.senac.tads.petshop.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.senac.tads.petshop.enums.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_cliente")
public class Cliente implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codcliente")
    private Integer codCliente;

    @Column(name = "role", nullable = true, unique = false, length = 20)
    @Enumerated(EnumType.STRING) 
    private Role role;

    @Column(name="usuario", nullable = true, unique = true, length = 50)
    private String usuario;

    @Column(name="email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name="senha", nullable = false, length = 255)
    private String senha;

    @Column(name="nomecompleto", nullable = true)
    private String nomeCompleto;

    //    @Lob
//    @Column(columnDefinition = "LONGBLOB", name="foto", nullable = false)
//    private byte[] foto;
// ver se celular vira único ou não
    @Column(name="celular", nullable = true)
    private String celular;

    @Column(name="celular2")
    private String celular2;

    @Column(name="dtnascimento")
    private LocalDate dtNascimento;

    // conta ativa, inativa ou suspensa
    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = true)
    private Status status;

    // ver a necessidade desse campo no projeto
//    @Column(name="genero", nullable = false)
//    private String genero;

    @Column(name="dtcadastro")
    private LocalDate dtCadastro;

    @Column(name="cpf", unique = true, nullable = true)
    private String cpf;

    @Column(name="prefmarketing")
    private boolean prefMarketing;

    // ver a necessidade dessa coluna
//    @Column(name="dtultimoacesso")
//    private LocalDate dtUltimoAcesso;


    // evita problemas de recursividade no relacionamento

    // pra permitir a remoção dos pais e apagar os filhos em cascata
    @ToString.Exclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();

    @ToString.Exclude
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private CarrinhoCompras carrinhoCompras;

    public Cliente(String email, String senha, Role role) {
        this.email = email;
        this.senha = senha;
        this.role = role;
      }

//    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
//    private List<Pedido> pedidos = new ArrayList<>();
//
//    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
//    private List<Pedido> pedidos = new ArrayList<>();
//
//    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
//    private List<Pedido> pedidos = new ArrayList<>();
//
//    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
//    private List<Pedido> pedidos = new ArrayList<>();

@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      if(this.role == Role.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
      else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
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
