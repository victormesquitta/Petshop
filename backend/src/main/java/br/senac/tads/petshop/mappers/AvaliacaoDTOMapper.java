package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.AvaliacaoDTO;
import br.senac.tads.petshop.models.Avaliacao;
import br.senac.tads.petshop.models.Produto;
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

    // usado para post -> não precisa de id porque ainda não foi criado
    public Avaliacao toEntity(AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacao = modelMapper.map(avaliacaoDTO, Avaliacao.class);
        avaliacao.setProduto(produtoService.obterProdutoPorId(avaliacaoDTO.getCodProduto()));
        return avaliacao;
    }

    // usado para put -> o id foi criado e deve ser mantido
    // a avaliação não pode ser transferida pra outro produto
    public Avaliacao toEntity(AvaliacaoDTO avaliacaoDTO, Integer id, Produto produto) {
        Avaliacao avaliacao = modelMapper.map(avaliacaoDTO, Avaliacao.class);
        avaliacao.setCodAvaliacao(id);
        avaliacao.setProduto(produto);
        return avaliacao;
    }

    public AvaliacaoDTO toDTO(Avaliacao avaliacao) {
        AvaliacaoDTO avaliacaoDTO = modelMapper.map(avaliacao, AvaliacaoDTO.class);
        avaliacaoDTO.setCodProduto(avaliacao.getProduto().getCodProduto());
        return avaliacaoDTO;
    }
}
