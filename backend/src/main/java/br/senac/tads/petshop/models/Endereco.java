package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codendereco")
    private Integer codEndereco;

    @Column(name = "cep")
    private String cep;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "pontoref")
    private String pontoReferencia;

//    , columnDefinition = "COMMENT 'Tipo de local: casa, trabalho, ou outro local de entrega'"
    @Comment("Tipo de local: casa, trabalho, ou outro local de entrega")
//    @Column(name = "tipolocal", nullable = false, columnDefinition = "VARCHAR(255) COMMENT 'Tipo de local: casa, trabalho, ou outro local de entrega'")
    @Column(name = "tipolocal")
    private String tipoLocal;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codcliente", referencedColumnName = "codcliente",
            foreignKey = @ForeignKey(name = "fk_t_endereco_t_cliente1"))
    private Cliente cliente;
}
