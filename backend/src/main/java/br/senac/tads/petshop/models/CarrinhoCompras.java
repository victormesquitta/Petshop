package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_carrinhocompras")
@EqualsAndHashCode(exclude = "cliente") // Excluindo cliente para evitar referência cíclica
public class CarrinhoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcarrinho")
    private Integer codCarrinho;

    @Column(name = "qtdprodutos")
    private Integer qtdProdutos;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codcliente", referencedColumnName = "codcliente",
            foreignKey = @ForeignKey(name = "fk_t_carrinhocompras_t_cliente1"))
    private Cliente cliente;

    @ToString.Exclude
    @OneToMany(mappedBy = "carrinhoCompras", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> itensCarrinho = new ArrayList<>();

    public void calcularSubtotal() {
        if (itensCarrinho != null && !itensCarrinho.isEmpty()) {
            this.subtotal = itensCarrinho.stream()
                    .map(ItemCarrinho::getSubtotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        } else {
            this.subtotal = BigDecimal.ZERO;
        }
    }

    public void atualizarQtdProdutos() {
        if (itensCarrinho != null && !itensCarrinho.isEmpty()) {
            this.qtdProdutos = itensCarrinho.stream()
                    .mapToInt(ItemCarrinho::getUnidades)
                    .sum();
        } else {
            this.qtdProdutos = 0;
        }
    }


    @PrePersist
    @PreUpdate
    public void prePersistOrUpdate() {
        atualizarQtdProdutos();
        calcularSubtotal();
    }
}
