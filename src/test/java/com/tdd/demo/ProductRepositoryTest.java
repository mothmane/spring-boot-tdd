package com.tdd.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class ProductRepositoryTest {

  @Autowired
  TestEntityManager tem;

  @Autowired
  ProductRepository productRepository;

  @Test
  void shoud_return_product_by_name() {
    // given:
    var product =new Product(UUID.randomUUID(),"TV", 500.00);
    tem.persist(product);

    // when:
    var expected = productRepository.findByName("TV");

    // then:
    assertThat(product).isEqualTo(expected);
  }

}
