package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.ItemPedidoDTO;
import br.senac.tads.petshop.dtos.PedidoDTO;
import br.senac.tads.petshop.mappers.ItemPedidoDTOMapper;
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

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PedidoDTOMapper pedidoDTOMapper;
    private final ItemPedidoDTOMapper itemPedidoDTOMapper;
    private final ClienteService clienteService;

    @Autowired
    public PedidoService(ClienteService clienteService, PedidoRepository pedidoRepository, PedidoDTOMapper pedidoDTOMapper, ItemPedidoDTOMapper itemPedidoDTOMapper) {
        this.clienteService = clienteService;
        this.pedidoRepository = pedidoRepository;
        this.pedidoDTOMapper = pedidoDTOMapper;
        this.itemPedidoDTOMapper = itemPedidoDTOMapper;
    }

    public Page<Pedido> listarPedidos(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    public Page<PedidoDTO> listarPedidosDTO(Pageable pageable) {
        Page<Pedido> pedidosPage = listarPedidos(pageable);
        List<PedidoDTO> pedidosDTO = pedidosPage.getContent().stream()
                .map(pedido -> {
                    PedidoDTO pedidoDTO = new PedidoDTO();
                    pedidoDTO.setCodPedido(pedido.getCodPedido());
                    pedidoDTO.setCodCliente(pedido.getCliente().getCodCliente());
                    pedidoDTO.setStatus(pedido.getStatus());
                    pedidoDTO.setSubtotal(pedido.getSubtotal());
                    pedidoDTO.setDtPedido(pedido.getDtPedido());
                    pedidoDTO.setDtEnvio(pedido.getDtEnvio());
                    pedidoDTO.setDtEntrega(pedido.getDtEntrega());
                    pedidoDTO.setCodigoRastreamento(pedido.getCodigoRastreamento());
                    pedidoDTO.setMtdPagamento(pedido.getMtdPagamento());
                    pedidoDTO.setTaxaEnvio(pedido.getTaxaEnvio());
                    pedidoDTO.setObservacao(pedido.getObservacao());

                    List<ItemPedidoDTO> itensDTO = pedido.getItensPedido().stream()
                            .map(itemPedidoDTOMapper::toDTO)
                            .collect(Collectors.toList());
                    pedidoDTO.setItensPedido(itensDTO);
                    return pedidoDTO;
                })
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
        pedido.setSubtotal(BigDecimal.ZERO);

        // ver como vai ser esse cálculo
        pedido.setTaxaEnvio(BigDecimal.valueOf(15.0));

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
        // dados do pedido
        LocalDate dtPedido = pedidoExistente.getDtPedido(),
                dtEnvio = pedidoDTO.getDtEnvio(),
                dtEntrega = pedidoDTO.getDtEntrega();
        String status = pedidoDTO.getStatus(),
                mtdPagamento = pedidoExistente.getMtdPagamento(),
                codigoRastremento = pedidoExistente.getCodigoRastreamento(),
                observacao = pedidoExistente.getObservacao();
        BigDecimal subtotal = pedidoDTO.getSubtotal(),
                taxaEnvio = pedidoExistente.getTaxaEnvio();

        LocalDate dtHoje = LocalDate.now();
        if(dtEnvio == null){
            throw new IllegalArgumentException("A data de envio precisa ser inserida.");
        } else if(dtEntrega == null){
            throw new IllegalArgumentException("A data de entrega precisa ser inserida.");
        } else if (taxaEnvio == null) {
            throw new IllegalArgumentException("A taxa de envio precisa ser inserida.");
        }

        if(dtEnvio.isBefore(dtHoje)){
            throw new IllegalArgumentException("A data de envio não pode ser inferior à data atual.");
        } else if(dtEntrega.isBefore(dtHoje)){
            throw new IllegalArgumentException("A data de entrega não pode ser inferior à data atual.");
        }
        Pedido pedido = pedidoDTOMapper.toEntity(pedidoDTO, id);
        pedido.setCliente(pedidoExistente.getCliente());
        pedido.setDtPedido(dtPedido);
        pedido.setDtEnvio(dtEnvio);
        pedido.setDtEntrega(dtEntrega);
        pedido.setStatus(status);
        pedido.setMtdPagamento(mtdPagamento);
        pedido.setSubtotal(subtotal);
        pedido.setTaxaEnvio(taxaEnvio);
        pedido.setCodigoRastreamento(codigoRastremento);
        pedido.setObservacao(observacao);

        pedido.calcularSubtotal();

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
