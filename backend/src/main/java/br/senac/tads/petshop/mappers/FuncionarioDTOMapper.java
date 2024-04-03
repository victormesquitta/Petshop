package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.FuncionarioDTO;
import br.senac.tads.petshop.models.Funcionario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioDTOMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public FuncionarioDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    // usado para post -> não precisa de id porque ainda não foi criado
    public Funcionario toEntity(FuncionarioDTO funcionariosDTO) {
        Funcionario funcionarios = modelMapper.map(funcionariosDTO, Funcionario.class);
        return funcionarios;
    }

    // usado para put -> o id foi criado e deve ser mantido
    public Funcionario toEntity(FuncionarioDTO FuncionariosDTO, Integer id) {
        Funcionario funcionarios = modelMapper.map(FuncionariosDTO, Funcionario.class);
        funcionarios.setCodFuncionario(id);
        return funcionarios;
    }

    public FuncionarioDTO toDTO(Funcionario Funcionarios) {
        return modelMapper.map(Funcionarios, FuncionarioDTO.class);
    }

}