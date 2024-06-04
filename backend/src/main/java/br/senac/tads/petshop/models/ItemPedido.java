package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_itempedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coditempedido")
    private Integer codItemPedido;

    @Column(name = "unidades")
    private Integer unidades;

//    @Column(name = "desconto")
//    private BigDecimal desconto;

    @Column(name = "subtotal")
    private BigDecimal subtotal;


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "codpedido", referencedColumnName = "codpedido",
            foreignKey = @ForeignKey(name = "fk_t_itempedido_t_pedido1"))
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codproduto", referencedColumnName = "codproduto",
            foreignKey = @ForeignKey(name = "fk_t_itempedido_t_produto1"))
    private Produto produto;

    // garantir o arredondamento correto antes de persistir ou atualizar a entidade no banco de dados

    @PrePersist
    @PreUpdate
    public void prePersistOrUpdate() {
        this.subtotal = produto.getPreco().multiply(new BigDecimal(unidades)).setScale(2, RoundingMode.HALF_UP);
    }
}
