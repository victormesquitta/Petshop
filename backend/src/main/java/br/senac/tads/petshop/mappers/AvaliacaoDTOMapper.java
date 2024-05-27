package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.AvaliacaoDTO;
import br.senac.tads.petshop.models.Avaliacao;
import br.senac.tads.petshop.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoDTOMapper {

    private final ModelMapper modelMapper;
    private final ProdutoService produtoService;

    @Autowired
    public AvaliacaoDTOMapper(ModelMapper modelMapper, ProdutoService produtoService) {
        this.modelMapper = modelMapper;
        this.produtoService = produtoService;
    }

    public Avaliacao toEntity(AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacao = modelMapper.map(avaliacaoDTO, Avaliacao.class);
        avaliacao.setProduto(produtoService.obterProdutoPorId(avaliacaoDTO.getCodProduto()));
        return avaliacao;
    }

    public Avaliacao toEntity(AvaliacaoDTO avaliacaoDTO, Integer id) {
        Avaliacao avaliacao = modelMapper.map(avaliacaoDTO, Avaliacao.class);
        avaliacao.setCodAvaliacao(id);
        return avaliacao;
    }

    public AvaliacaoDTO toDTO(Avaliacao avaliacao) {
        AvaliacaoDTO avaliacaoDTO = modelMapper.map(avaliacao, AvaliacaoDTO.class);
        avaliacaoDTO.setCodProduto(avaliacao.getProduto().getCodProduto());
        return avaliacaoDTO;
    }
}
