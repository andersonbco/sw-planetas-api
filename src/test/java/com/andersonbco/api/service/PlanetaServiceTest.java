
package com.andersonbco.api.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.andersonbco.api.dto.PlanetaDTO;
import com.andersonbco.api.entity.Planeta;
import com.andersonbco.api.repository.PlanetaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlanetaServiceTest {

  @Autowired
  MockMvc mvc;

  @MockBean
  PlanetaRepository planetaRepository;

  @Autowired
  PlanetaService planetaService;

  Planeta planeta;

  PlanetaDTO planetaDTO;

  String id;
  String nome;
  String clima;
  String terreno;

  String responseJson;

  Optional<Planeta> optPlaneta;

  @Before
  public void setUp() {

    id = "id";
    nome = "nome";
    clima = "clima";
    terreno = "terreno";

    planeta = new Planeta();
    planeta.setId(id);
    planeta.setNome(nome);
    planeta.setClima(clima);
    planeta.setTerreno(terreno);

    planetaDTO = PlanetaDTO.builder().id(id).nome(nome).clima(clima).terreno(terreno)
        .quantidadeFilmes(5).build();

    optPlaneta = Optional.ofNullable(planeta);

  }

  @Test
  public void buscaPlanetaPorNomeTest() throws Exception {
    Mockito.when(planetaRepository.findByNomeContainingIgnoreCase(planetaDTO.getNome()))
        .thenReturn(optPlaneta);

    PlanetaDTO planetaFound = planetaService.buscaPlanetaPorNome(nome);

    assertEquals(planetaFound.getNome(), nome);
    assertEquals(planetaFound.getClima(), clima);
    assertEquals(planetaFound.getTerreno(), terreno);
  }

  @Test
  public void buscaPlanetaPorIdTest() throws Exception {
    Mockito.when(planetaRepository.findById(planetaDTO.getId())).thenReturn(optPlaneta);

    PlanetaDTO planetaFound = planetaService.buscaPlaneta(id);

    assertEquals(planetaFound.getNome(), nome);
    assertEquals(planetaFound.getClima(), clima);
    assertEquals(planetaFound.getTerreno(), terreno);
  }

  @Test
  public void criaPlanetaTest() throws Exception {
    Mockito.when(planetaRepository.save(planeta)).thenReturn(planeta);

    PlanetaDTO planetaCreated = planetaService.criaPlaneta(planeta);

    assertEquals(planetaCreated.getNome(), nome);
    assertEquals(planetaCreated.getClima(), clima);
    assertEquals(planetaCreated.getTerreno(), terreno);
  }
  
}
