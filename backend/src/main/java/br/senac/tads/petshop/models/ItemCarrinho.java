package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_itemcarrinho")
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coditemcarrinho")
    private Integer codItemCarrinho;

    @Column(name = "unidades")
    private Integer unidades;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codcarrinho", referencedColumnName = "codcarrinho",
            foreignKey = @ForeignKey(name = "fk_t_itemcarrinho_t_carrinhocompras1"))
    private CarrinhoCompras carrinhoCompras;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codproduto", referencedColumnName = "codproduto",
            foreignKey = @ForeignKey(name = "fk_t_carrinhocompras_t_cliente1"))
    private Produto produto;

}
