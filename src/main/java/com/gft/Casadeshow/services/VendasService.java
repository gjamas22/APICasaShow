package com.gft.Casadeshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.Casadeshow.exceptions.VendaNaoEncontradaException;
import com.gft.Casadeshow.model.Vendas;
import com.gft.Casadeshow.repository.VendasRepository;

@Service
public class VendasService {

	@Autowired
	VendasRepository vendasrepository;
	
	public List<Vendas>listar() {
		return vendasrepository.findAll();
	}
	
	public Optional<Vendas> buscar(Long id) {
	    Optional<Vendas> vendas = vendasrepository.findById(id);
			
			if(vendas.isPresent()) {
				return vendas;
			}
			throw new VendaNaoEncontradaException("A venda não pode ser encontrada!");
			
		}
}
