package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codPedido;

    @NotNull(message = "O codCliente não pode ser nulo.")
    private Integer codCliente;

    // a data é atribuída na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtPedido;

    // a data é atribuída na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtEnvio;

    // a data é atribuída na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtEntrega;

    // o status é atribuído na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String status;

    // como no mvp vai ter apenas cartão de crédito como pagamento, não vamos deixar o usuário decidir isso
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String mtdPagamento;

    // irá ser calculado com base nos itens do pedido, na taxa de envio, no cupom de desconto, mtd de pagamento, ...
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double subtotal;

    // a taxa de envio é atribuída na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double taxaEnvio;

//    private String cupomDesconto;


    // o codigo de rastreamento é atribuído na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String codigoRastreamento;


}
