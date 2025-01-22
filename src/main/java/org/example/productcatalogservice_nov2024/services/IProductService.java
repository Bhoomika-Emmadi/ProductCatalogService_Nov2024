package org.example.productcatalogservice_nov2024.services;

import org.example.productcatalogservice_nov2024.dtos.ProductDto;
import org.example.productcatalogservice_nov2024.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    Product getProductById(Long productId);

    Product createProduct(Product product);

    Product replaceProduct(Long productId,Product inputProduct);

    Product getProductBasedOnUserScope(Long productId,Long userId);
}
