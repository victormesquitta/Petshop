package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.CarrinhoComprasDTO;
import br.senac.tads.petshop.mappers.CarrinhoComprasDTOMapper;
import br.senac.tads.petshop.models.CarrinhoCompras;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.repositories.CarrinhoComprasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarrinhoComprasService {

    private final CarrinhoComprasRepository carrinhoComprasRepository;
    private final CarrinhoComprasDTOMapper carrinhoComprasDTOMapper;

    private final ClienteService clienteService;

    @Autowired
    public CarrinhoComprasService(CarrinhoComprasRepository carrinhoComprasRepository, CarrinhoComprasDTOMapper carrinhoComprasDTOMapper, ClienteService clienteService) {
        this.carrinhoComprasRepository = carrinhoComprasRepository;
        this.carrinhoComprasDTOMapper = carrinhoComprasDTOMapper;
        this.clienteService = clienteService;
    }

    public List<CarrinhoCompras> listarCarrinhosCompras() {
        return carrinhoComprasRepository.findAll();
    }

    public void carrinhoComprasExiste(Optional<CarrinhoCompras> optionalCarrinhoCompras) {
        if (optionalCarrinhoCompras.isEmpty()) {
            throw new EntityNotFoundException("Nenhum carrinho de compras encontrado para o ID fornecido.");
        }
    }

    public void carrinhoComprasExiste(Integer id) {
        Optional<CarrinhoCompras> carrinhoComprasOptional = carrinhoComprasRepository.findById(id);
        if (carrinhoComprasOptional.isEmpty()) {
            throw new EntityNotFoundException("Nenhum carrinho de compras encontrado para o ID fornecido.");
        }
    }

    public List<CarrinhoComprasDTO> listarCarrinhosComprasDTO() {
        List<CarrinhoCompras> carrinhosCompras = carrinhoComprasRepository.findAll();
        return carrinhosCompras.stream()
                .map(carrinhoComprasDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CarrinhoCompras obterCarrinhoComprasPorId(Integer id) {
        Optional<CarrinhoCompras> carrinhoComprasOptional = carrinhoComprasRepository.findById(id);
        return carrinhoComprasOptional.orElseThrow(() -> new EntityNotFoundException("Nenhum carrinho de compras encontrado para o ID fornecido."));
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

    public void criarCarrinhoCompras(Cliente cliente) {
        CarrinhoCompras carrinhoExistente = obterCarrinhoPorCliente(cliente);
        clienteService.clienteExiste(cliente.getCodCliente());
        if(carrinhoExistente != null){
            throw new RuntimeException("Cliente já possui um carrinho de compras.");
        }

        // atribui valores iniciais zerados para o novo carrinho
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
        carrinhoCompras.setCliente(cliente);
        carrinhoCompras.setSubtotal(0.0);
        carrinhoCompras.setQtdProdutos(0);
        carrinhoComprasRepository.save(carrinhoCompras);
    }

    public void atualizarCarrinhoCompras(Integer id, CarrinhoComprasDTO carrinhoComprasDTO) {
        carrinhoComprasExiste(id);
        CarrinhoCompras carrinhoCompras = carrinhoComprasDTOMapper.toEntity(carrinhoComprasDTO, id);
        carrinhoComprasRepository.save(carrinhoCompras);
    }

    public void excluirCarrinhoCompras(Integer id) {
        carrinhoComprasExiste(id);
        carrinhoComprasRepository.deleteById(id);
    }
}
