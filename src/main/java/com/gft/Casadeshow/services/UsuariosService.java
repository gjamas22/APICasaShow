package com.gft.Casadeshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.Casadeshow.exceptions.UsuariosNaoEncontradoException;
import com.gft.Casadeshow.model.Usuarios;
import com.gft.Casadeshow.repository.UsuariosRepository;


@Service
public class UsuariosService {

	@Autowired
	UsuariosRepository usuariosrepository;

	public List<Usuarios>listar() {
		return usuariosrepository.findAll();
	}
	
	public Optional<Usuarios> buscar(Long id) {
	    Optional<Usuarios> usuarios = usuariosrepository.findById(id);
			
			if(usuarios.isPresent()) {
				return usuarios;
			}
			throw new UsuariosNaoEncontradoException("O usuário não pode ser encontrado!");
			
		}
	public Usuarios salvar(Usuarios usuarios) {
		usuarios.setId(null);
		return usuarios = usuariosrepository.save(usuarios);
		
	}
}
