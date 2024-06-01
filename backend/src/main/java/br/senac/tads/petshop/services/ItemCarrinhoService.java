package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.ItemCarrinhoDTO;
import br.senac.tads.petshop.mappers.ItemCarrinhoDTOMapper;
import br.senac.tads.petshop.models.ItemCarrinho;
import br.senac.tads.petshop.repositories.ItemCarrinhoRepository;
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
public class ItemCarrinhoService {

    private final CarrinhoComprasService carrinhoComprasService;
    private final ItemCarrinhoRepository itemCarrinhoRepository;
    private final ItemCarrinhoDTOMapper itemCarrinhoDTOMapper;

    @Autowired
    public ItemCarrinhoService(CarrinhoComprasService carrinhoComprasService, ItemCarrinhoRepository itemCarrinhoRepository, ItemCarrinhoDTOMapper itemCarrinhoDTOMapper) {
        this.carrinhoComprasService = carrinhoComprasService;
        this.itemCarrinhoRepository = itemCarrinhoRepository;
        this.itemCarrinhoDTOMapper = itemCarrinhoDTOMapper;
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
        
        // valida se o carrinho passado existe
        if(!carrinhoComprasService.carrinhoComprasExiste(itemCarrinhoDTO.getCodCarrinho())){
            throw new EntityNotFoundException("Não é possível adicionar um item a um carrinho que não existe.");
        }
        ItemCarrinho itemCarrinho = itemCarrinhoDTOMapper.toEntity(itemCarrinhoDTO);

        itemCarrinhoRepository.save(itemCarrinho);
    }

    @Transactional
    public void atualizarItemCarrinho(Integer id, ItemCarrinhoDTO itemCarrinhoDTO) {
        itemCarrinhoExiste(id);
        ItemCarrinho itemCarrinho = itemCarrinhoDTOMapper.toEntity(itemCarrinhoDTO, id);
        itemCarrinhoRepository.save(itemCarrinho);
    }

    @Transactional
    public void excluirItemCarrinho(Integer id) {
        itemCarrinhoExiste(id);
        itemCarrinhoRepository.deleteById(id);
    }

    public boolean itemCarrinhoExiste(Optional<ItemCarrinho> itemCarrinhoOptional) {
        if (itemCarrinhoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum item de carrinho encontrado para o ID fornecido.");
        }
        return true;
    }

    public boolean itemCarrinhoExiste(Integer id) {
        Optional<ItemCarrinho> itemCarrinhoOptional = itemCarrinhoRepository.findById(id);
        if (itemCarrinhoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum item de carrinho encontrado para o ID fornecido.");
        }
        return true;
    }
}
