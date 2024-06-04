package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.ItemPedidoDTO;
import br.senac.tads.petshop.mappers.ItemPedidoDTOMapper;
import br.senac.tads.petshop.models.*;
import br.senac.tads.petshop.repositories.CarrinhoComprasRepository;
import br.senac.tads.petshop.repositories.ItemPedidoRepository;
import br.senac.tads.petshop.repositories.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemPedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoService pedidoService;
    private final ProdutoService produtoService;
    private final ItemPedidoRepository itemPedidoRepository;
    private final ItemPedidoDTOMapper itemPedidoDTOMapper;

    @Autowired
    public ItemPedidoService(PedidoRepository pedidoRepository, PedidoService pedidoService, ProdutoService produtoService, ItemPedidoRepository itemPedidoRepository, ItemPedidoDTOMapper itemPedidoDTOMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoService = pedidoService;
        this.produtoService = produtoService;
        this.itemPedidoRepository = itemPedidoRepository;
        this.itemPedidoDTOMapper = itemPedidoDTOMapper;
    }

    public List<ItemPedido> obterItensPorCodPedido(Integer codPedido){
        pedidoService.pedidoExiste(codPedido);
        return itemPedidoRepository.findByPedidoCodPedido(codPedido);
    }

    public Page<ItemPedido> listarItensPedido(Pageable pageable) {
        return itemPedidoRepository.findAll(pageable);
    }

    public Page<ItemPedidoDTO> listarItensPedidoDTO(Pageable pageable) {
        Page<ItemPedido> itensPedidoPage = listarItensPedido(pageable);
        List<ItemPedidoDTO> itensPedidoDTO = itensPedidoPage.stream()
                .map(itemPedidoDTOMapper::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(itensPedidoDTO, pageable, itensPedidoPage.getTotalElements());
    }

    public ItemPedido obterItemPedidoPorId(Integer id) {
        Optional<ItemPedido> itemPedidoOptional = itemPedidoRepository.findById(id);
        itemPedidoExiste(itemPedidoOptional);
        return itemPedidoOptional.get();
    }

    public ItemPedidoDTO obterItemPedidoDTOPorId(Integer id) {
        Optional<ItemPedido> itemPedidoOptional = itemPedidoRepository.findById(id);
        itemPedidoExiste(itemPedidoOptional);
        return itemPedidoOptional.map(itemPedidoDTOMapper::toDTO).orElse(null);
    }

    public ItemPedido obterItemPorPedidoEProduto(Pedido pedido, Produto produto){
        Optional<ItemPedido> itemPedidoOptional = itemPedidoRepository.findByPedidoAndProduto(pedido, produto);
        return itemPedidoOptional.orElse(null);
    }

    @Transactional
    public void criarItemPedido(ItemPedidoDTO itemPedidoDTO) {

        if(!pedidoService.pedidoExiste(itemPedidoDTO.getCodPedido())){
            throw new EntityNotFoundException("Não é possível adicionar um item a um pedido que não existe.");
        } else if(!produtoService.produtoExiste(itemPedidoDTO.getCodProduto())){
            throw new EntityNotFoundException("Não é possível vincular um item a um produto que não existe.");

        }

        Integer codProduto = itemPedidoDTO.getCodProduto(), codPedido = itemPedidoDTO.getCodPedido();
        Produto produto = produtoService.obterProdutoPorId(codProduto);
        Pedido pedido = pedidoService.obterPedidoPorId(codPedido);

        ItemPedido itemPedidoExistente = obterItemPorPedidoEProduto(pedido, produto);
        if(itemPedidoExistente != null){
            throw new IllegalArgumentException("O item com o produto especificado já existe no pedido.");
        }
        ItemPedido itemPedido = itemPedidoDTOMapper.toEntity(itemPedidoDTO, pedido, produto);
        itemPedidoRepository.save(itemPedido);
        itemPedido.prePersistOrUpdate();
    }

    @Transactional
    public void atualizarItemPedido(Integer id, ItemPedidoDTO itemPedidoDTO) {
        // valida a existência do item do pedido
        ItemPedido itemPedidoExistente = obterItemPedidoPorId(id);
        if (!produtoService.produtoExiste(itemPedidoDTO.getCodProduto())) {
            throw new EntityNotFoundException("Não é possível vincular um item a um produto que não existe.");

        }
        Produto produto = produtoService.obterProdutoPorId(itemPedidoDTO.getCodProduto());
        Integer codPedido = itemPedidoExistente.getPedido().getCodPedido();
        Pedido pedido = pedidoService.obterPedidoPorId(codPedido);
        ItemPedido itemPedido = itemPedidoDTOMapper.toEntity(itemPedidoDTO, id, pedido, produto);
        itemPedido.prePersistOrUpdate();
        itemPedidoRepository.save(itemPedido);
        pedido.prePersistOrUpdate();
    }

    @Transactional
    public void excluirItemPedido(Integer id) {
        itemPedidoExiste(id);
        itemPedidoRepository.deleteById(id);
    }

    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validaçaõ
    public boolean itemPedidoExiste(Integer id) {
        Optional<ItemPedido> itemPedidoOptional = itemPedidoRepository.findById(id);
        if (itemPedidoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum item de pedido encontrado para o ID fornecido.");
        }
        return true;
    }

    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência
    public boolean itemPedidoExiste(Optional<ItemPedido> itemPedidoOptional) {
        if (itemPedidoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum item de pedido encontrado para o ID fornecido.");
        }
        return true;
    }


}
