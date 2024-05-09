package br.senac.tads.petshop.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
    ATIVADO, DESATIVADO, SUSPENSA;

    /*
     *  Método estático que valida valores passados nos JSONs que não correspondam
     *  a nenhum dos presentes no ENUM.
     *
     *  Mais detalhes da implementação:
     *  https://cursos.alura.com.br/forum/topico-validar-enum-290990
     */

    @JsonCreator
    public static Status fromString(String value) {
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido - " + value);
    }
    public static boolean isValid(String status) {
        for (Status unidadeEnum : Status.values()) {
            if (unidadeEnum.name().equals(status)) {
                return true;
            }
        }
        return false;
    }
}
