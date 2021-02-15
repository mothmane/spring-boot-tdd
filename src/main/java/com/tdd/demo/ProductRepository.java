package com.tdd.demo;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, UUID> {

  public Product findByName(String name);
}
