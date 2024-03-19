package br.senac.tads.petshop.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.petshop.dtos.FuncionariosDTO;
import br.senac.tads.petshop.mappers.FuncionariosDTOMapper;
import br.senac.tads.petshop.models.Funcionarios;
import br.senac.tads.petshop.repositories.FuncionariosRepository;

@Service
public class FuncionariosService {
    
    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    private FuncionariosDTOMapper funcionariosMapper;

    public FuncionariosService(FuncionariosRepository funcionariosRepository, FuncionariosDTOMapper funcionariosMapper){
        this.funcionariosRepository = funcionariosRepository;
        this.funcionariosMapper = funcionariosMapper;
    }

    public List<Funcionarios> listarFuncionarioss(){
        List<Funcionarios> funcionarios = funcionariosRepository.findAll();
        return funcionarios;
    }

    public List<FuncionariosDTO> listarFuncionariossDTOs(){
        List<Funcionarios> funcionarios = funcionariosRepository.findAll();
        return funcionarios.stream()
                    .map(funcionariosMapper::toDTO)
                    .collect(Collectors.toList());        
    }

    public void criarFuncionarios(FuncionariosDTO funcionariosDTO){
        Funcionarios funcionarios = funcionariosMapper.toEntity(funcionariosDTO);

        funcionarios.setDtCriacao(LocalDate.now());
        funcionarios.setDtModificacao(null);
        funcionariosRepository.save(funcionarios);
    }

    public void atualizarFuncionarios(Integer id, FuncionariosDTO funcionariosDTO){
        Funcionarios funcionarios = funcionariosMapper.toEntity(funcionariosDTO, id);
        funcionarios.setDtModificacao(LocalDate.now());
        funcionariosRepository.save(funcionarios);
    }

    public void excluirFuncionarios(Integer id, FuncionariosDTO funcionariosDTO){
        funcionariosRepository.deleteById(id);
    }
}
