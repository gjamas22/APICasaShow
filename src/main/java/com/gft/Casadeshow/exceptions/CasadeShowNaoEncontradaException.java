package com.gft.Casadeshow.exceptions;

public class CasadeShowNaoEncontradaException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3523029871723375010L;

	public CasadeShowNaoEncontradaException (String mensagem) {
		super(mensagem);
	}
	
	public CasadeShowNaoEncontradaException (String mensagem, Throwable causa) {
		super(mensagem , causa);
	}
}
