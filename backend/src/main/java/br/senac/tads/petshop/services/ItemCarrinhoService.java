package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.CarrinhoComprasDTO;
import br.senac.tads.petshop.dtos.ItemCarrinhoDTO;
import br.senac.tads.petshop.mappers.ItemCarrinhoDTOMapper;
import br.senac.tads.petshop.models.CarrinhoCompras;
import br.senac.tads.petshop.models.ItemCarrinho;
import br.senac.tads.petshop.models.Produto;
import br.senac.tads.petshop.repositories.CarrinhoComprasRepository;
import br.senac.tads.petshop.repositories.ItemCarrinhoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemCarrinhoService {

    private final CarrinhoComprasService carrinhoComprasService;
    private final ProdutoService produtoService;
    private final ItemCarrinhoRepository itemCarrinhoRepository;
    private final CarrinhoComprasRepository carrinhoComprasRepository;
    private final ItemCarrinhoDTOMapper itemCarrinhoDTOMapper;

    @Autowired
    public ItemCarrinhoService(CarrinhoComprasService carrinhoComprasService, ProdutoService produtoService, ItemCarrinhoRepository itemCarrinhoRepository, CarrinhoComprasRepository carrinhoComprasRepository, ItemCarrinhoDTOMapper itemCarrinhoDTOMapper) {
        this.carrinhoComprasService = carrinhoComprasService;
        this.produtoService = produtoService;
        this.itemCarrinhoRepository = itemCarrinhoRepository;
        this.carrinhoComprasRepository = carrinhoComprasRepository;
        this.itemCarrinhoDTOMapper = itemCarrinhoDTOMapper;
    }

    public List<ItemCarrinho> obterItensPorCodCarrinho(Integer codCarrinho) {
        carrinhoComprasService.carrinhoComprasExiste(codCarrinho);
        return itemCarrinhoRepository.findByCarrinhoComprasCodCarrinho(codCarrinho);
    }
    public Page<ItemCarrinho> listarItensCarrinho(Pageable pageable) {
        return itemCarrinhoRepository.findAll(pageable);
    }

    public Page<ItemCarrinhoDTO> listarItensCarrinhoDTO(Pageable pageable) {
        Page<ItemCarrinho> itemCarrinhosPage = listarItensCarrinho(pageable);
        List<ItemCarrinhoDTO> itensCarrinhoDTO = itemCarrinhosPage.stream()
                .map(itemCarrinhoDTOMapper::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(itensCarrinhoDTO, pageable, itemCarrinhosPage.getTotalElements());
    }

    public ItemCarrinho obterItemCarrinhoPorId(Integer id) {
        Optional<ItemCarrinho> itemCarrinhoOptional = itemCarrinhoRepository.findById(id);
        itemCarrinhoExiste(itemCarrinhoOptional);
        return itemCarrinhoOptional.get();
    }

    public ItemCarrinhoDTO obterItemCarrinhoDTOPorId(Integer id) {
        Optional<ItemCarrinho> itemCarrinhoOptional = itemCarrinhoRepository.findById(id);
        itemCarrinhoExiste(itemCarrinhoOptional);
        return itemCarrinhoOptional.map(itemCarrinhoDTOMapper::toDTO).orElse(null);
    }

    @Transactional
    public void criarItemCarrinho(ItemCarrinhoDTO itemCarrinhoDTO) {
        /*
        * Problema identificado: botão carrinho e "+"/"-" no item pra incrementar.
        * Se o produto já está um item, eu volto pra página dele e aperto pra add ao carrinho, ele vai criar outro item.
        *
        * */

        // valida se o carrinho e o produto passados existem

        /*
            ver se a validação vai ser assim pq dá pra fazer
            obtendo o produto e carrinho pelo id  (dentro do método já valida)
        */
        if(!carrinhoComprasService.carrinhoComprasExiste(itemCarrinhoDTO.getCodCarrinho())){
            throw new EntityNotFoundException("Não é possível adicionar um item a um carrinho que não existe.");
        } else if (!produtoService.produtoExiste(itemCarrinhoDTO.getCodProduto())) {
            throw new EntityNotFoundException("Não é possível vincular um item a um produto que não existe.");
        }

        // obtém e valida existência de produto e carrinho de compras
        Integer codProduto = itemCarrinhoDTO.getCodProduto(), codCarrinho = itemCarrinhoDTO.getCodCarrinho();
        Produto produto = produtoService.obterProdutoPorId(codProduto);
        CarrinhoCompras carrinhoCompras = carrinhoComprasService.obterCarrinhoComprasPorId(codCarrinho);

//        BigDecimal precoUnitario = produto.getPreco();
//        Integer unidades = itemCarrinhoDTO.getUnidades();
//
//        itemCarrinhoDTO.setSubtotal(precoUnitario * unidades);
//        System.out.println(carrinhoCompras.getItensCarrinho());

        ItemCarrinho itemCarrinho = itemCarrinhoDTOMapper.toEntity(itemCarrinhoDTO, carrinhoCompras, produto);
//        itemCarrinho.setSubtotal(0.0);
        itemCarrinhoRepository.save(itemCarrinho);

        // atualizando o carrinho
        System.out.println("Pegando itens carrinho certinho: " + obterItensPorCodCarrinho(codCarrinho));
//        for(ItemCarrinho item : obterItensPorCodCarrinho(codCarrinho)){
//
//        }
//        System.out.println(soma);

        carrinhoCompras.calcularSubtotal();
    }

    @Transactional
    public void atualizarItemCarrinho(Integer id, ItemCarrinhoDTO itemCarrinhoDTO) {
        // valida a existência do item do carrinho
        ItemCarrinho itemCarrinhoExistente = obterItemCarrinhoPorId(id);

        /*
            ver se a validação vai ser assim pq dá pra fazer
            obtendo o produto pelo id  (dentro do método já valida)
        */
        if (!produtoService.produtoExiste(itemCarrinhoDTO.getCodProduto())) {
            throw new EntityNotFoundException("Não é possível vincular um item a um produto que não existe.");
        }

//        Integer codProduto = itemCarrinhoDTO.getCodProduto();
//        Produto produto = produtoService.obterProdutoPorId(codProduto);
//
//        BigDecimal precoUnitario = produto.getPreco();
//        Integer unidades = itemCarrinhoDTO.getUnidades();
//
//
//        itemCarrinhoDTO.setSubtotal(precoUnitario * unidades);

        Produto produto = produtoService.obterProdutoPorId(itemCarrinhoDTO.getCodProduto());
        Integer codCarrinho = itemCarrinhoExistente.getCodItemCarrinho();
        CarrinhoCompras carrinhoCompras = carrinhoComprasService.obterCarrinhoComprasPorId(codCarrinho);
        ItemCarrinho itemCarrinho = itemCarrinhoDTOMapper.toEntity(itemCarrinhoDTO, id, carrinhoCompras, produto);
        itemCarrinho.prePersistOrUpdate();
        itemCarrinhoRepository.save(itemCarrinho);

        // atualizando o carrinho
        carrinhoCompras.calcularSubtotal();
    }

    @Transactional
    public void excluirItemCarrinho(Integer id) {
        // Obtém o item do carrinho pelo ID
        ItemCarrinho itemCarrinho = obterItemCarrinhoPorId(id);

        // Obtém o carrinho ao qual o item pertence
        CarrinhoCompras carrinhoCompras = itemCarrinho.getCarrinhoCompras();

        // Exclui o item do carrinho
        itemCarrinhoRepository.deleteById(id);

        // Remove o item da lista de itens do carrinho para garantir que a referência seja atualizada corretamente
        carrinhoCompras.getItensCarrinho().removeIf(item -> item.getCodItemCarrinho().equals(id));

        // Recalcula e atualiza o subtotal do carrinho
        carrinhoCompras.calcularSubtotal();
        carrinhoComprasRepository.save(carrinhoCompras);
    }


    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validaçaõ
    public boolean itemCarrinhoExiste(Integer id) {
        Optional<ItemCarrinho> itemCarrinhoOptional = itemCarrinhoRepository.findById(id);
        if (itemCarrinhoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum item de carrinho encontrado para o ID fornecido.");
        }
        return true;
    }

    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência
    public boolean itemCarrinhoExiste(Optional<ItemCarrinho> itemCarrinhoOptional) {
        if (itemCarrinhoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum item de carrinho encontrado para o ID fornecido.");
        }
        return true;
    }
}
