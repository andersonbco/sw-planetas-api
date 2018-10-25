
package com.andersonbco.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(
    collection = "planetas")
public class Planeta {

  @Id
  private String id;

  private String nome;

  private String clima;

  private String terreno;

}
