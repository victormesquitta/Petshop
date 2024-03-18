package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.PedidoDTO;
import br.senac.tads.petshop.mappers.PedidoDTOMapper;
import br.senac.tads.petshop.models.Pedido;
import br.senac.tads.petshop.repositories.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoDTOMapper pedidoDTOMapper;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, PedidoDTOMapper pedidoDTOMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoDTOMapper = pedidoDTOMapper;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public List<PedidoDTO> listarPedidosDTO() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream()
                .map(pedidoDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void pedidoExiste(Optional<Pedido> pedidoOptional) {
        if (pedidoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum pedido encontrado para o ID fornecido.");
        }
    }

    public void pedidoExiste(Integer id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum pedido encontrado para o ID fornecido.");
        }
    }

    public Pedido obterPedidoPorId(Integer id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        pedidoExiste(pedidoOptional);
        return pedidoOptional.get();
    }

    public PedidoDTO obterPedidoDTOPorId(Integer id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        pedidoExiste(pedidoOptional);
        return pedidoOptional.map(pedidoDTOMapper::toDTO).orElse(null);
    }

    public void criarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoDTOMapper.toEntity(pedidoDTO);
        pedidoRepository.save(pedido);
    }

    public void atualizarPedido(Integer id, PedidoDTO pedidoDTO) {
        pedidoExiste(id);
        Pedido pedido = pedidoDTOMapper.toEntity(pedidoDTO, id);
        pedidoRepository.save(pedido);
    }

    public void excluirPedido(Integer id) {
        pedidoExiste(id);
        pedidoRepository.deleteById(id);
    }
}
