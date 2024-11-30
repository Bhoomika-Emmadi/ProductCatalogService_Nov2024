package org.example.productcatalogservice_nov2024.controllers;

import org.example.productcatalogservice_nov2024.dtos.CategoryDto;
import org.example.productcatalogservice_nov2024.dtos.ProductDto;
import org.example.productcatalogservice_nov2024.models.Product;
import org.example.productcatalogservice_nov2024.services.IProductService;
import org.example.productcatalogservice_nov2024.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return null;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
        try {
            if(productId <= 0) {
                throw new IllegalArgumentException("productId is invalid");
            }
            Product product = productService.getProductById(productId);
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

            if (product == null) {
                headers.add("message", "product not exist");
                return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            ProductDto productDto = from(product);

            return new ResponseEntity<>(productDto, HttpStatus.OK);
        }catch (IllegalArgumentException exception) {
             return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    private ProductDto from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }
}
