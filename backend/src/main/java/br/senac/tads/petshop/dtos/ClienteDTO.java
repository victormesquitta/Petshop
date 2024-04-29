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
public class ClienteDTO {

    @NotBlank(message = "O campo 'usuario' não pode estar em branco.")
    @Size(max = 50, message = "O campo 'usuario' deve ter no máximo 50 caracteres.")
    private String usuario;

    // permite apenas a escrita do atributo
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8, max = 50)
    private String senha;

    @Email(message = "O campo 'email' deve ser um endereço de e-mail válido")
    private String email;


    private String cpf;
    private String nomeCompleto;

    // só aceita números
    private String celular;
    private String celular2;

    @Past
    private LocalDate dtNascimento;

    // permite apenas a leitura do atributo
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtCadastro;

    private String status;
    private String genero;
    private boolean prefMarketing;
}
