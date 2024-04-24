package br.senac.tads.petshop.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_funcionarios")
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codfuncionario")
    private Integer codFuncionario;

    private String nome;

    private String senha;

    private String email;

    /*bom fazer enum */
    private String cargo;

    private int nvlacesso;

    private boolean ativo;

    private LocalDate dtCriacao;

    private LocalDate dtModificacao;
}
