package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.EnderecoDTO;
import br.senac.tads.petshop.mappers.EnderecoDTOMapper;
import br.senac.tads.petshop.models.Endereco;
import br.senac.tads.petshop.repositories.EnderecoRepository;
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
public class EnderecoService {

    private final ClienteService clienteService;
    private final EnderecoRepository enderecoRepository;
    private final EnderecoDTOMapper enderecoDTOMapper;


    @Autowired
    public EnderecoService(ClienteService clienteService, EnderecoRepository enderecoRepository, EnderecoDTOMapper enderecoDTOMapper) {
        this.clienteService = clienteService;
        this.enderecoRepository = enderecoRepository;
        this.enderecoDTOMapper = enderecoDTOMapper;
    }

    public Page<Endereco> listarEnderecos(Pageable pageable) {
        return enderecoRepository.findAll(pageable);
    }

    public Page<EnderecoDTO> listarEnderecosDTO(Pageable pageable){
        Page<Endereco> enderecosPage = listarEnderecos(pageable);
        List<EnderecoDTO> enderecosDTO = enderecosPage.stream()
                .map(enderecoDTOMapper::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(enderecosDTO, pageable, enderecosPage.getTotalElements());
    }

    public EnderecoDTO obterEnderecoDTOPorId(Integer id){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        enderecoExiste(enderecoOptional);
        return enderecoOptional.map(enderecoDTOMapper::toDTO).orElse(null);
    }

    public Endereco obterEnderecoPorId(Integer id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        enderecoExiste(enderecoOptional);
        return enderecoOptional.get();
    }

    @Transactional
    public void criarEndereco(EnderecoDTO enderecoDTO) {
        // valida se o cliente passado existe
        if(!clienteService.clienteExiste(enderecoDTO.getCodCliente())){
            throw new EntityNotFoundException("Não é possível adicionar um endereço a um cliente que não existe.");
        }
        Endereco endereco = enderecoDTOMapper.toEntity(enderecoDTO);
        enderecoRepository.save(endereco);
    }

    @Transactional
    public void atualizarEndereco(Integer id, EnderecoDTO enderecoDTO) {
        enderecoExiste(id);
        // valida se o cliente passado existe
        if(!clienteService.clienteExiste(enderecoDTO.getCodCliente())){
            throw new EntityNotFoundException("Não é possível adicionar um endereço a um cliente que não existe.");
        }
        Endereco endereco = enderecoDTOMapper.toEntity(enderecoDTO, id);
        enderecoRepository.save(endereco);
    }

    @Transactional
    public void excluirEndereco(Integer id) {
        enderecoExiste(id);
        enderecoRepository.deleteById(id);
    }

    // para métodos update/delete -> a consulta vai ser feita no método, junto com a validaçaõ
    public boolean enderecoExiste(Integer id){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if(enderecoOptional.isEmpty()){
            throw new EntityNotFoundException("Nenhum endereço encontrado para o ID fornecido.");
        }
        return true;
    }

    // para métodos get -> a consulta já foi feita acima e o método vai apenas validar a existência
    public boolean enderecoExiste(Optional<Endereco> enderecoOptional){
        if(enderecoOptional.isEmpty()){
            throw new EntityNotFoundException("Nenhum endereço encontrado para o ID fornecido.");
        }
        return true;

    }
}
