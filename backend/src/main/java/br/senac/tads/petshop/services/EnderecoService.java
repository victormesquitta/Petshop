package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.EnderecoDTO;
import br.senac.tads.petshop.mappers.EnderecoDTOMapper;
import br.senac.tads.petshop.models.Endereco;
import br.senac.tads.petshop.repositories.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    private EnderecoDTOMapper enderecoDTOMapper;

    public EnderecoService(EnderecoRepository enderecoRepository, EnderecoDTOMapper enderecoDTOMapper) {
        this.enderecoRepository = enderecoRepository;
        this.enderecoDTOMapper = enderecoDTOMapper;
    }

    public List<Endereco> listarEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos;
    }

    public List<EnderecoDTO> listarEnderecosDTO(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream()
                .map(enderecoDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void enderecoExiste(Optional<Endereco> enderecoOptional){
        if(!enderecoOptional.isPresent()){
            throw new EntityNotFoundException("Nenhum endereço encontrado para o ID fornecido.");
        }
    }

    public void enderecoExiste(Integer id){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if(!enderecoOptional.isPresent()){
            throw new EntityNotFoundException("Nenhum endereço encontrado para o ID fornecido.");
        }
    }

    public Endereco obterEnderecoPorId(Integer id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        enderecoExiste(enderecoOptional);
        return enderecoOptional.get();
    }

    public EnderecoDTO obterEnderecoDTOPorId(Integer id){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        enderecoExiste(enderecoOptional);
        return enderecoOptional.map(enderecoDTOMapper::toDTO).orElse(null);
    }

    public void criarEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public void atualizarEndereco(Integer id, Endereco endereco) {
        Endereco endereco1 = obterEnderecoPorId(id);
        endereco.setCodEndereco(id);
        enderecoRepository.save(endereco);
    }

    public void excluirEndereco(Integer id) {
        enderecoExiste(id);
        enderecoRepository.deleteById(id);
    }
}
