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

    private String descricao;

    private boolean destaque;

    private boolean ativa;

    private LocalDate dtCriacao;

    private LocalDate dtModificacao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codprodutos", referencedColumnName = "codprodutos",
            foreignKey = @ForeignKey(name = "fk_t_categorias_t_produtos"))
    private Produto produto;




}
