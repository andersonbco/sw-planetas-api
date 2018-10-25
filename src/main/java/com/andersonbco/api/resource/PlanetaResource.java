
package com.andersonbco.api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andersonbco.api.dto.PlanetaDTO;
import com.andersonbco.api.entity.Planeta;
import com.andersonbco.api.service.PlanetaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/planetas")
public class PlanetaResource {

  @Autowired
  PlanetaService planetaService;

  @ApiOperation(
      value = "Busca um planeta através do ID",
      httpMethod = "GET",
      response = Planeta.class)
  @GetMapping("/{id}")
  public ResponseEntity<PlanetaDTO> buscaPlanetaPorId(@PathVariable String id) {
    PlanetaDTO planetaDTO = planetaService.buscaPlaneta(id);
    return ResponseEntity.ok(planetaDTO);
  }

  @ApiOperation(
      value = "Cadastra um planeta",
      httpMethod = "POST",
      response = Planeta.class)
  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PlanetaDTO> criaPlaneta(@RequestBody Planeta planeta) {
    PlanetaDTO novoPlaneta = planetaService.criaPlaneta(planeta);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(novoPlaneta.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @ApiOperation(
      value = "Lista todos os planetas",
      httpMethod = "GET",
      response = Planeta.class,
      responseContainer = "List")
  @GetMapping(
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PlanetaDTO>> listaPlanetas() {
    return ResponseEntity.ok(planetaService.listaPlanetas());
  }
}
