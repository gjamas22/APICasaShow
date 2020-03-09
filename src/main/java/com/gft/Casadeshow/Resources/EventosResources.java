package com.gft.Casadeshow.Resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft.Casadeshow.model.Eventos;
import com.gft.Casadeshow.services.EventosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Eventos")
@RestController
@RequestMapping("/api")
public class EventosResources {

	@Autowired
	private EventosService eventosservice;
	
	@ApiOperation("Listar todos os eventos.")
	@RequestMapping(value = "/eventos" , method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listareventos() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosservice.listar());
	}
	@ApiOperation("Inserir um evento.")
	@RequestMapping(value = "/eventos" , method = RequestMethod.POST)
	public ResponseEntity<Void> eventos(@ApiParam(name = "corpo", value = "Representação de um novo evento")@RequestBody Eventos eventos) {
		eventos = eventosservice.salvar(eventos);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(eventos.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@ApiOperation("Buscar por ID.")
	@RequestMapping(value = "/eventos/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@ApiParam(value = "ID do evento", example = "1")@PathVariable("id") Long id) {
		Optional<Eventos> eventos = eventosservice.buscar(id);

		return ResponseEntity.status(HttpStatus.OK).body(eventos);
		
	}
	@ApiOperation("Atualizar evento.")
	@RequestMapping(value = "/eventos/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@ApiParam(value = "ID do evento a ser atualizado", example = "10")@RequestBody Eventos eventos, @PathVariable("id") Long id) {
		eventos.setId(id);
		eventosservice.atualizar(eventos);
		return ResponseEntity.noContent().build();
	}
	@ApiOperation("Deleta um evento.")
	@RequestMapping(value = "/eventos/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@ApiParam(value = "ID do evento a ser deletado", example = "8")@PathVariable("id") Long id) {
		eventosservice.deletar(id);
			
		return ResponseEntity.noContent().build();
	}
	@ApiOperation("Lista de eventos em ordem crescente pela capacidade.")
	@RequestMapping(value = "/eventos/capacidade/asc" , method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarCapacidade() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosservice.listarCapacidade());
	}
	@ApiOperation("Lista de eventos em ordem decrescente pela capacidade.")
	@RequestMapping(value = "/eventos/capacidade/desc" , method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarCapacidadeDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosservice.listarCapacidadeDesc());
	}
	@ApiOperation("Lista de eventos em ordem crescente pela data.")
	@RequestMapping(value = "/eventos/data/asc" , method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarData() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosservice.listarData());
	}
	@ApiOperation("Lista de eventos em ordem decrescente pela data.")
	@RequestMapping(value = "/eventos/data/desc" , method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarDataDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosservice.listarDataDesc());
	}
	@ApiOperation("Lista de eventos em ordem alfabética crescente pelo nome.")
	@RequestMapping(value = "/eventos/nome/asc" , method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarNome() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosservice.listarNomeEvento());
	}
	@ApiOperation("Lista de eventos em ordem alfabética decrescente pelo nome.")
	@RequestMapping(value = "/eventos/nome/desc" , method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarNomeDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosservice.listarNomeEventoDesc());
	}
	@ApiOperation("Lista de eventos em ordem crescente pelo preço.")
	@RequestMapping(value = "/eventos/preco/asc" , method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarPreco() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosservice.listarpreco());
	}
	@ApiOperation("Lista de eventos em ordem decrescente pelo preço.")
	@RequestMapping(value = "/eventos/preco/desc" , method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarPrecoDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosservice.listarprecoDesc());
	}
}
