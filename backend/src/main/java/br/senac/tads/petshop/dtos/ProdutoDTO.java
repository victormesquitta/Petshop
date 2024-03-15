package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private String nome;
    
    private String descricao;

    private double preco;

    private int qt_estoque;

    private String categoria;

    private String marca;

    private byte[] imagem;

    private boolean disponivel;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dt_criacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dt_modificacao;

    private boolean promocao;

    private double avaliacao;

    private int nm_avaliacao;
}