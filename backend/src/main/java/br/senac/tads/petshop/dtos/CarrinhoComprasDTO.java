package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoComprasDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codCarrinho;

    @NotNull(message = "O carrinho de compras deve pertencer a um cliente.")
    private Integer codCliente;

//    @NotNull(message = "A quantidade de produtos não pode ser nula.")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer qtdProdutos;

//    @NotNull(message = "O subtotal não pode ser nulo.")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double subtotal;
}
