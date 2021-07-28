package br.com.udemy.springbootionicbackend.repositories;

import br.com.udemy.springbootionicbackend.domain.Categoria;
import br.com.udemy.springbootionicbackend.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
    
}
