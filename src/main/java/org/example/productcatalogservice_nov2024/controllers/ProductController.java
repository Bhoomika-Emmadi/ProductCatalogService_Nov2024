package org.example.productcatalogservice_nov2024.controllers;

import org.example.productcatalogservice_nov2024.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return null;
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable("id") Long productId) {
      ProductDto productDto = new ProductDto();
      productDto.setId(productId);
      productDto.setName("Iphone");
      return productDto;
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }
}
