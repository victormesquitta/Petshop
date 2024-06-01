package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.PedidoDTO;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.models.Pedido;
import br.senac.tads.petshop.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoDTOMapper {
    private final ModelMapper modelMapper;
    private final ClienteService clienteService;

    @Autowired
    public PedidoDTOMapper(ModelMapper modelMapper, ClienteService clienteService) {
        this.modelMapper = modelMapper;
        this.clienteService = clienteService;
    }

    // Usado para post -> não precisa de id porque ainda não foi criado
    public Pedido toEntity(PedidoDTO pedidoDTO) {
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
        pedido.setCliente(clienteService.obterClientePorId(pedidoDTO.getCodCliente()));
        return pedido;
    }

    // Usado para put -> o id foi criado e deve ser mantido
    // o pedido não pode ser transferido pra outro cliente
    public Pedido toEntity(PedidoDTO pedidoDTO, Integer id, Cliente cliente) {
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
        pedido.setCodPedido(id);
        pedido.setCliente(cliente);
        return pedido;
    }

    public PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
        pedidoDTO.setCodCliente(pedido.getCliente().getCodCliente());
        return pedidoDTO;
    }
}
