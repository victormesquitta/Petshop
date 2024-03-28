package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.ItemCarrinhoDTO;
import br.senac.tads.petshop.mappers.ItemCarrinhoDTOMapper;
import br.senac.tads.petshop.models.ItemCarrinho;
import br.senac.tads.petshop.repositories.ItemCarrinhoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemCarrinhoService {

    private final ItemCarrinhoRepository itemCarrinhoRepository;
    private final ItemCarrinhoDTOMapper itemCarrinhoDTOMapper;

    @Autowired
    public ItemCarrinhoService(ItemCarrinhoRepository itemCarrinhoRepository, ItemCarrinhoDTOMapper itemCarrinhoDTOMapper) {
        this.itemCarrinhoRepository = itemCarrinhoRepository;
        this.itemCarrinhoDTOMapper = itemCarrinhoDTOMapper;
    }

    public List<ItemCarrinho> listarItensCarrinho() {
        List<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findAll();
        return itensCarrinho;
    }

    public List<ItemCarrinhoDTO> listarItensCarrinhoDTO() {
        List<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findAll();
        return itensCarrinho.stream()
                .map(itemCarrinhoDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void itemCarrinhoExiste(Optional<ItemCarrinho> itemCarrinhoOptional) {
        if (itemCarrinhoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum item de carrinho encontrado para o ID fornecido.");
        }
    }

    public void itemCarrinhoExiste(Integer id) {
        Optional<ItemCarrinho> itemCarrinhoOptional = itemCarrinhoRepository.findById(id);
        if (itemCarrinhoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum item de carrinho encontrado para o ID fornecido.");
        }
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

    public void criarItemCarrinho(ItemCarrinhoDTO itemCarrinhoDTO) {
        ItemCarrinho itemCarrinho = itemCarrinhoDTOMapper.toEntity(itemCarrinhoDTO);
        itemCarrinhoRepository.save(itemCarrinho);
    }

    public void atualizarItemCarrinho(Integer id, ItemCarrinhoDTO itemCarrinhoDTO) {
        itemCarrinhoExiste(id);
        ItemCarrinho itemCarrinho = itemCarrinhoDTOMapper.toEntity(itemCarrinhoDTO, id);
        itemCarrinhoRepository.save(itemCarrinho);
    }

    public void excluirItemCarrinho(Integer id) {
        itemCarrinhoExiste(id);
        itemCarrinhoRepository.deleteById(id);
    }
}
