package br.senac.tads.petshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Integer codPedido;
    private LocalDate dtPedido;
    private LocalDate dtCriacao;
    private LocalDate dtModificacao;
    private LocalDate dtEntrega;
    private String status;
    private String mtdPagamento;
    private Double subtotal;
    private Double taxaEnvio;
    private String cupomDesconto;
    private LocalDate dtEnvio;
    private String codigoRastreamento;
    private Integer codCliente;
}
