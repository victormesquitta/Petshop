package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.CarrinhoComprasDTO;
import br.senac.tads.petshop.dtos.ItemCarrinhoDTO;
import br.senac.tads.petshop.mappers.CarrinhoComprasDTOMapper;
import br.senac.tads.petshop.mappers.ItemCarrinhoDTOMapper;
import br.senac.tads.petshop.models.CarrinhoCompras;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.repositories.CarrinhoComprasRepository;
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
public class CarrinhoComprasService {

    private final CarrinhoComprasRepository carrinhoComprasRepository;
    private final CarrinhoComprasDTOMapper carrinhoComprasDTOMapper;
    private final ItemCarrinhoDTOMapper itemCarrinhoDTOMapper;
    private final ClienteService clienteService;

    @Autowired
    public CarrinhoComprasService(CarrinhoComprasRepository carrinhoComprasRepository, CarrinhoComprasDTOMapper carrinhoComprasDTOMapper, ItemCarrinhoDTOMapper itemCarrinhoDTOMapper, ClienteService clienteService) {
        this.carrinhoComprasRepository = carrinhoComprasRepository;
        this.carrinhoComprasDTOMapper = carrinhoComprasDTOMapper;
        this.itemCarrinhoDTOMapper = itemCarrinhoDTOMapper;
        this.clienteService = clienteService;
    }

    public Page<CarrinhoCompras> listarCarrinhosCompras(Pageable pageable) {
        return carrinhoComprasRepository.findAll(pageable);
    }

    public Page<CarrinhoComprasDTO> listarCarrinhosComprasDTO(Pageable pageable) {
        Page<CarrinhoCompras> carrinhosCompraPage = listarCarrinhosCompras(pageable);
        List<CarrinhoComprasDTO> carrinhosCompraDTO = carrinhosCompraPage.getContent().stream()
                .map(carrinho -> {
                    CarrinhoComprasDTO carrinhoDTO = new CarrinhoComprasDTO();
                    // Mapear os campos diretos do carrinho
                    carrinhoDTO.setCodCarrinho(carrinho.getCodCarrinho());
                    carrinhoDTO.setCodCliente(carrinho.getCliente().getCodCliente());
                    carrinhoDTO.setQtdProdutos(carrinho.getQtdProdutos());
                    carrinhoDTO.setSubtotal(carrinho.getSubtotal());

                    // Mapear os itens do carrinho
                    List<ItemCarrinhoDTO> itensDTO = carrinho.getItensCarrinho().stream()
                            .map(itemCarrinhoDTOMapper::toDTO)
                            .collect(Collectors.toList());
                    carrinhoDTO.setItensCarrinho(itensDTO);

                    return carrinhoDTO;
                })
                .collect(Collectors.toList());
        return new PageImpl<>(carrinhosCompraDTO, pageable, carrinhosCompraPage.getTotalElements());
    }

    public CarrinhoCompras obterCarrinhoComprasPorId(Integer id) {
        Optional<CarrinhoCompras> carrinhoComprasOptional = carrinhoComprasRepository.findById(id);
        carrinhoComprasExiste(carrinhoComprasOptional);
        return carrinhoComprasOptional.get();
    }

    public CarrinhoComprasDTO obterCarrinhoComprasDTOPorId(Integer id) {
        Optional<CarrinhoCompras> carrinhoComprasOptional = carrinhoComprasRepository.findById(id);
        carrinhoComprasExiste(carrinhoComprasOptional);
        return carrinhoComprasOptional.map(carrinhoComprasDTOMapper::toDTO).orElse(null);
    }

    // identifica se o cliente já possui um carrinho de compras
    // evita duplicidade de carrinhos
    public CarrinhoCompras obterCarrinhoPorCliente(Cliente cliente) {
        Optional<CarrinhoCompras> carrinhoOptional = carrinhoComprasRepository.findByCliente(cliente);
        return carrinhoOptional.orElse(null);
    }

    @Transactional
    public void criarCarrinhoComprasComCliente(Cliente cliente) {

        clienteService.clienteExiste(cliente.getCodCliente());
        CarrinhoCompras carrinhoExistente = obterCarrinhoPorCliente(cliente);
        if(carrinhoExistente != null){
            throw new RuntimeException("Cliente já possui um carrinho de compras.");
        }

        // atribui valores iniciais zerados para o novo carrinho
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
        carrinhoCompras.setCliente(cliente);
        carrinhoCompras.calcularSubtotal();
        carrinhoCompras.setQtdProdutos(0);
        carrinhoComprasRepository.save(carrinhoCompras);
    }


    @Transactional
    public void atualizarCarrinhoCompras(Integer id, CarrinhoComprasDTO carrinhoComprasDTO) {

        // valida a existência do carrinho
        CarrinhoCompras carrinhoExistente = obterCarrinhoComprasPorId(id);

        CarrinhoCompras carrinhoCompras = carrinhoComprasDTOMapper.toEntity(carrinhoComprasDTO, id);
        carrinhoCompras.calcularSubtotal();
        carrinhoComprasRepository.save(carrinhoCompras);
    }

    @Transactional
    public void excluirCarrinhoCompras(Integer id) {
        carrinhoComprasExiste(id);
        carrinhoComprasRepository.deleteById(id);
//        CarrinhoCompras carrinhoCompras = obterCarrinhoComprasPorId(id);
//        carrinhoComprasRepository.delete(carrinhoCompras);
    }

    @Transactional
    public Cliente limparCarrinho(Integer id) {

        CarrinhoCompras carrinhoCompras = obterCarrinhoComprasPorId(id);
        Cliente cliente = carrinhoCompras.getCliente();
        excluirCarrinhoCompras(id);
        return cliente;




//        // valida a existência do carrinho de compras
//        CarrinhoCompras carrinhoCompras = obterCarrinhoComprasPorId(id);
//        List<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findByCarrinhoComprasCodCarrinho(id);
//        System.out.println("Itens retornados: " + itensCarrinho.toString());
//        itemCarrinhoRepository.deleteAll(itensCarrinho);
////        carrinhoCompras.prePersistOrUpdate();
//        carrinhoComprasRepository.save(carrinhoCompras);
//        // Atualizar o carrinho após limpar os itens (se necessário)

    }

    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validação
    public boolean carrinhoComprasExiste(Integer id) {
        Optional<CarrinhoCompras> carrinhoComprasOptional = carrinhoComprasRepository.findById(id);
        if(carrinhoComprasOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum carrinho de compras encontrado para o ID fornecido.");
        }
        return true;
    }

    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência

    public boolean carrinhoComprasExiste(Optional<CarrinhoCompras> optionalCarrinhoCompras) {
        if(optionalCarrinhoCompras.isEmpty()) {
            throw new EntityNotFoundException("Nenhum carrinho de compras encontrado para o ID fornecido.");
        }
        return true;
    }


}
