package com.tdd.demo;

public class ProductService {

  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product findByName(String name) {
    return productRepository.findByName(name);
  }
}
