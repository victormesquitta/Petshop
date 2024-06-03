package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_itemcarrinho")
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coditemcarrinho")
    private Integer codItemCarrinho;

    @Column(name = "unidades")
    private Integer unidades;

    @Column(name="subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codcarrinho", referencedColumnName = "codcarrinho",
            foreignKey = @ForeignKey(name = "fk_t_itemcarrinho_t_carrinhocompras1"))
    private CarrinhoCompras carrinhoCompras;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codproduto", referencedColumnName = "codproduto",
            foreignKey = @ForeignKey(name = "fk_t_itemcarrinho_t_produto1"))
    private Produto produto;

    // garantir o arredondamento correto antes de persistir ou atualizar a entidade no banco de dados
    @PrePersist
    @PreUpdate
    public void prePersistOrUpdate() {
        this.subtotal = produto.getPreco().multiply(new BigDecimal(unidades)).setScale(2, RoundingMode.HALF_UP);
    }
}
