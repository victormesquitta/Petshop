package br.senac.tads.petshop.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codcategoria")
    private Integer codCategoria;

    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Column(name="destaque")
    private boolean destaque;

    @Column(name="ativa")
    private boolean ativa;

    @Column(name="dtcriacao")
    private LocalDate dtCriacao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Subcategoria> subcategorias = new ArrayList<>();

}
