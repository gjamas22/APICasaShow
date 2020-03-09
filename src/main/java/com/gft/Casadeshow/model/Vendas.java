package com.gft.Casadeshow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Vendas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	private Long id;
	
	@NotNull(message="Quantidade é obrigatória!")
	@JsonInclude(Include.NON_NULL)
	private int quantidade;
	
	@NotEmpty(message="Usuário é obrigatório!")
	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuarios user;
	
	@NotEmpty(message="Evento é obrigatório!")
	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "eventos_id")
	private Eventos eventos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Usuarios getUser() {
		return user;
	}

	public void setUser(Usuarios user) {
		this.user = user;
	}

	public Eventos getEventos() {
		return eventos;
	}

	public void setEventos(Eventos eventos) {
		this.eventos = eventos;
	}
	
	
}
