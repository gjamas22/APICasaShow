package com.gft.Casadeshow.exceptions;

public class VendaNaoEncontradaException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2595410163313347732L;

	public VendaNaoEncontradaException (String mensagem) {
		super(mensagem);
	}
	
	public VendaNaoEncontradaException (String mensagem, Throwable causa) {
		super(mensagem , causa);
	}
}
