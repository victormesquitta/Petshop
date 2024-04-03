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
@Table(name="t_itempedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coditempedido")
    private Integer codItemPedido;

    @Column(name = "qtd")
    private Integer qtd;

    @Column(name = "precounit")
    private Double precoUnit;

    @Column(name = "desconto")
    private Double desconto;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "statusitem")
    private String statusitem;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "dtcriacao")
    private LocalDate dtCriacao;

    @Column(name = "dtmodificacao")
    private LocalDate dtModificacao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codpedido", referencedColumnName = "codpedido",
            foreignKey = @ForeignKey(name = "fk_t_itempedido_t_pedido1"))
    private Pedido pedido;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codproduto", referencedColumnName = "codproduto",
            foreignKey = @ForeignKey(name = "fk_t_itempedido_t_produto1"))
    private Produto produto;
}
