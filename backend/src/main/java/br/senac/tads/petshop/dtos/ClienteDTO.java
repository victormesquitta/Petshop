package br.senac.tads.petshop.dtos;

import br.senac.tads.petshop.enums.Status;
import br.senac.tads.petshop.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer codCliente;

    @NotBlank(message = "O usuario não pode estar em branco.")
    @Size(max = 50, message = "O campo 'usuario' deve ter no máximo 50 caracteres.")
    private String usuario;

    // permite apenas a escrita do atributo
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 4, max = 50, message = "O tamanho da senha precisa ser de 4 a 50 caracteres.")
    private String senha;

    @NotBlank(message = "O e-mail não pode estar em branco.")
    @Email(message = "O campo 'email' deve ser um endereço de e-mail válido")
    private String email;

    //@NotBlank(message = "O CPF não pode estar em branco.")
    @CPF(message = "CPF inválido")
    private String cpf;

    //NotBlank(message = "O nome completo não pode estar em branco.")
    private String nomeCompleto;

    // só aceita números
    //@NotBlank(message = "O celular não pode estar em branco.")
    @NumberFormat
    private String celular;

    private String celular2;

    @Past(message = "A data não pode ser posterior à atual.")
    private LocalDate dtNascimento;

    // permite apenas a leitura do atributo
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @PastOrPresent(message = "A data de cadastro não pode ser posterior à atual.")
    private LocalDate dtCadastro;

    // permite apenas a leitura do atributo
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private Role role;

    // ver a necessidade desse campo no projeto
//    @NotBlank(message = "O gênero não pode estar em branco.")
//    private String genero;

    private boolean prefMarketing;
}