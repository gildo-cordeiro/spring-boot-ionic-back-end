package br.com.udemy.springbootionicbackend;

import br.com.udemy.springbootionicbackend.domain.Categoria;
import br.com.udemy.springbootionicbackend.domain.Produto;
import br.com.udemy.springbootionicbackend.repositories.CategoriaRepository;
import br.com.udemy.springbootionicbackend.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootIonicBackEndApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIonicBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse 80", 80.00);

		cat1.getProdutos().addAll(List.of(p1, p2));
		cat2.getProdutos().add(p3);

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(List.of(cat1, cat2));
		p3.getCategorias().add(cat1);

		categoriaRepository.saveAll(List.of(cat1, cat2));
		produtoRepository.saveAll(List.of(p1, p2, p3));
	}
}
