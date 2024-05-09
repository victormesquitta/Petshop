package br.senac.tads.petshop.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoriaDTO {
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer codcategorias;

    private String nome;

    private String descricao;

    private boolean destaque;
    
    private boolean ativa;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtCriacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtModificacao;
}
