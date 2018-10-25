package com.andersonbco.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class SwapiProperties {

  @Value("${swapi.base.url}")
  private String swapiBaseUrl;
  
  @Value("${swapi.resource}")
  private String swapiResource;
  
  @Value("${swapi.search.query}")
  private String swapiSearchQuery;
}
