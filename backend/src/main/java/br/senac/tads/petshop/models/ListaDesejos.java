package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_listadesejos")
public class ListaDesejos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codlistadesejos")
    private Integer codListaDesejos;

    @Column(name="dtadicao")
    private LocalDate dtAdicao;

    @Column(name="dtremocao")
    private LocalDate dtRemocao;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codcliente", referencedColumnName = "codcliente",
            foreignKey = @ForeignKey(name = "fk_t_listadesejos_t_cliente1"))
    private Cliente cliente;
}
