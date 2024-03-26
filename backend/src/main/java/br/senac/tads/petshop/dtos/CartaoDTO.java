package br.senac.tads.petshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDTO {
    private String tipoCartao;
    private String numero;
    private LocalDate dtValidade;
    private String apelido;
    private String nomeCartao;
    private String cvv;
    private String cpf;
    private Integer codCliente;
}
