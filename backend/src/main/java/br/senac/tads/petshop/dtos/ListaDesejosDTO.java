package br.senac.tads.petshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaDesejosDTO {
    private LocalDate dtAdicao;
    private LocalDate dtRemocao;
    private Integer codCliente;
}
