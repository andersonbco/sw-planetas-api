
package com.andersonbco.api.exception;

public class QuantidadeFilmesInexistenteException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public QuantidadeFilmesInexistenteException(String message) {
    super(message);
  }

  public QuantidadeFilmesInexistenteException(String message, Throwable cause) {
    super(message, cause);
  }
}
