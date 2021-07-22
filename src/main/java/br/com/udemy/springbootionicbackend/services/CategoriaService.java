package br.com.udemy.springbootionicbackend.services;

import br.com.udemy.springbootionicbackend.domain.Categoria;
import br.com.udemy.springbootionicbackend.repositories.CategoriaRepository;
import br.com.udemy.springbootionicbackend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Optional<Categoria> buscar(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id
                + ", Tipo: " + Categoria.class.getName())));
    }
}
