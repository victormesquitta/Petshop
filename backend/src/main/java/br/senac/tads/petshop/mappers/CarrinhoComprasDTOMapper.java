package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.CarrinhoComprasDTO;
import br.senac.tads.petshop.models.CarrinhoCompras;
import br.senac.tads.petshop.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrinhoComprasDTOMapper {

    private final ModelMapper modelMapper;
    private final ClienteService clienteService;

    @Autowired
    public CarrinhoComprasDTOMapper(ModelMapper modelMapper, ClienteService clienteService) {
        this.modelMapper = modelMapper;
        this.clienteService = clienteService;
    }

    // usado para post -> não precisa de id porque ainda não foi criado
    public CarrinhoCompras toEntity(CarrinhoComprasDTO carrinhoDTO) {
        CarrinhoCompras carrinho = modelMapper.map(carrinhoDTO, CarrinhoCompras.class);
        carrinho.setCliente(clienteService.obterClientePorId(carrinhoDTO.getCodCliente()));
        return carrinho;
    }

    // usado para put -> o id foi criado e deve ser mantido
    public CarrinhoCompras toEntity(CarrinhoComprasDTO carrinhoDTO, Integer id) {
        CarrinhoCompras carrinho = modelMapper.map(carrinhoDTO, CarrinhoCompras.class);
        carrinho.setCliente(clienteService.obterClientePorId(carrinhoDTO.getCodCliente()));
        carrinho.setCodCarrinho(id);
        return carrinho;
    }

    public CarrinhoComprasDTO toDTO(CarrinhoCompras carrinho) {
        return modelMapper.map(carrinho, CarrinhoComprasDTO.class);
    }


}
