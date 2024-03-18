package br.senac.tads.petshop.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codcategorias")
    private Integer codCategorias;

    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Column(name="destaque")
    private boolean destaque;

    @Column(name="ativa")
    private boolean ativa;

    @Column(name="dtcriacao")
    private LocalDate dtCriacao;

    @Column(name="dtmodificacao")
    private LocalDate dtModificacao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codprodutos", referencedColumnName = "codprodutos",
            foreignKey = @ForeignKey(name = "fk_t_categorias_t_produtos"))
    private Produto produto;




}
