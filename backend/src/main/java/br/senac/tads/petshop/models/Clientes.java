package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcliente")
    private Integer codCliente;

    @Column(name="nome", nullable = false, unique = true, length = 100)
    private String nome;

    @Column(name="email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name="enderecoprincipal", nullable = false, unique = true)
    private String enderecoPrincipal;


}
