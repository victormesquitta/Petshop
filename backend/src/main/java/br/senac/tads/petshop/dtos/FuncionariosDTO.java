package br.senac.tads.petshop.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionariosDTO {
    
    private Integer codFuncionario;

    private String nome;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    private String email;

    /*bom fazer enum */
    private String cargo;

    private int nvlacesso;

    private boolean ativo;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtModificacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtCriacao;
}
