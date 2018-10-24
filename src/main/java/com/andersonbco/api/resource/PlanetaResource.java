
package com.andersonbco.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andersonbco.api.model.Planeta;
import com.andersonbco.api.service.PlanetaService;

@RestController
@RequestMapping("/planetas")
public class PlanetaResource {

  @Autowired
  PlanetaService planetaService;

  @GetMapping("/{id}")
  public ResponseEntity<Planeta> buscaPlanetaPorId(@PathVariable String id) {
    Optional<Planeta> planeta = planetaService.buscaPlaneta(id);
    return ResponseEntity.ok(planeta.get());
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Planeta> criaPlaneta(@RequestBody Planeta planeta) {
    Planeta novoPlaneta = planetaService.criaPlaneta(planeta);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(novoPlaneta.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @GetMapping(
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Planeta>> listaPlanetas() {
    return ResponseEntity.ok(planetaService.listaPlanetas());
  }
}