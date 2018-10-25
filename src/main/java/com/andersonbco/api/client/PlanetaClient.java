
package com.andersonbco.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.andersonbco.api.util.SwapiProperties;

@Component
public class PlanetaClient {

  @Autowired
  SwapiProperties swapiProperties;

  public ResponseEntity<String> buscaQuantidadeAparicoesEmFilmes(String nomePlaneta) {
    RestTemplate restTemplate = new RestTemplate();

    String url = String.format("%s%s%s%s", swapiProperties.getSwapiBaseUrl(),
        swapiProperties.getSwapiResource(), swapiProperties.getSwapiSearchQuery(), nomePlaneta);

    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    headers.add(HttpHeaders.USER_AGENT,
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

    HttpEntity<String> request = new HttpEntity<>(headers);

    return restTemplate.exchange(url, HttpMethod.GET, request, String.class);
  }
}
