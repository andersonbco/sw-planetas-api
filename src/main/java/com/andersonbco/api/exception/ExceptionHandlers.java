
package com.andersonbco.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.andersonbco.api.util.MessagesEnum;

@ControllerAdvice
public class ExceptionHandlers {

  @ExceptionHandler(PlanetaNaoEncontradoException.class)
  public ResponseEntity<ErrorMessage> handlePlanetaNaoEncontradoException(
      PlanetaNaoEncontradoException e, HttpServletRequest request) {

    ErrorMessage msg = new ErrorMessage();
    msg.setMessage(MessagesEnum.PLANETA_NAO_ENCONTRADO.getDescription());

    return ResponseEntity.ok(msg);
  }

  @ExceptionHandler(QuantidadeFilmesInexistenteException.class)
  public ResponseEntity<ErrorMessage> handleQuantidadeFilmesInexistenteException(
      QuantidadeFilmesInexistenteException e, HttpServletRequest request) {
    ErrorMessage msg = new ErrorMessage();
    msg.setMessage(MessagesEnum.PLANETA_NAO_ENCONTRADO_BASE_SWAPI.getDescription());

    return ResponseEntity.badRequest().body(msg);
  }
}
