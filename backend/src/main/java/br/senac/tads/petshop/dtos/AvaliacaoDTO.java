package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codAvaliacao;

    @NotNull(message = "O código do produto não pode ser nulo.")
    private Integer codProduto;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtAvaliacao;

    private int qtdEstrelas;

    @NotBlank(message = "A avaliação precisa ter um título.")
    @Size(min = 3, max = 50, message = "O título da avaliação precisa ter ")
    private String titulo;

    private String comentario;

    /*
     Não me parece fazer sentido
     @JsonProperty(access = JsonProperty.Access.READ_ONLY)
     private LocalDate dtAvaliacao;
    */

//    private boolean aprovado;
//    private String respostaLoja;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private LocalDate dtResposta;


}