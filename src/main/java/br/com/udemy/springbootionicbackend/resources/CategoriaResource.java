package br.com.udemy.springbootionicbackend.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.udemy.springbootionicbackend.dto.CategoriaDTO;
import br.com.udemy.springbootionicbackend.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.udemy.springbootionicbackend.domain.Categoria;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Categoria>> buscar(@PathVariable Integer id) {
		Optional<Categoria> c = service.buscar(id);
		return ResponseEntity.ok().body(c);
	}

	/*
	 * ResponseEntity<Void> - resposta com o corpo vazio
	 * @RequestBody         - para construir os dados apartir do objeto Json enviado
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO categoria){
		Categoria obj = service.fromDTO(categoria);
		Categoria cat = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cat.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody Categoria categoria){
		categoria.setId(id);
		service.atualizar(categoria);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> atualizar(@PathVariable Integer id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> buscarTodos() {
		List<Categoria> list = service.buscarTodos();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> buscarPagina(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "linhasPorLinha", defaultValue = "24") Integer linhasPorLinha,
			@RequestParam(name = "ordernador", defaultValue = "nome") String ordernador,
			@RequestParam(name = "direcao", defaultValue = "ASC") String direcao) {
		Page<Categoria> list = service.buscarPagina(page, linhasPorLinha, ordernador, direcao);
		Page<CategoriaDTO> listDTO = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}
