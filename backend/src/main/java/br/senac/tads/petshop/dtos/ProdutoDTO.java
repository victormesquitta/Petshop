package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codProduto;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codCategoria;

    @NotBlank(message = "O nome do produto não pode estar em branco.")
    private String nome;

    @NotBlank(message = "O nome do produto não pode estar em branco.")
    @Size(max = 2000, message = "A descrição não pode ser superior a 2000 caracteres.")
    private String descricao;

    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(value = "0.01", message = "O valor da transação deve ser maior que 0,00")
    private double preco;

    @NotNull(message = "A quantidade no estoque não pode ser nula.")
    private int qtdEstoque;

    @NotBlank(message = "A marca não pode estar em branco.")
    private String marca;

//    private byte[] imagem;

    private boolean disponivel;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @PastOrPresent(message = "A data de criação não pode ser posterior à atual.")
    private LocalDate dtCriacao;

    private boolean promocao;

    //
//    @DecimalMin(value = "0.01", message = "A avaliação deve ser maior que 0.01.")
//    private double avaliacao;

    // o numero de avaliações vai ser um select da tabela avaliações/comentários
//    private int numeroAvaliacao;
}