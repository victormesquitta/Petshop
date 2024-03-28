package br.senac.tads.petshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_carrinhocompras")
public class CarrinhoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcarrinho")
    private Integer codCarrinho;

    @Column(name = "qtdprodutos")
    private Integer qtdProdutos;

    @Column(name = "subtotal")
    private Double subtotal;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codcliente", referencedColumnName = "codcliente",
            foreignKey = @ForeignKey(name = "fk_t_carrinhocompras_t_cliente1"))
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<ItemCarrinho> itensCarrinho = new ArrayList<>();
}
