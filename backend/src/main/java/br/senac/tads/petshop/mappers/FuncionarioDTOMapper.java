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
    public Funcionario toEntity(FuncionarioDTO funcionarioDTO) {
        return modelMapper.map(funcionarioDTO, Funcionario.class);
    }

    // usado para put -> o id foi criado e deve ser mantido
    public Funcionario toEntity(FuncionarioDTO funcionarioDTO, Integer id) {
        Funcionario funcionario = modelMapper.map(funcionarioDTO, Funcionario.class);
        funcionario.setCodFuncionario(id);
        return funcionario;
    }

    public FuncionarioDTO toDTO(Funcionario funcionario) {
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

}