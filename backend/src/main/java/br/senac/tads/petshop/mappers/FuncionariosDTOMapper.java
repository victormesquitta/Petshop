package br.senac.tads.petshop.mappers;

import br.senac.tads.petshop.dtos.FuncionariosDTO;
import br.senac.tads.petshop.models.Funcionarios;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncionariosDTOMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public FuncionariosDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    // usado para post -> não precisa de id porque ainda não foi criado
    public Funcionarios toEntity(FuncionariosDTO funcionariosDTO) {
        Funcionarios funcionarios = modelMapper.map(funcionariosDTO, Funcionarios.class);
        return funcionarios;
    }

    // usado para put -> o id foi criado e deve ser mantido
    public Funcionarios toEntity(FuncionariosDTO FuncionariosDTO, Integer id) {
        Funcionarios funcionarios = modelMapper.map(FuncionariosDTO, Funcionarios.class);
        funcionarios.setCodFuncionario(id);
        return funcionarios;
    }

    public FuncionariosDTO toDTO(Funcionarios Funcionarios) {
        return modelMapper.map(Funcionarios, FuncionariosDTO.class);
    }

}