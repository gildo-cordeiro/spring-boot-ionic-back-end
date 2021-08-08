package br.com.udemy.springbootionicbackend.resources;

import br.com.udemy.springbootionicbackend.domain.Cliente;
import br.com.udemy.springbootionicbackend.domain.Cliente;
import br.com.udemy.springbootionicbackend.domain.Cliente;
import br.com.udemy.springbootionicbackend.dto.ClienteDTO;
import br.com.udemy.springbootionicbackend.dto.ClienteDTO;
import br.com.udemy.springbootionicbackend.services.ClienteService;
import br.com.udemy.springbootionicbackend.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Optional<Cliente> c = service.buscar(id);
		return ResponseEntity.ok().body(c);
	}

	/*
	 * ResponseEntity<Void> - resposta com o corpo vazio
	 * @RequestBody         - para construir os dados apartir do objeto Json enviado
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteDTO cliente){
		Cliente obj = service.fromDTO(cliente);
		Cliente cat = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cat.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente){
		cliente.setId(id);
		service.atualizar(cliente);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> buscarTodos() {
		List<Cliente> list = service.buscarTodos();
		List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> buscarPagina(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "linhasPorLinha", defaultValue = "24") Integer linhasPorLinha,
			@RequestParam(name = "ordernador", defaultValue = "nome") String ordernador,
			@RequestParam(name = "direcao", defaultValue = "ASC") String direcao) {
		Page<Cliente> list = service.buscarPagina(page, linhasPorLinha, ordernador, direcao);
		Page<ClienteDTO> listDTO = list.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
}
