package com.gft.Casadeshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gft.Casadeshow.exceptions.EventosNaoEncontradoException;
import com.gft.Casadeshow.model.Eventos;
import com.gft.Casadeshow.repository.EventosRepository;

@Service
public class EventosService {

	@Autowired
	EventosRepository eventosrepository;
	
	public List<Eventos>listar() {
		return eventosrepository.findAll();
	}
	
	public Optional<Eventos> buscar(Long id) {
	    Optional<Eventos> eventos = eventosrepository.findById(id);
			
			if(eventos.isPresent()) {
				return eventos;
			}
			throw new EventosNaoEncontradoException("O evento não pode ser encontrado!");
			
		}
	public Eventos salvar(Eventos eventos) {
		eventos.setId(null);
		return eventos = eventosrepository.save(eventos);
		
	}
	public void deletar(Long id) {
		try {
			eventosrepository.deleteById(id);
			} catch (EventosNaoEncontradoException e){
			throw new EventosNaoEncontradoException("O evento não pode ser encontrado!");
		}
	}
	public void atualizar(Eventos eventos) {
		verificarExistencia(eventos);
		eventosrepository.save(eventos);
	}
	private void verificarExistencia(Eventos eventos) {
		buscar(eventos.getId());
	}
	public List<Eventos> listarCapacidade() {
		return eventosrepository.findAll(Sort.by(Sort.Direction.ASC, "capacidade"));
	}
	public List<Eventos> listarCapacidadeDesc() {
		return eventosrepository.findAll(Sort.by(Sort.Direction.DESC, "capacidade"));
	}
	
	public List<Eventos> listarData() {
		return eventosrepository.findAll(Sort.by(Sort.Direction.ASC, "dataEvento"));
	}
	public List<Eventos> listarDataDesc() {
		return eventosrepository.findAll(Sort.by(Sort.Direction.DESC, "dataEvento"));
	}
	public List<Eventos> listarNomeEvento() {
		return eventosrepository.findAll(Sort.by(Sort.Direction.ASC, "nomeEvento"));
	}
	public List<Eventos> listarNomeEventoDesc() {
		return eventosrepository.findAll(Sort.by(Sort.Direction.DESC, "nomeEvento"));
	}
	public List<Eventos> listarpreco() {
		return eventosrepository.findAll(Sort.by(Sort.Direction.ASC, "valor"));
	}
	public List<Eventos> listarprecoDesc() {
		return eventosrepository.findAll(Sort.by(Sort.Direction.DESC, "valor"));
	}
}
