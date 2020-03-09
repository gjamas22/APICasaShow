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

import com.gft.Casadeshow.model.CadastrarCasadeShow;
import com.gft.Casadeshow.services.CasadeshowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Casas")
@RestController
@RequestMapping("/api")
public class CasadeShowResources {

	@Autowired
	private CasadeshowService casadeshowservice;

	@ApiOperation("Listar todas as casas de show.")
	@RequestMapping(value = "/casas" , method = RequestMethod.GET)
	public ResponseEntity<List<CadastrarCasadeShow>> listarcasadeshow() {
		return ResponseEntity.status(HttpStatus.OK).body(casadeshowservice.listar());
		
	}
	@ApiOperation("Inserir casa de show.")
	@RequestMapping(value = "/casas" , method = RequestMethod.POST)
	public ResponseEntity<Void> cadastrarcasadeshow(@ApiParam(name = "corpo", value = "Representação de uma nova casa de show")@RequestBody CadastrarCasadeShow cadastrarcasadeshow) {
		cadastrarcasadeshow = casadeshowservice.salvar(cadastrarcasadeshow);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(cadastrarcasadeshow.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@ApiOperation("Buscar por ID.")
	@RequestMapping(value = "/casas/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@ApiParam(value = "ID de uma casa", example = "1")@PathVariable("id") Long id) {
		Optional<CadastrarCasadeShow> cadastrarCasadeShow = casadeshowservice.buscar(id);

		return ResponseEntity.status(HttpStatus.OK).body(cadastrarCasadeShow);
		
	}
	@ApiOperation("Atualizar casa de show.")
	@RequestMapping(value = "/casas/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@ApiParam(value = "ID da casa a ser atualizada", example = "7")@RequestBody CadastrarCasadeShow cadastrarcasadeshow , @PathVariable("id") Long id) {
		cadastrarcasadeshow.setId(id);
		casadeshowservice.atualizar(cadastrarcasadeshow);
		return ResponseEntity.noContent().build();
	}
	@ApiOperation("Deletar uma casa de show.")
	@RequestMapping(value = "/casas/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@ApiParam(value = "ID da casa a ser deletada", example = "10")@PathVariable("id") Long id) {
		casadeshowservice.deletar(id);
			
		return ResponseEntity.noContent().build();
	}
	@ApiOperation("Lista as casas em ordem alfabética crescente por nome.")
	@RequestMapping(value = "/casas/asc" , method = RequestMethod.GET)
	public ResponseEntity<List<CadastrarCasadeShow>> listarCrescente() {
		return ResponseEntity.status(HttpStatus.OK).body(casadeshowservice.listarCrescente());
	}
	@ApiOperation("Lista as casas em ordem alfabética decrescente por nome.")
	@RequestMapping(value = "/casas/desc" , method = RequestMethod.GET)
	public ResponseEntity<List<CadastrarCasadeShow>> listarDecrescente() {
		return ResponseEntity.status(HttpStatus.OK).body(casadeshowservice.listarDecrescente());
	}
	@ApiOperation("Buscar casa por nome.")
	@RequestMapping(value = "/casas/nome/{nomeCasa}" , method = RequestMethod.GET)
	public ResponseEntity<?> buscarNome(@PathVariable("nomeCasa")String nomeCasa) {
		List<CadastrarCasadeShow> cadastrarCasadeShow = casadeshowservice.buscarnome(nomeCasa);
		
		return ResponseEntity.status(HttpStatus.OK).body(cadastrarCasadeShow);
	}
}
