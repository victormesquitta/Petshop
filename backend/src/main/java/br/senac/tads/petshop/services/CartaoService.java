package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.CartaoDTO;
import br.senac.tads.petshop.mappers.CartaoDTOMapper;
import br.senac.tads.petshop.models.Cartao;
import br.senac.tads.petshop.repositories.CartaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartaoService {

    private final CartaoRepository cartaoRepository;
    private final CartaoDTOMapper cartaoDTOMapper;

    @Autowired
    public CartaoService(CartaoRepository cartaoRepository, CartaoDTOMapper cartaoDTOMapper) {
        this.cartaoRepository = cartaoRepository;
        this.cartaoDTOMapper = cartaoDTOMapper;
    }

    public List<Cartao> listarCartoesCredito() {
        return cartaoRepository.findAll();
    }

    public void cartaoExiste(Optional<Cartao> optionalCartao) {
        if (optionalCartao.isEmpty()) {
            throw new EntityNotFoundException("Nenhum cartão encontrado para o ID fornecido.");
        }
    }

    public void cartaoExiste(Integer id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
        if (cartaoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum cartão encontrado para o ID fornecido.");
        }
    }

    public List<CartaoDTO> listarCartoesDTO() {
        List<Cartao> cartoes = cartaoRepository.findAll();
        return cartoes.stream()
                .map(cartaoDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Cartao obterCartaoPorId(Integer id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
        return cartaoOptional.orElseThrow(() -> new EntityNotFoundException("Nenhum cartão encontrado para o ID fornecido."));
    }

    public CartaoDTO obterCartaoDTOPorId(Integer id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
        cartaoExiste(cartaoOptional);
        return cartaoOptional.map(cartaoDTOMapper::toDTO).orElse(null);
    }

    public void criarCartao(CartaoDTO cartaoDTO) {
        Cartao cartao = cartaoDTOMapper.toEntity(cartaoDTO);
        cartaoRepository.save(cartao);
    }

    public void atualizarCartao(Integer id, CartaoDTO cartaoDTO) {
        cartaoExiste(id);
        Cartao cartao = cartaoDTOMapper.toEntity(cartaoDTO, id);
        cartaoRepository.save(cartao);
    }

    public void excluirCartao(Integer id) {
        cartaoExiste(id);
        cartaoRepository.deleteById(id);
    }
}
