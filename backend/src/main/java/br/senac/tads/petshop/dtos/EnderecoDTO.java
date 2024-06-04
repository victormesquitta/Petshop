package br.senac.tads.petshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer codCliente;

    @NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato de CEP inválido")
    private String cep;

    @NotBlank(message = "Endereço é obrigatório")
    @Size(max = 100, message = "Endereço deve ter no máximo 100 caracteres")
    private String endereco;

    @NotNull(message = "Número é obrigatório")
    private Integer numero;

    @Size(max = 50, message = "Complemento deve ter no máximo 50 caracteres")
    private String complemento;

    @NotBlank(message = "Bairro é obrigatório")
    @Size(max = 50, message = "Bairro deve ter no máximo 50 caracteres")
    private String bairro;

    @NotBlank(message = "Cidade é obrigatória")
    @Size(max = 50, message = "Cidade deve ter no máximo 50 caracteres")
    private String cidade;

    @NotBlank(message = "UF é obrigatória")
    @Size(min = 2, max = 2, message = "UF deve ter 2 caracteres")
    private String uf;

    private String pontoReferencia;

    private String tipoLocal;
}
