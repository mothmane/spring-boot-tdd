package com.tdd.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ProductController.class)
public class productControllerTest {

  @MockBean ProductService productService;

  @Autowired
  MockMvc mockMvc;


  @Test
  void should_return_a_product() throws Exception {

    UUID id=UUID.randomUUID();
    given(productService.findByName(anyString()))
        .willReturn(new Product(id,"TV",500.00));

    mockMvc.perform(get("/products?name=TV"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(id.toString())))
        .andExpect(jsonPath("$.name", is("TV")))
        .andExpect(jsonPath("$.price", is(500.00)));

  }

}
