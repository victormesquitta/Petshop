package br.senac.tads.petshop.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codCategoria;

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    private String descricao;

    private boolean destaque;
    
    private boolean ativa;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtCriacao;
}
