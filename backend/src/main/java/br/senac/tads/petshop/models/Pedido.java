package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codpedido")
    private Integer codPedido;

    @Column(name = "dtpedido")
    private LocalDate dtPedido;

    @Column(name = "dtenvio")
    private LocalDate dtEnvio;

    @Column(name = "dtentrega")
    private LocalDate dtEntrega;

    @Column(name = "status")
    private String status;

    @Column(name = "mtdpagamento")
    private String mtdPagamento;

    @Column(name = "qtdprodutos")
    private Integer qtdProdutos;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "taxaenvio", precision = 10, scale = 2)
    private BigDecimal taxaEnvio;

//    @Column(name = "cupomdesconto")
//    private String cupomDesconto;

    @Column(name = "codigorastreamento")
    private String codigoRastreamento;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "codcliente", referencedColumnName = "codcliente",
            foreignKey = @ForeignKey(name = "fk_t_pedido_t_cliente1"))
    private Cliente cliente;

    @ToString.Exclude
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido = new ArrayList<>();

    public void calcularSubtotal() {
        if (itensPedido != null && !itensPedido.isEmpty()) {
            this.subtotal = taxaEnvio.add(itensPedido.stream()
                    .map(ItemPedido::getSubtotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add));
        } else {
            this.subtotal = BigDecimal.ZERO;
        }
    }

    public void atualizarQtdProdutos() {
        if (itensPedido != null && !itensPedido.isEmpty()) {
            this.qtdProdutos = itensPedido.stream()
                    .mapToInt(ItemPedido::getUnidades)
                    .sum();
        } else {
            this.qtdProdutos = 0;
        }
    }


    @PrePersist
    @PreUpdate
    @PreRemove
    public void prePersistOrUpdate() {
        atualizarQtdProdutos();
        calcularSubtotal();
    }
}
