package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Integer codPedido;

    // a data é atribuída na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtPedido;

    // a data é atribuída na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtEntrega;

    // o status é atribuído na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String status;


    private String mtdPagamento;

    // irá ser calculado com base nos itens do pedido, na taxa de envio, no cupom de desconto, mtd de pagamento, ...
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double subtotal;

    // a taxa de envio é atribuído na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double taxaEnvio;

    private String cupomDesconto;

    // a data é atribuída na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtEnvio;

    // o codigo de rastreamento é atribuído na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String codigoRastreamento;

    private Integer codCliente;
}
