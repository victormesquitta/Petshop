package br.senac.tads.petshop.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codavaliacao")
    private Integer codAvaliacao;

    @Column(name="qtdestrelas")
    private int qtdEstrelas;

    @Column(name="comentario")
    private String comentario;

    @Column(name="dtavaliacao")
    private LocalDate dtAvaliacao;

    @Column(name="aprovado")
    private boolean aprovado;

    @Column(name="respostaloja")
    private String respostaLoja;

    @Column(name="dtresposta")
    private LocalDate dtResposta;

    @Column(name="dtcriacao")
    private LocalDate dtCriacao;

    @Column(name="dtmodificacao")
    private LocalDate dtModificacao;
}
