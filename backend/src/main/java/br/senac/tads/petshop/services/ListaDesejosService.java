package br.senac.tads.petshop.services;

import br.senac.tads.petshop.dtos.ListaDesejosDTO;
import br.senac.tads.petshop.mappers.ListaDesejosDTOMapper;
import br.senac.tads.petshop.models.ListaDesejos;
import br.senac.tads.petshop.repositories.ListaDesejosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListaDesejosService {
    private ListaDesejosRepository listaDesejosRepository;
    private ListaDesejosDTOMapper listaDesejosDTOMapper;
    private ClienteService clienteService;
    @Autowired
    public ListaDesejosService(ListaDesejosRepository listaDesejosRepository, ListaDesejosDTOMapper listaDesejosDTOMapper, ClienteService clienteService){
        this.listaDesejosRepository = listaDesejosRepository;
        this.listaDesejosDTOMapper = listaDesejosDTOMapper;
        this.clienteService = clienteService;
    }

    public List<ListaDesejos> listarListaDesejos(){
        List<ListaDesejos> listaDesejos = listaDesejosRepository.findAll();
        return listaDesejos;
    }

    public List<ListaDesejosDTO> listarListaDesejosDTO(){
        List<ListaDesejos> listaDesejos = listaDesejosRepository.findAll();
        return listaDesejos.stream()
                .map(listaDesejosDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void listaDesejosExiste(Optional<ListaDesejos> listaDesejosOptional){
        if(listaDesejosOptional.isEmpty()){
            throw new EntityNotFoundException("Nenhuma Lista de Desejos encontrada para o ID fornecido.");
        }
    }

    public void listaDesejosExiste(Integer id){
        Optional<ListaDesejos> listaDesejosOptional = listaDesejosRepository.findById(id);
        if(listaDesejosOptional.isEmpty()){
            throw new EntityNotFoundException("Nenhuma Lista de Desejos encontrada para o ID fornecido.");
        }
    }

    public ListaDesejos obterListaDesejosPorId(Integer id){
        Optional<ListaDesejos> listaDesejosOptional = listaDesejosRepository.findById(id);
        listaDesejosExiste(listaDesejosOptional);
        return listaDesejosOptional.get();
    }

    public ListaDesejosDTO obterListaDesejosDTOPorId(Integer id){
        Optional<ListaDesejos> listaDesejosOptional = listaDesejosRepository.findById(id);
        listaDesejosExiste(listaDesejosOptional);
        return listaDesejosOptional.map(listaDesejosDTOMapper::toDTO).orElse(null);
    }

    public void criarListaDesejos(ListaDesejosDTO listaDesejosDTO){
        ListaDesejos listaDesejos = listaDesejosDTOMapper.toEntity(listaDesejosDTO);
        listaDesejosRepository.save(listaDesejos);
    }

    public void atualizarListaDesejos(Integer id, ListaDesejosDTO listaDesejosDTO){
        listaDesejosExiste(id);
        ListaDesejos listaDesejos = listaDesejosDTOMapper.toEntity(listaDesejosDTO, id);
        listaDesejosRepository.save(listaDesejos);
    }

    public void excluirListaDesejos(Integer id){
        listaDesejosExiste(id);
        listaDesejosRepository.deleteById(id);
    }
}
