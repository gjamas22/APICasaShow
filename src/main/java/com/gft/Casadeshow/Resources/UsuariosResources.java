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

import com.gft.Casadeshow.model.Usuarios;
import com.gft.Casadeshow.services.UsuariosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Usuários")
@RestController
@RequestMapping("/api")
public class UsuariosResources {

	@Autowired
	UsuariosService usuariosService;
	
	@ApiOperation("Lista de todos os usuários.")
	@RequestMapping(value = "/users" , method = RequestMethod.GET)
	public ResponseEntity<List<Usuarios>> listarusuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(usuariosService.listar());
	}
	@ApiOperation("Inserir um usuário")
	@RequestMapping(value = "/users" , method = RequestMethod.POST)
	public ResponseEntity<Void> usuarios(@ApiParam(name = "corpo", value = "Representação de um novo usuário")@RequestBody Usuarios usuarios) {
		usuarios = usuariosService.salvar(usuarios);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(usuarios.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@ApiOperation("Listar apenas um usuário pelo ID.")
	@RequestMapping(value = "/users/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@ApiParam(value = "ID do usuário", example = "4")@PathVariable("id") Long id) {
		Optional<Usuarios> usuarios = usuariosService.buscar(id);

		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
		}
}