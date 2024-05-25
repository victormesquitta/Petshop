package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_subcategoria", uniqueConstraints = {@UniqueConstraint(columnNames = "nome", name = "uk_nome_subcategoria")})
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codsubcategoria")
    private Integer codSubcategoria;

//    @Column (name = "imagem")
//    private byte[] imagem;

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

    @ToString.Exclude
    @OneToMany(mappedBy = "subcategoria", cascade = CascadeType.ALL)
    private List<Produto> produtos = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codcategoria", referencedColumnName = "codcategoria",
            foreignKey = @ForeignKey(name = "fk_t_subcategoria_t_categoria1"))
    private Categoria categoria;
}
