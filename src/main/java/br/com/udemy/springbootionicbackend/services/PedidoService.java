package br.com.udemy.springbootionicbackend.services;

import br.com.udemy.springbootionicbackend.domain.Categoria;
import br.com.udemy.springbootionicbackend.domain.Cliente;
import br.com.udemy.springbootionicbackend.domain.Pedido;
import br.com.udemy.springbootionicbackend.repositories.ClienteRepository;
import br.com.udemy.springbootionicbackend.repositories.PedidoRepository;
import br.com.udemy.springbootionicbackend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public Optional<Pedido> buscar(Integer id){
        Optional<Pedido> obj = repository.findById(id);
        return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id
                + ", Tipo: " + Categoria.class.getName())));
    }
}
