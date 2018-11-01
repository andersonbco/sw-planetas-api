
package com.andersonbco.api.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.andersonbco.api.dto.PlanetaDTO;
import com.andersonbco.api.service.PlanetaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PlanetaResourceTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  PlanetaService planetaService;

  PlanetaDTO planetaDTO;

  String id;
  String nome;
  String clima;
  String terreno;

  int qtdeFilmes;

  String responseJson;

  @Before
  public void setUp() throws JsonProcessingException {
    id = "id";
    nome = "nome";
    clima = "clima";
    terreno = "terreno";
    qtdeFilmes = 5;

    planetaDTO = PlanetaDTO.builder().id(id).nome(nome).clima(clima).terreno(terreno)
        .quantidadeFilmes(qtdeFilmes).build();

    responseJson = new ObjectMapper().writeValueAsString(planetaDTO);
  }

  @Test
  public void buscaPlanetaPorIdTest() throws Exception {
    Mockito.when(planetaService.buscaPlaneta(id)).thenReturn(planetaDTO);

    mockMvc.perform(get("/planetas/{id}", id)).andExpect(status().isOk())
        .andExpect(content().json(responseJson)).andReturn();
  }
  
  @Test
  public void buscaPlanetaPorNomeTest() throws Exception {
    Mockito.when(planetaService.buscaPlanetaPorNome(nome)).thenReturn(planetaDTO);

    mockMvc.perform(get("/planetas/nome/{nome}", nome)).andExpect(status().isOk())
        .andExpect(content().json(responseJson)).andReturn();
  }
}
