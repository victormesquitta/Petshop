package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_subcategoria")
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codsubcategorias")
    private Integer codsubCategoria;

    @Column (name = "imagem")
    private byte[] imagem;

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
    @JoinColumn(name = "codcategorias", referencedColumnName = "codcategorias",
            foreignKey = @ForeignKey(name = "fk_t_subcategorias_t_categorias"))
    private Categoria categoria;



}
