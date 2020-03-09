package com.gft.Casadeshow.exceptions;

public class EventosNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8990849687858429262L;

	public EventosNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
	
	public EventosNaoEncontradoException (String mensagem, Throwable causa) {
		super(mensagem , causa);
	}

}

	
