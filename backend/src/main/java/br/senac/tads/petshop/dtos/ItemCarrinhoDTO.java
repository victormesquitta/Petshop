package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCarrinhoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codItemCarrinho;

    @NotNull(message = "O item do carrinho deve deve pertencer a um carrinho.")
    private Integer codCarrinho;

    @NotNull(message = "O item do carrinho deve estar associado a um produto.")
    private Integer codProduto;

    @NotNull(message = "A quantidade de unidades do item deve ser informada.")
    private Integer unidades;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal subtotal;
}
