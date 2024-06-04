package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "taxaenvio", precision = 10, scale = 2)
    private BigDecimal taxaEnvio;

//    @Column(name = "cupomdesconto")
//    private String cupomDesconto;

    @Column(name = "codigorastreamento")
    private String codigoRastreamento;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codcliente", referencedColumnName = "codcliente",
            foreignKey = @ForeignKey(name = "fk_t_pedido_t_cliente1"))
    private Cliente cliente;
}
