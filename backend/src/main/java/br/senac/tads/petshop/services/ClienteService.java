package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.ClienteDTO;
import br.senac.tads.petshop.mappers.ClienteDTOMapper;
import br.senac.tads.petshop.models.Cliente;
import br.senac.tads.petshop.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;
    private final ClienteDTOMapper clienteDTOMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteDTOMapper clienteDTOMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteDTOMapper = clienteDTOMapper;
    }

    public List<Cliente> listarClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public List<ClienteDTO> listarClientesDTO(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    // utilizado nos métodos de get
    public void clienteExiste(Optional<Cliente> clienteOptional){
        if(!clienteOptional.isPresent()){
            throw new EntityNotFoundException("Nenhum usuário encontrado para o ID fornecido.");
        }
    }

    // utilizado nos métodos de post/put/delete
    public void clienteExiste(Integer id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isEmpty()){
            throw new EntityNotFoundException("Nenhum usuário encontrado para o ID fornecido.");
        }
    }

    public Cliente obterClientePorId(Integer id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        clienteExiste(clienteOptional);
        return clienteOptional.get();
    }

    public ClienteDTO obterClienteDTOPorId(Integer id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        clienteExiste(clienteOptional);
        return clienteOptional.map(clienteDTOMapper::toDTO).orElse(null);
    }

    public Cliente obterClientePorCPF(String cpf){
        try {
            Cliente cliente = clienteRepository.findByCpf(cpf);
            if (cliente == null) {
                throw new RuntimeException("Cliente não encontrado para o CPF fornecido: " + cpf);
            }
            return cliente;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente por CPF: " + e.getMessage(), e);
        }
    }

    public ClienteDTO obterClienteDTOPorCPF(String cpf){
        try {
            Cliente cliente = clienteRepository.findByCpf(cpf);
            if (cliente == null) {
                throw new RuntimeException("Cliente não encontrado para o CPF fornecido: " + cpf);
            }
            ClienteDTO clienteDTO = clienteDTOMapper.toDTO(cliente);
            return clienteDTO;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente por CPF: " + e.getMessage(), e);
        }
    }

    public void criarCliente(ClienteDTO clienteDTO){
        validarDadosDuplicados(clienteDTO);
        Cliente cliente = clienteDTOMapper.toEntity(clienteDTO);
        // sobreescreve a data passada no json
        clienteDTO.setDtCadastro(LocalDate.now());
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(Integer id, ClienteDTO clienteDTO){
        validarDadosDuplicados(clienteDTO, id);
        clienteExiste(id);
        Cliente cliente = clienteDTOMapper.toEntity(clienteDTO, id);
        // não atualiza a senha junto, apenas o resto das outras infos
        clienteDTO.setSenha(clienteDTO.getSenha());
        clienteRepository.save(cliente);
    }

    public void excluirCliente(Integer id){
        clienteExiste(id);
        clienteRepository.deleteById(id);
    }

    public void trocarSenha(Integer id, ClienteDTO clienteDTO){
        Cliente cliente = obterClientePorId(id);

        // valida se a senha é igual a anterior
        if(clienteDTO.getSenha().equals(cliente.getSenha())){
            throw new RuntimeException("A senha não pode ser igual a anterior.");
        }

        cliente.setSenha(cliente.getSenha());
        clienteRepository.save(cliente);
    }

    public void alterarStatus(Integer id, ClienteDTO clienteDTO){
        Cliente cliente = obterClientePorId(id);

        // depois fazer validação com security

        cliente.setStatus(clienteDTO.getStatus());
        clienteRepository.save(cliente);
    }

    public boolean cpfJaCadastrado(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }

    public boolean emailJaCadastrado(String email) {
        return clienteRepository.existsByEmail(email);
    }

    public boolean celularJaCadastrado(String celular) {
        return clienteRepository.existsByCelular(celular);
    }

    public boolean usuarioJaCadastrado(String usuario) {
        return clienteRepository.existsByUsuario(usuario);
    }

    private void validarDadosDuplicados(ClienteDTO clienteDTO){
        for(Cliente clienteBanco : clienteRepository.findAll()){
            if(clienteBanco.getUsuario().equals(clienteDTO.getUsuario())){
                throw new DataIntegrityViolationException("Usuário já em uso.");
            }
            else if(clienteBanco.getCpf().equals(clienteDTO.getCpf())){
                throw new DataIntegrityViolationException("CPF pertence a uma outra conta.");
            }
            else if(clienteBanco.getEmail().equals(clienteDTO.getEmail())){
                throw new DataIntegrityViolationException("Endereço de e-mail já em uso.");
            }
            else if(clienteBanco.getCelular().equals(clienteDTO.getCelular())){
                throw new DataIntegrityViolationException("Celular já foi cadastrado em outra conta.");
            }
        }
    }

    private void validarDadosDuplicados(ClienteDTO clienteDTO, Integer id) {
        for(Cliente cliente : clienteRepository.findAll()){
            if(!(id.equals(cliente.getCodCliente()))){
                if(cliente.getUsuario().equals(clienteDTO.getUsuario())){
                    throw new DataIntegrityViolationException("Usuário já em uso.");
                }
                else if(cliente.getCpf().equals(clienteDTO.getCpf())){
                    throw new DataIntegrityViolationException("CPF pertence a uma outra conta.");
                }
                else if(cliente.getEmail().equals(clienteDTO.getEmail())){
                    throw new DataIntegrityViolationException("Endereço de e-mail já em uso.");
                }
                else if(cliente.getCelular().equals(clienteDTO.getCelular())){
                    throw new DataIntegrityViolationException("Celular já foi cadastrado em outra conta.");
                }
            }
        }
    }
}
