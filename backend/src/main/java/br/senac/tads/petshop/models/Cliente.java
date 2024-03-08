package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcliente")
    private Integer codCliente;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="usuario", nullable = false, unique = true, length = 50)
    private String usuario;

    @Column(name="senha", nullable = false, length = 255)
    private String senha;

    @Column(name="email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name="cpf", unique = true, nullable = false)
    private String cpf;

//    @Lob
//    @Column(columnDefinition = "LONGBLOB", name="foto", nullable = false)
//    private byte[] foto;

    // ver se celular vira único ou não
    @Column(name="celular", nullable = false)
    private String celular;

    @Column(name="celular2")
    private String celular2;

    @Column(name="dtnascimento")
    private LocalDate dataNascimento;

    @Column(name="dtcadastro")
    private LocalDate dataCadastro;

    // ver a necessidade dessa coluna
//    @Column(name="dtultimoacesso")
//    private LocalDate dtUltimoAcesso;

    // conta ativa, inativa ou suspensa
    @Column(name="status", nullable = false)
    private String status;

    @Column(name="genero", nullable = false)
    private String genero;
}
