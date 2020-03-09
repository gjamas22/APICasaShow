package com.gft.Casadeshow.Resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gft.Casadeshow.model.Vendas;
import com.gft.Casadeshow.services.VendasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Vendas")
@RestController
@RequestMapping("/api")
public class VendasResources {

	@Autowired
	private VendasService vendasservice;
	
	@ApiOperation("Lista de todas as vendas.")
	@RequestMapping(value = "/vendas" , method = RequestMethod.GET)
	public ResponseEntity<List<Vendas>> listarvendas() {
		return ResponseEntity.status(HttpStatus.OK).body(vendasservice.listar());
	}
	
	@ApiOperation("Listar apenas uma venda pelo ID.")
	@RequestMapping(value = "/vendas/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@ApiParam(value = "ID da venda", example = "2")@PathVariable("id") Long id) {
		Optional<Vendas> vendas = vendasservice.buscar(id);

		return ResponseEntity.status(HttpStatus.OK).body(vendas);
		
	}
}
