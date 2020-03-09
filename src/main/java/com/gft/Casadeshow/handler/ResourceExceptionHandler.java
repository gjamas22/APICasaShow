package com.gft.Casadeshow.handler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gft.Casadeshow.exceptions.CasadeShowNaoEncontradaException;
import com.gft.Casadeshow.exceptions.EventosNaoEncontradoException;
import com.gft.Casadeshow.exceptions.UsuariosNaoEncontradoException;
import com.gft.Casadeshow.exceptions.VendaNaoEncontradaException;
import com.gft.Casadeshow.model.DetalhesError;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(CasadeShowNaoEncontradaException.class)
	public ResponseEntity<DetalhesError> handlerCasadeShowNaoEncontradaException
			(CasadeShowNaoEncontradaException e, HttpServletRequest request){
	
		DetalhesError erro = new DetalhesError();
		erro.setStatus(404l);
		erro.setCasa("A casa de show não pôde ser encontrada!");
		erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return 	ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(EventosNaoEncontradoException.class)
	public ResponseEntity<DetalhesError> handlerCasadeShowNaoEncontradaException
			(EventosNaoEncontradoException e, HttpServletRequest request){
	
		DetalhesError erro = new DetalhesError();
		erro.setStatus(404l);
		erro.setCasa("O evento não pôde ser encontrado!");
		erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return 	ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}	
		@ExceptionHandler(UsuariosNaoEncontradoException.class)
		public ResponseEntity<DetalhesError> handlerCasadeShowNaoEncontradaException
				(UsuariosNaoEncontradoException e, HttpServletRequest request){
		
			DetalhesError erro = new DetalhesError();
			erro.setStatus(404l);
			erro.setCasa("O usuário não pôde ser encontrado!");
			erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/404");
			erro.setTimestamp(System.currentTimeMillis());
			
			return 	ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesError> handlerCasadeShowNaoEncontradaException
			(DataIntegrityViolationException e, HttpServletRequest request){
	
		DetalhesError erro = new DetalhesError();
		erro.setStatus(400l);
		erro.setCasa("Requisição inválida!");
		erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return 	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	@ExceptionHandler(VendaNaoEncontradaException.class)
	public ResponseEntity<DetalhesError> handlerCasadeShowNaoEncontradaException
			(VendaNaoEncontradaException e, HttpServletRequest request){
	
		DetalhesError erro = new DetalhesError();
		erro.setStatus(404l);
		erro.setCasa("Venda não pode ser encontrada!");
		erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return 	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetalhesError> handleMethodArgumentNotValidException
	(MethodArgumentNotValidException e, HttpServletRequest request){
	
		DetalhesError erro = new DetalhesError();
		erro.setStatus(400l);
		erro.setCasa("Os dados devem ser todos fornecidos.");
		erro.setMensagemDesenvolvedor("http://erros.casashow.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<DetalhesError> handleHttpMessageNotReadableException
	(HttpMessageNotReadableException e, HttpServletRequest request){
	
		DetalhesError erro = new DetalhesError();
		erro.setStatus(400l);
		erro.setCasa("Caracteres não esperados na requisição.");
		erro.setMensagemDesenvolvedor("http://erros.casashow.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<DetalhesError> handleHttpMessageNotReadableException
	(ConstraintViolationException e, HttpServletRequest request){
	
		DetalhesError erro = new DetalhesError();
		erro.setStatus(400l);
		erro.setCasa("Insira todos os dados!.");
		erro.setMensagemDesenvolvedor("http://erros.casashow.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<DetalhesError> handleHttpMessageNotReadableException
	(EmptyResultDataAccessException e, HttpServletRequest request){
	
		DetalhesError erro = new DetalhesError();
		erro.setStatus(400l);
		erro.setCasa("Requisição inválida,ID não existente!.");
		erro.setMensagemDesenvolvedor("http://erros.casashow.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
