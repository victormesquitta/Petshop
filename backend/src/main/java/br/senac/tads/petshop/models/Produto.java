package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_produto", uniqueConstraints = {@UniqueConstraint(columnNames = "nome", name = "uk_nome_veiculo")})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codproduto")
    private Integer codProduto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private double preco;

    @Column(name = "qtdestoque")
    private int qtdEstoque;

    @Column (name = "marca")
    private String marca;

//    @Column (name = "imagem")
//    private byte[] imagem;

    @Column (name = "disponivel")
    private boolean disponivel;

    @Column (name = "dtcriacao")
    private LocalDate dtCriacao;

    /* Se vai aparecer na página de destaque (home) */
    @Column (name = "destaque")
    private boolean destaque;

//    @Column (name = "avaliacao")
//    private double avaliacao;

//    @Column (name = "numeroavaliacao")
//    private int numeroAvaliacao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codcategoria", referencedColumnName = "codcategoria",
            foreignKey = @ForeignKey(name = "fk_t_produto_t_categoria1"))
    private Categoria categoria;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes = new ArrayList<>();


}