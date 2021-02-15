package com.tdd.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  void contextLoads() {
  }


  @Test
  void should_return_status_200() {
    final ResponseEntity<Product> productResponseEntity = testRestTemplate
        .getForEntity("/products?name=Mouse", Product.class);

    productResponseEntity.getStatusCode().is2xxSuccessful();

    assertThat(productResponseEntity.getBody().getName()).isEqualTo("Mouse");


  }


}
