package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codCartaoCredito;

    @NotNull(message = "O cliente é obrigatório.")
    private Integer codCliente;

    @NotBlank(message = "Tipo de cartão é obrigatório")
    private String tipoCartao;

    @NotBlank(message = "Número do cartão é obrigatório")
    @CreditCardNumber(message = "Número do cartão inválido")
    private String numero;

    @NotNull(message = "Data de validade é obrigatória")
    private LocalDate dtValidade;

    @NotBlank(message = "Apelido é obrigatório")
    @Size(max = 50, message = "Apelido deve ter no máximo 50 caracteres")
    private String apelido;

    @NotBlank(message = "Nome do cartão é obrigatório")
    @Size(max = 100, message = "Nome do cartão deve ter no máximo 100 caracteres")
    private String nomeCartao;

    @NotBlank(message = "CVV é obrigatório")
    @Pattern(regexp = "\\d{3}", message = "CVV inválido")
    private String cvv;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF inválido")
    private String cpf;

}
