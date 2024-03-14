package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String usuario;

    // permite apenas a escrita do atributo
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    private String email;
    private String cpf;
    private String nomeCompleto;
    private String celular;
    private String celular2;
    private LocalDate dtNascimento;

    // permite apenas a leitura do atributo
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dtCadastro;

    private String status;
    private String genero;
    private boolean prefMarketing;
}
