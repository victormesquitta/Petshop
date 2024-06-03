package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.PedidoDTO;
import br.senac.tads.petshop.mappers.PedidoDTOMapper;
import br.senac.tads.petshop.models.Pedido;
import br.senac.tads.petshop.repositories.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    private final ClienteService clienteService;
    private final PedidoRepository pedidoRepository;
    private final PedidoDTOMapper pedidoDTOMapper;

    @Autowired
    public PedidoService(ClienteService clienteService, PedidoRepository pedidoRepository, PedidoDTOMapper pedidoDTOMapper) {
        this.clienteService = clienteService;
        this.pedidoRepository = pedidoRepository;
        this.pedidoDTOMapper = pedidoDTOMapper;
    }

    public Page<Pedido> listarPedidos(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    public Page<PedidoDTO> listarPedidosDTO(Pageable pageable) {
        Page<Pedido> pedidosPage = listarPedidos(pageable);
        List<PedidoDTO> pedidosDTO = pedidosPage.stream()
                .map(pedidoDTOMapper::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(pedidosDTO, pageable, pedidosPage.getTotalElements());
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

    public List<Pedido> findPedidosByClienteId(Integer clienteId) {
        return pedidoRepository.findByClienteCodCliente(clienteId);
    }

    @Transactional
    public void cadastrarPedido(PedidoDTO pedidoDTO) {
        // valida se o cliente passado existe
        if(!clienteService.clienteExiste(pedidoDTO.getCodCliente())){
            throw new EntityNotFoundException("Não é possível adicionar um pedido a um cliente que não existe.");
        }
        Pedido pedido = pedidoDTOMapper.toEntity(pedidoDTO);
        System.out.println(pedido.toString());
        /*
        *  Valida a questão dos úteis para envio e entrega.
        *  Dt do pedido: dia atual no qual se fez o pedido.
        *  Dt de Envio: 5 dias úteis a partir da data do pedido.
        *  Dt de Entrega: 2 dias úteis a partir da data de envio.
        * */
        LocalDate dtPedido = LocalDate.now(),
                dtEnvio = dtPedido.plusDays(5),
                dtEntrega;

        pedido.setDtPedido(dtPedido);
        while(dtEnvio.getDayOfWeek() == DayOfWeek.SATURDAY || dtEnvio.getDayOfWeek() == DayOfWeek.SUNDAY){
            dtEnvio = dtEnvio.plusDays(1);
        }
        pedido.setDtEnvio(dtEnvio);
        dtEntrega = dtEnvio.plusDays(2);
        while(dtEntrega.getDayOfWeek() == DayOfWeek.SATURDAY || dtEntrega.getDayOfWeek() == DayOfWeek.SUNDAY){
            dtEntrega = dtEntrega.plusDays(1);
        }
        pedido.setDtEntrega(dtEntrega);

        pedido.setStatus("Pendente");

        //  mvp vai ter apenas cartão de crédito como pagamento
        pedido.setMtdPagamento("Cartão de Crédito");

        // ver como vai ser esse cálculo
        pedido.setSubtotal(0.0);

        // ver como vai ser esse cálculo
        pedido.setTaxaEnvio(0.0);


        pedido.setCodigoRastreamento(gerarCodigoRastreamento());

        pedidoRepository.save(pedido);
    }

    @Transactional
    public void atualizarPedido(Integer id, PedidoDTO pedidoDTO) {
        // valida a existência do produto
        Pedido pedidoExistente = obterPedidoPorId(id);

        if(!clienteService.clienteExiste(pedidoDTO.getCodCliente())){
            throw new EntityNotFoundException("Não é possível adicionar um pedido a um cliente que não existe.");
        }
        LocalDate dtPedido = pedidoExistente.getDtPedido();
//                dtEnvio = pedidoExistente.getDtEnvio(),
//                dtEntrega = pedidoExistente.getDtEntrega();
        String status = pedidoExistente.getStatus(),
                mtdPagamento = pedidoExistente.getMtdPagamento(),
                codigoRastremento = pedidoExistente.getCodigoRastreamento();
        Double subtotal = pedidoExistente.getSubtotal(),
                taxaEnvio = pedidoExistente.getTaxaEnvio();
        Pedido pedido = pedidoDTOMapper.toEntity(pedidoDTO, id, pedidoExistente.getCliente());
        pedido.setCliente(pedidoExistente.getCliente());
        pedido.setDtPedido(dtPedido);
//        pedido.setDtEnvio(dtEnvio);
//        pedido.setDtEntrega(dtEntrega);
        pedido.setStatus(status);
        pedido.setMtdPagamento(mtdPagamento);
        pedido.setSubtotal(subtotal);
        pedido.setTaxaEnvio(taxaEnvio);
        pedido.setCodigoRastreamento(codigoRastremento);
        pedidoRepository.save(pedido);
    }

    @Transactional
    public void excluirPedido(Integer id) {
        pedidoExiste(id);
        pedidoRepository.deleteById(id);
    }

    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validação
    public boolean pedidoExiste(Integer id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum pedido encontrado para o ID fornecido.");
        }
        return true;
    }

    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência
    public boolean pedidoExiste(Optional<Pedido> pedidoOptional) {
        if (pedidoOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum pedido encontrado para o ID fornecido.");
        }
        return true;
    }

    public String gerarCodigoRastreamento(){
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();
    }
}
