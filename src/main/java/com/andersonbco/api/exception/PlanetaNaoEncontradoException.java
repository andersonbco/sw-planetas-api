
package com.andersonbco.api.exception;

public class PlanetaNaoEncontradoException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public PlanetaNaoEncontradoException(String message) {
    super(message);
  }
  
  public PlanetaNaoEncontradoException(String message, Throwable cause) {
    super(message, cause);
  }
}
