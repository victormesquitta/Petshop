package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.petshop.dtos.FuncionarioDTO;
import br.senac.tads.petshop.dtos.ProdutoDTO;
import br.senac.tads.petshop.mappers.FuncionarioDTOMapper;
import br.senac.tads.petshop.models.Funcionario;
import br.senac.tads.petshop.models.Produto;
import br.senac.tads.petshop.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioDTOMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioDTOMapper funcionarioMapper){
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    public List<Funcionario> listarFuncionarios(){
        List<Funcionario> funcionario = funcionarioRepository.findAll();
        return funcionario;
    }

    public List<FuncionarioDTO> listarFuncionariosDTOs(){
        List<Funcionario> funcionario = funcionarioRepository.findAll();
        return funcionario.stream()
                    .map(funcionarioMapper::toDTO)
                    .collect(Collectors.toList());        
    }

    public FuncionarioDTO obterFuncionarioDTOPorId(Integer id){
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        return funcionarioOptional.map(funcionarioMapper::toDTO).orElse(null);
    }

    public void criarFuncionario(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = funcionarioMapper.toEntity(funcionarioDTO);

        funcionario.setDtCriacao(LocalDate.now());
        funcionario.setDtModificacao(null);
        funcionarioRepository.save(funcionario);
    }

    public void atualizarFuncionario(Integer id, FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = funcionarioMapper.toEntity(funcionarioDTO, id);
        funcionario.setDtModificacao(LocalDate.now());
        funcionarioRepository.save(funcionario);
    }

    public void excluirFuncionario(Integer id){
        funcionarioRepository.deleteById(id);
    }
}
