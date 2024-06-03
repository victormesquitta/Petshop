package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_produto", uniqueConstraints = {@UniqueConstraint(columnNames = "nome", name = "uk_nome_produto")})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codproduto")
    private Integer codProduto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco", precision = 10, scale = 2)
    private BigDecimal preco;

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
    @JoinColumn(name = "codsubcategoria", referencedColumnName = "codsubcategoria",
            foreignKey = @ForeignKey(name = "fk_t_produto_t_subcategoria1"))
    private Subcategoria subcategoria;

    @ToString.Exclude
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ItemCarrinho> itensCarrinhos = new ArrayList<>();

    // garantir o arredondamento correto antes de persistir ou atualizar a entidade no banco de dados
    @PrePersist
    @PreUpdate
    private void prePersistOrUpdate() {
        this.preco = this.preco.setScale(2, RoundingMode.HALF_UP);
    }
}