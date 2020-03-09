package com.gft.Casadeshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.Casadeshow.model.CadastrarCasadeShow;

public interface CadastrarCasadeShowRepository extends JpaRepository<CadastrarCasadeShow, Long> {

	public List<CadastrarCasadeShow> findByNomeCasa(String nomeCasa); 
}
