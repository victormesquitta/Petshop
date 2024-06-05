package br.senac.tads.petshop.dtos;

import br.senac.tads.petshop.enums.Role;

public record RegistroDTO(
        String email, String senha, Role role) {
    
}
