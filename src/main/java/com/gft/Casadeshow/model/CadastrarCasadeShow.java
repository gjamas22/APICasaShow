package com.gft.Casadeshow.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "cadastrarCasadeShow")
public class CadastrarCasadeShow{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	private Long id;
	
	@NotEmpty(message="Nome da casa de show é obrigatória!")
	@Size (max=60, message = "O nome da sua casa de show não pode conter mais de 60 caracteres!")
	@JsonInclude(Include.NON_NULL)
	private String nomeCasa;
	
	@NotEmpty(message="Endereço é obrigatório!")
	@JsonInclude(Include.NON_NULL)
	private String endereco;
	
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "casadeShow1")
	private List<Eventos> eventos;
	
	public CadastrarCasadeShow() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCasa() {
		return nomeCasa;
	}
	public void setNomeCasa(String nomeCasa) {
		this.nomeCasa = nomeCasa;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public List<Eventos> getEventos() {
		return eventos;
	}
	public void setEventos(List<Eventos> eventos) {
		this.eventos = eventos;
	}
	

	
	
}
