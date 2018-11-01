
package com.andersonbco.api.util;

public enum MessagesEnum {

  PLANETA_NAO_ENCONTRADO(1, "Planeta não encontrado!"),
  PLANETA_NAO_ENCONTRADO_BASE_SWAPI(2,
      "Não foi encontrado nenhum filme com este nome na base do SWAPI");

  MessagesEnum(Integer code, String description) {
    this.code = code;
    this.description = description;
  }

  private Integer code;

  private String description;

  public Integer getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }
}
