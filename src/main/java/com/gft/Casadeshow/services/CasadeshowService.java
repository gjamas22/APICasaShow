package com.gft.Casadeshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gft.Casadeshow.exceptions.CasadeShowNaoEncontradaException;
import com.gft.Casadeshow.model.CadastrarCasadeShow;
import com.gft.Casadeshow.repository.CadastrarCasadeShowRepository;

@Service
public class CasadeshowService {

	@Autowired
	private CadastrarCasadeShowRepository cadastrarCasadeShowRepository;

	
	public List<CadastrarCasadeShow>listar() {
		return cadastrarCasadeShowRepository.findAll();
	}

	public Optional<CadastrarCasadeShow> buscar(Long id) {
    Optional<CadastrarCasadeShow> cadastrarCasadeShow = cadastrarCasadeShowRepository.findById(id);
		
		if(cadastrarCasadeShow.isPresent()) {
			return cadastrarCasadeShow;
		}
		throw new CasadeShowNaoEncontradaException("A casa de show não pode ser encontrada!");
		
	}
	
	public CadastrarCasadeShow salvar(CadastrarCasadeShow cadastrarcasadeshow) {
		cadastrarcasadeshow.setId(null);
		return cadastrarcasadeshow = cadastrarCasadeShowRepository.save(cadastrarcasadeshow);
		
	}
	
	
	public void atualizar(CadastrarCasadeShow cadastrarcasadeshow) {
		verificarExistencia(cadastrarcasadeshow);
		cadastrarCasadeShowRepository.save(cadastrarcasadeshow);
	}
	
	private void verificarExistencia(CadastrarCasadeShow cadastrarcasadeshow) {
		buscar(cadastrarcasadeshow.getId());
	}
	
	public void deletar(Long id) {
		try {
			cadastrarCasadeShowRepository.deleteById(id);
		} catch (CasadeShowNaoEncontradaException e){
			throw new CasadeShowNaoEncontradaException("A casa de show não pode ser encontrada!");
		}
	}
	public List<CadastrarCasadeShow> listarCrescente() {
		return cadastrarCasadeShowRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeCasa"));
	}
	public List<CadastrarCasadeShow> listarDecrescente() {
		return cadastrarCasadeShowRepository.findAll(Sort.by(Sort.Direction.DESC, "nomeCasa"));
	}
	public List<CadastrarCasadeShow> buscarnome(String nomeCasa) {
		List<CadastrarCasadeShow> cadastrarCasadeShow = cadastrarCasadeShowRepository.findByNomeCasa(nomeCasa);
		
		if(cadastrarCasadeShow == null) {
			throw new CasadeShowNaoEncontradaException("A casa de show não pode ser encontrada!");
		}
		return cadastrarCasadeShow;
	
	}
}
