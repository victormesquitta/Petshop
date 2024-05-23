package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.senac.tads.petshop.dtos.FuncionarioDTO;
import br.senac.tads.petshop.mappers.FuncionarioDTOMapper;
import br.senac.tads.petshop.models.Funcionario;
import br.senac.tads.petshop.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.petshop.models.Funcionarios;

@Service
public class FuncionariosService {
    
    @Autowired
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    private final FuncionarioDTOMapper funcionarioDTOMapper;

    public FuncionariosService(FuncionarioRepository funcionarioRepository, FuncionarioDTOMapper funcionarioDTOMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioDTOMapper = funcionarioDTOMapper;
    }


    public List<Funcionario> listarFuncionarioss(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios;
    }

    public List<FuncionarioDTO> listarFuncionariossDTOs(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream()
                    .map(funcionarioDTOMapper::toDTO)
                    .collect(Collectors.toList());        
    }

    public void criarFuncionario(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = funcionarioDTOMapper.toEntity(funcionarioDTO);

        funcionario.setDtCriacao(LocalDate.now());
        funcionario.setDtModificacao(null);
        funcionarioRepository.save(funcionario);
    }

    public void atualizarFuncionario(Integer id, FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = funcionarioDTOMapper.toEntity(funcionarioDTO, id);
        funcionario.setDtModificacao(LocalDate.now());
        funcionarioRepository.save(funcionario);
    }

    public void excluirFuncionario(Integer id, FuncionarioDTO funcionarioDTO){
        funcionarioRepository.deleteById(id);
    }
}
