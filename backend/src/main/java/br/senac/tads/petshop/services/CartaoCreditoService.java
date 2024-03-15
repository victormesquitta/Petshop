package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.CartaoCreditoDTO;
import br.senac.tads.petshop.mappers.CartaoCreditoDTOMapper;
import br.senac.tads.petshop.models.CartaoCredito;
import br.senac.tads.petshop.repositories.CartaoCreditoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartaoCreditoService {

    private final CartaoCreditoRepository cartaoCreditoRepository;
    private final CartaoCreditoDTOMapper cartaoCreditoDTOMapper;

    @Autowired
    public CartaoCreditoService(CartaoCreditoRepository cartaoCreditoRepository, CartaoCreditoDTOMapper cartaoCreditoDTOMapper) {
        this.cartaoCreditoRepository = cartaoCreditoRepository;
        this.cartaoCreditoDTOMapper = cartaoCreditoDTOMapper;
    }

    public List<CartaoCredito> listarCartoesCredito() {
        return cartaoCreditoRepository.findAll();
    }

    public void cartaoCreditoExiste(Optional<CartaoCredito> cartaoCreditoOptional) {
        if (cartaoCreditoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum cartão de crédito encontrado para o ID fornecido.");
        }
    }

    public void cartaoCreditoExiste(Integer id) {
        Optional<CartaoCredito> cartaoCreditoOptional = cartaoCreditoRepository.findById(id);
        if (cartaoCreditoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum cartão de crédito encontrado para o ID fornecido.");
        }
    }

    public List<CartaoCreditoDTO> listarCartoesCreditoDTO() {
        List<CartaoCredito> cartoesCredito = cartaoCreditoRepository.findAll();
        return cartoesCredito.stream()
                .map(cartaoCreditoDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CartaoCredito obterCartaoCreditoPorId(Integer id) {
        Optional<CartaoCredito> cartaoCreditoOptional = cartaoCreditoRepository.findById(id);
        return cartaoCreditoOptional.orElseThrow(() -> new EntityNotFoundException("Nenhum cartão de crédito encontrado para o ID fornecido."));
    }

    public CartaoCreditoDTO obterCartaoCreditoDTOPorId(Integer id) {
        Optional<CartaoCredito> cartaoCreditoOptional = cartaoCreditoRepository.findById(id);
        cartaoCreditoExiste(cartaoCreditoOptional);
        return cartaoCreditoOptional.map(cartaoCreditoDTOMapper::toDTO).orElse(null);
    }

    public void criarCartaoCredito(CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCredito cartaoCredito = cartaoCreditoDTOMapper.toEntity(cartaoCreditoDTO);
        cartaoCreditoRepository.save(cartaoCredito);
    }

    public void atualizarCartaoCredito(Integer id, CartaoCreditoDTO cartaoCreditoDTO) {
        cartaoCreditoExiste(id);
        CartaoCredito cartaoCredito = cartaoCreditoDTOMapper.toEntity(cartaoCreditoDTO, id);
        cartaoCreditoRepository.save(cartaoCredito);
    }

    public void excluirCartaoCredito(Integer id) {
        cartaoCreditoExiste(id);
        cartaoCreditoRepository.deleteById(id);
    }
}
