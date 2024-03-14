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
@Table(name = "t_cartoescredito")
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codcartaocredito")
    private Integer codCartaoCredito;

    @Column(name="numero")
    private String numero;

    @Column(name="dtvalidade")
    private LocalDate dtValidade;

    // apelidar o cartão, como "Nubank Virtual"
    @Column(name="apelido")
    private String apelido;

    @Column(name="nomecartao")
    private String nomeCartao;

    @Column(name="cvv")
    private String cvv;

    @Column(name="cpf")
    private String cpf;

}
