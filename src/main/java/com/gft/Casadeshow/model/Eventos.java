package com.gft.Casadeshow.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Eventos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Nome do evento é obrigatório!")
	@Size(max = 60,message = "O nome do evento não pode conter mais de 60 caracteres")
	private String nomeEvento;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Capacidade é obrigatória!")
	private Integer capacidade;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Data do evento é obrigatória!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataEvento;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Valor é obrigatório!")
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "9999999999.99", message = "Valor não pode ser maior que 9.999.999.999.99")
	@NumberFormat(pattern = "#,##0.00")
	private Double valor;
	
	@ManyToOne
	@NotNull(message = "Casa de Show é obrigatória!,")
	private CadastrarCasadeShow casadeShow1;
	
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private StatusGenero status;
	
	@JsonIgnore
	private String nomeImagem;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "eventos")
	@JsonIgnore
	private List<Vendas> vendas;
	
	public Eventos() {
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public CadastrarCasadeShow getCasadeShow1() {
		return casadeShow1;
	}

	public void setCasadeShow1(CadastrarCasadeShow casadeShow) {
		this.casadeShow1 = casadeShow;
	}
	public StatusGenero getStatus() {
		return status;
	}
	
	public void setStatus(StatusGenero status) {
		this.status = status;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	





	
	
	
}
