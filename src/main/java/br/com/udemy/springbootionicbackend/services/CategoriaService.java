package br.com.udemy.springbootionicbackend.services;

import br.com.udemy.springbootionicbackend.domain.Categoria;
import br.com.udemy.springbootionicbackend.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Optional<Categoria> buscar(Integer id){
        return repository.findById(id);
    }
}
