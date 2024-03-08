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
        if(!clienteOptional.isPresent()){
            throw new EntityNotFoundException("Nenhum usuário encontrado para o ID fornecido.");
        }
    }

    public Cliente obterClientePorId(Integer id){
        System.out.println("teste 1");
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        clienteExiste(clienteOptional);
        return clienteOptional.get();
    }

    public ClienteDTO obterClienteDTOPorId(Integer id){
        System.out.println("teste 2");
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        clienteExiste(clienteOptional);
        return clienteOptional.map(clienteDTOMapper::toDTO).orElse(null);
    }

    public void criarCliente(Cliente cliente){
        validarDadosDuplicados(cliente);
        //sobreescreve a data passada no json
        cliente.setDataCadastro(LocalDate.now());
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(Integer id, Cliente cliente){
        validarDadosDuplicados(cliente);
        clienteExiste(id);
        cliente.setCodCliente(id);
        clienteRepository.save(cliente);

    }

    public void excluirCliente(Integer id){
        clienteExiste(id);
        clienteRepository.deleteById(id);
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

    private void validarDadosDuplicados(Cliente cliente){
        for(Cliente clienteBanco : clienteRepository.findAll()){
            if(clienteBanco.getUsuario().equals(cliente.getUsuario())){
                throw new DataIntegrityViolationException("Usuário já em uso.");
            }
            else if(clienteBanco.getCpf().equals(cliente.getCpf())){
                throw new DataIntegrityViolationException("CPF pertence a uma outra conta.");
            }
            else if(clienteBanco.getEmail().equals(cliente.getEmail())){
                throw new DataIntegrityViolationException("Endereço de e-mail já em uso.");
            }
            else if(clienteBanco.getCelular().equals(cliente.getCelular())){
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

    // validar o que pode e o que não pode ser duplicado

}
