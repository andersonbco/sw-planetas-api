
package com.andersonbco.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonbco.api.client.PlanetaClient;
import com.andersonbco.api.dto.PlanetaDTO;
import com.andersonbco.api.entity.Planeta;
import com.andersonbco.api.repository.PlanetaRepository;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

@Service
public class PlanetaService {

  @Autowired
  private PlanetaRepository planetaRepository;

  @Autowired
  private PlanetaClient planetasClient;

  public PlanetaDTO buscaPlaneta(String id) {

    return this.convertToPlanetaDTO(planetaRepository.findById(id).get());
  }

  public PlanetaDTO criaPlaneta(Planeta planeta) {
    return this.convertToPlanetaDTO(planetaRepository.save(planeta));
  }

  public List<PlanetaDTO> listaPlanetas() {
    return planetaRepository.findAll().stream().map(this::convertToPlanetaDTO)
        .collect(Collectors.toList());
  }

  private PlanetaDTO convertToPlanetaDTO(Planeta planeta) {
    return PlanetaDTO.builder().id(planeta.getId()).nome(planeta.getNome())
        .clima(planeta.getClima()).terreno(planeta.getTerreno())
        .quantidadeFilmes(this.countAparicoesFilmes(planeta.getNome())).build();
  }

  private int countAparicoesFilmes(String nomePlaneta) {
    String responseJson = planetasClient.buscaQuantidadeAparicoesEmFilmes(nomePlaneta).getBody();
    JSONArray jsonArray = JsonPath.read(responseJson, "$.results[*].films[*]");

    return jsonArray.size();
  }
}
