package br.com.udemy.springbootionicbackend.repositories;

import br.com.udemy.springbootionicbackend.domain.Pagamento;
import br.com.udemy.springbootionicbackend.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    
}
