
package com.andersonbco.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel
public class PlanetaDTO {

  @ApiModelProperty(
      position = 0,
      value = "id")
  @JsonProperty("id")
  private String id;

  @ApiModelProperty(
      position = 1,
      value = "nome")
  @JsonProperty("nome")
  private String nome;

  @ApiModelProperty(
      position = 2,
      value = "clima")
  @JsonProperty("clima")
  private String clima;

  @ApiModelProperty(
      position = 3,
      value = "terreno")
  @JsonProperty("terreno")
  private String terreno;

  @ApiModelProperty(
      position = 4,
      value = "Quantidade de aparicões em filmes")
  @JsonProperty("quantidade_filmes")
  private int quantidadeFilmes;
}
