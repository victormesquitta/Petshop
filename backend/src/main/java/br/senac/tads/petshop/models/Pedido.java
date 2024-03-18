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
@Table(name="t_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codpedido")
    private Integer codPedido;

    @Column(name = "dtpedido")
    private LocalDate dtPedido;

    @Column(name = "dtentrega")
    private LocalDate dtEntrega;

    @Column(name = "status")
    private String status;

    @Column(name = "mtdpagamento")
    private String mtdPagamento;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "taxaenvio")
    private Double taxaEnvio;

    @Column(name = "cupomdesconto")
    private String cupomDesconto;

    @Column(name = "dtenvio")
    private LocalDate dtEnvio;

    @Column(name = "codigorastreamento")
    private String codigoRastreamento;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codcliente", referencedColumnName = "codcliente",
            foreignKey = @ForeignKey(name = "fk_t_pedido_t_cliente1"))
    private Cliente cliente;
}
