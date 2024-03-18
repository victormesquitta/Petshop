package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.ItemPedidoDTO;
import br.senac.tads.petshop.mappers.ItemPedidoDTOMapper;
import br.senac.tads.petshop.models.ItemPedido;
import br.senac.tads.petshop.repositories.ItemPedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final ItemPedidoDTOMapper itemPedidoDTOMapper;

    @Autowired
    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository, ItemPedidoDTOMapper itemPedidoDTOMapper) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.itemPedidoDTOMapper = itemPedidoDTOMapper;
    }

    public List<ItemPedido> listarItensPedido() {
        List<ItemPedido> itemPedido = itemPedidoRepository.findAll();
        return itemPedido;
    }

    public List<ItemPedidoDTO> listarItensPedidoDTO() {
        List<ItemPedido> itensPedido = itemPedidoRepository.findAll();
        return itensPedido.stream()
                .map(itemPedidoDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void itemPedidoExiste(Optional<ItemPedido> itemPedidoOptional) {
        if (itemPedidoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum item de pedido encontrado para o ID fornecido.");
        }
    }

    public void itemPedidoExiste(Integer id) {
        Optional<ItemPedido> itemPedidoOptional = itemPedidoRepository.findById(id);
        if (itemPedidoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum item de pedido encontrado para o ID fornecido.");
        }
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

    public void criarItemPedido(ItemPedidoDTO itemPedidoDTO) {
        ItemPedido itemPedido = itemPedidoDTOMapper.toEntity(itemPedidoDTO);
        itemPedidoRepository.save(itemPedido);
    }

    public void atualizarItemPedido(Integer id, ItemPedidoDTO itemPedidoDTO) {
        itemPedidoExiste(id);
        ItemPedido itemPedido = itemPedidoDTOMapper.toEntity(itemPedidoDTO, id);
        itemPedidoRepository.save(itemPedido);
    }

    public void excluirItemPedido(Integer id) {
        itemPedidoExiste(id);
        itemPedidoRepository.deleteById(id);
    }
}
