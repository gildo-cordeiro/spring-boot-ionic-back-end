package br.com.udemy.springbootionicbackend.repositories;

import br.com.udemy.springbootionicbackend.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}
