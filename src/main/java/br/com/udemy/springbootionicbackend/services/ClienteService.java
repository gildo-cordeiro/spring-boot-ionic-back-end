package br.com.udemy.springbootionicbackend.services;

import br.com.udemy.springbootionicbackend.domain.Cliente;
import br.com.udemy.springbootionicbackend.dto.ClienteDTO;
import br.com.udemy.springbootionicbackend.repositories.ClienteRepository;
import br.com.udemy.springbootionicbackend.services.exceptions.ObjectDataIntegrityViolationException;
import br.com.udemy.springbootionicbackend.services.exceptions.ObjectNotFoundException;
import br.com.udemy.springbootionicbackend.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private Optional<Cliente> objDB;

    public Optional<Cliente> buscar(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id
                + ", Tipo: " + Cliente.class.getName())));
    }

    public Cliente inserir(Cliente cliente){
        cliente.setId(null);
        return repository.save(cliente);
    }

    public Cliente atualizar(Cliente obj){
        objDB = buscar(obj.getId());
        updateData(objDB, obj);
        return repository.save(objDB.get());
    }

    public void deletar(Integer id) {
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new ObjectDataIntegrityViolationException("Não é possível excluir porque há entidades relacionadas");
        }
    }

    public List<Cliente> buscarTodos(){
        List<Cliente> list = repository.findAll();
        if(!list.isEmpty())
            return list;

        throw new ObjectNotFoundException("Não há clientes");
    }

    public Page<Cliente> buscarPagina(Integer page, Integer linhasPorLinha, String ordernador, String direcao){
        PageRequest pageRequest = PageRequest.of(page, linhasPorLinha, Sort.Direction.valueOf(direcao), ordernador);
        return repository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO clienteDTO){
        return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
    }

    private void updateData(Optional<Cliente> objDB, Cliente obj){
        objDB.get().setNome(!ValidatorUtil.isEmpty(obj.getNome()) ? obj.getNome() : objDB.get().getNome());
        objDB.get().setEmail(!ValidatorUtil.isEmpty(obj.getEmail()) ? obj.getEmail() : objDB.get().getEmail());
    }
}
