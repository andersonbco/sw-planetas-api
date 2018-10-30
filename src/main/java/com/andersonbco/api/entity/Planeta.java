
package com.andersonbco.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
@Document(
    collection = "planetas")
public class Planeta {

  @Id
  @ApiModelProperty(
      position = 0,
      value = "id",
      hidden = true)
  private String id;

  @ApiModelProperty(
      position = 1,
      value = "nome")
  private String nome;

  @ApiModelProperty(
      position = 2,
      value = "clima")
  private String clima;

  @ApiModelProperty(
      position = 3,
      value = "terreno")
  private String terreno;

}
