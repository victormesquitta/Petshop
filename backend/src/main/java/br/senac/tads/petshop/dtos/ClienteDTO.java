package br.senac.tads.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // pra ignorar no get e ao mesmo tempo conseguir setar no post
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    private String email;
    private String cpf;
    private String nomeCompleto;
    private String celular;
    private String celular2;
    private LocalDate dtNascimento;
    private LocalDate dtCadastro;
    private String status;
    private String genero;
    private boolean prefMarketing;
}
