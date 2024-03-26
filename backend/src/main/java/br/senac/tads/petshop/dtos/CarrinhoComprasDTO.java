package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoComprasDTO {

    private Integer qtdProdutos;
    private Double subtotal;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer codCliente;

}
