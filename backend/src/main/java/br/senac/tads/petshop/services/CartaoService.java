package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.CartaoDTO;
import br.senac.tads.petshop.mappers.CartaoDTOMapper;
import br.senac.tads.petshop.models.Cartao;
import br.senac.tads.petshop.repositories.CartaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartaoService {

    private final ClienteService clienteService;
    private final CartaoRepository cartaoRepository;
    private final CartaoDTOMapper cartaoDTOMapper;

    @Autowired
    public CartaoService(ClienteService clienteService, CartaoRepository cartaoRepository, CartaoDTOMapper cartaoDTOMapper) {
        this.clienteService = clienteService;
        this.cartaoRepository = cartaoRepository;
        this.cartaoDTOMapper = cartaoDTOMapper;
    }

    public Page<Cartao> listarCartoesCredito(Pageable pageable) {
        return cartaoRepository.findAll(pageable);
    }


    public Page<CartaoDTO> listarCartoesDTO(Pageable pageable) {
        Page<Cartao> cartoesPage = listarCartoesCredito(pageable);
        List<CartaoDTO> cartoesDTO = cartoesPage.stream()
                .map(cartaoDTOMapper::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(cartoesDTO, pageable, cartoesPage.getTotalElements());

    }

    public CartaoDTO obterCartaoDTOPorId(Integer id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
        cartaoExiste(cartaoOptional);
        return cartaoOptional.map(cartaoDTOMapper::toDTO).orElse(null);
    }

    public List<CartaoDTO> findCartoesByClienteId(Integer clienteId) {
        List<Cartao> cartoes = cartaoRepository.findByClienteCodCliente(clienteId);
        List<CartaoDTO> cartaoDTOs = new ArrayList<>();
        
        for (Cartao c : cartoes) {
            CartaoDTO dto = cartaoDTOMapper.toDTO(c);
            cartaoDTOs.add(dto);
        }
        return cartaoDTOs;
    }

    public Cartao obterCartaoPorId(Integer id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
        cartaoExiste(cartaoOptional);
        return cartaoOptional.orElseThrow(() -> new EntityNotFoundException("Nenhum cartão encontrado para o ID fornecido."));
    }

    @Transactional
    public void cadastrarCartao(CartaoDTO cartaoDTO) {
        // valida se o cliente passado existe
        if(!clienteService.clienteExiste(cartaoDTO.getCodCliente())){
            throw new EntityNotFoundException("Não é possível adicionar um cartão a um cliente que não existe.");
        }
        Cartao cartao = cartaoDTOMapper.toEntity(cartaoDTO);
        cartaoRepository.save(cartao);
    }

    @Transactional
    public void atualizarCartao(Integer id, CartaoDTO cartaoDTO) {
        cartaoExiste(id);
        // valida se o cliente passado existe
        if(!clienteService.clienteExiste(cartaoDTO.getCodCliente())){
            throw new EntityNotFoundException("Não é possível adicionar um cartão a um cliente que não existe.");
        }
        Cartao cartao = cartaoDTOMapper.toEntity(cartaoDTO, id);
        cartaoRepository.save(cartao);
    }

    @Transactional
    public void excluirCartao(Integer id) {
        cartaoExiste(id);
        cartaoRepository.deleteById(id);
    }

    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validação
    public boolean cartaoExiste(Integer id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
        if (cartaoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum cartão encontrado para o ID fornecido.");
        }
        return true;
    }

    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência
    public boolean cartaoExiste(Optional<Cartao> optionalCartao) {
        if (optionalCartao.isEmpty()) {
            throw new EntityNotFoundException("Nenhum cartão encontrado para o ID fornecido.");
        }
        return true;
    }


}
