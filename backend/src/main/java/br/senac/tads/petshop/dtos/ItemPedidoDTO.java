package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {

    private Integer codPedido; // Referência ao Pedido
    private Integer qtd;
    private Double precoUnit;
    private Double desconto;

    // irá ser calculado com base na qtd, no precoUnit e no desconto
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double subtotal;

    private String statusitem;
    private String observacao;

    // a data é atribuída na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtCriacao;

    private LocalDate dtModificacao;
}
