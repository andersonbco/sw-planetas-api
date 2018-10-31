package com.andersonbco.api.resource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.andersonbco.api.service.PlanetaService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PlanetaResourceTest {

  @Autowired
  MockMvc mockMvc;
  
  @MockBean
  PlanetaService planetaService;
}
