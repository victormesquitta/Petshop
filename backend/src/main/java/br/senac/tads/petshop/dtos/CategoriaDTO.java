package br.senac.tads.petshop.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codProduto;
    private String nome;
    private String descricao;
    private boolean destaque;
    private boolean ativa;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtCriacao;
    private LocalDate dtModificacao;
}
