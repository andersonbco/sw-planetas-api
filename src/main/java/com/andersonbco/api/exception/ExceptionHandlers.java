
package com.andersonbco.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

  @ExceptionHandler(PlanetaNaoEncontradoException.class)
  public ResponseEntity<ErrorMessage> handlePlanetaNaoEncontradoException(
      PlanetaNaoEncontradoException e, HttpServletRequest request) {

    ErrorMessage msg = new ErrorMessage();
    msg.setMessage("Planeta não encontrado");

    return ResponseEntity.ok(msg);
  }

  @ExceptionHandler(QuantidadeFilmesInexistenteException.class)
  public ResponseEntity<ErrorMessage> handleQuantidadeFilmesInexistenteException(
      QuantidadeFilmesInexistenteException e, HttpServletRequest request) {
    ErrorMessage msg = new ErrorMessage();
    msg.setMessage("Não foi encontrado nenhum filme com este nome na base do SWAPI");
    
    return ResponseEntity.badRequest().body(msg);
  }
}
