package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codItemPedido;

    @NotNull(message = "O item do pedido deve deve pertencer a um carrinho.")
    private Integer codPedido; // Referência ao Pedido

    @NotNull(message = "O item do pedido deve estar associado a um produto.")
    private Integer codProduto;

    @NotNull(message = "A quantidade de unidades do item deve ser informada.")
    private Integer unidades;

    // irá ser calculado com base na qtd, no precoUnit e no desconto
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal subtotal;

    private String observacao;

    // a data é atribuída na service
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtCriacao;

}
