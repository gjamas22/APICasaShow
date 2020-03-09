package com.gft.Casadeshow.exceptions;

public class UsuariosNaoEncontradoException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3936182669590951964L;

	public UsuariosNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
	
	public UsuariosNaoEncontradoException (String mensagem, Throwable causa) {
		super(mensagem , causa);
	}
}
