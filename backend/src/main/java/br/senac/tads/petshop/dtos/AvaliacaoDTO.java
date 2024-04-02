package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {

    private int qtdEstrelas;
    private String comentario;

    /*
     Não me parece fazer sentido
     @JsonProperty(access = JsonProperty.Access.READ_ONLY)
     private LocalDate dtAvaliacao;
    */

    private boolean aprovado;
    private String respostaLoja;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtResposta;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtCriacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtModificacao;
}