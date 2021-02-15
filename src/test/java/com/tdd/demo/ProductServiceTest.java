package com.tdd.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

  @Mock ProductRepository productRepository;

  @InjectMocks ProductService productService;

  @Test
  void should_return_a_product_by_name(){
    // given:
    var name="TV";
    var product =new Product(UUID.randomUUID(),name,500.00);
    given(productRepository.findByName(name)).willReturn(product);

    // when:
    var actual =productService.findByName(name);

    //then:
    assertThat(actual).isEqualTo(product);

  }

}
