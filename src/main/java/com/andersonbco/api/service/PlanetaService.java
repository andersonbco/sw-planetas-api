package com.andersonbco.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonbco.api.model.Planeta;
import com.andersonbco.api.repository.PlanetaRepository;

@Service
public class PlanetaService {

  @Autowired
  private PlanetaRepository planetaRepository;
  
  public Optional<Planeta> buscaPlaneta(String id) {
    return planetaRepository.findById(id);
  }
  
  public Planeta criaPlaneta(Planeta planeta) {
   return planetaRepository.save(planeta); 
  }
  
  public List<Planeta> listaPlanetas() {
    return planetaRepository.findAll();
  }
}
