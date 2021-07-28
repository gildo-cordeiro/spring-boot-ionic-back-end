package br.com.udemy.springbootionicbackend.repositories;

import br.com.udemy.springbootionicbackend.domain.Pedido;
import br.com.udemy.springbootionicbackend.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
}
