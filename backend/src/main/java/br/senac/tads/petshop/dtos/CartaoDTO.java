package br.senac.tads.petshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDTO {
    private String tipoCartao;
    @CreditCardNumber // Validates that a field contains a valid credit card number.
    private String numero;
    private LocalDate dtValidade;
    private String apelido;
    private String nomeCartao;
    private String cvv;
    private String cpf;
    private Integer codCliente;
}
