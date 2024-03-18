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
@Table(name = "t_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codprodutos")
    private Integer codprodutos;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private double preco;

    @Column(name = "qtd_estoque")
    private int qtd_estoque;

    @Column (name = "marca")
    private String marca;

    @Column (name = "imagem")
    private byte[] imagem;

    @Column (name = "disponivel")
    private boolean disponivel;

    @Column (name = "dt_criacao")
    private LocalDate dt_criacao;

    @Column (name = "dt_modificacao")
    private LocalDate dt_modificacao;

    @Column (name = "destaque")
    private boolean destaque;

    @Column (name = "promocao")
    private boolean promocao;

    @Column (name = "avaliacao")
    private double avaliacao;

    @Column (name = "nm_avaliacao")
    private int nm_avaliacao;
}