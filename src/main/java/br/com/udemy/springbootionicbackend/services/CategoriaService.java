package br.com.udemy.springbootionicbackend.services;

import br.com.udemy.springbootionicbackend.domain.Categoria;
import br.com.udemy.springbootionicbackend.repositories.CategoriaRepository;
import br.com.udemy.springbootionicbackend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Categoria> buscarTodos(){
       List<Categoria> list = repository.findAll();
       if(!list.isEmpty())
           return list;

       throw new ObjectNotFoundException("Não há categorias");
    }

    public Categoria inserir(Categoria categoria){
        categoria.setId(null);
        return repository.save(categoria);
    }

    public Categoria atualizar(Categoria categoria){
        buscar(categoria.getId());
        return repository.save(categoria);
    }

    public void deletar(Integer id) {
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new ObjectNotFoundException("Não é possível excluir uma categoria que possui produtos");
        }
    }
}
