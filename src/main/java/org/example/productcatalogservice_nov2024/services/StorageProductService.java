package org.example.productcatalogservice_nov2024.services;

import org.example.productcatalogservice_nov2024.models.Product;
import org.example.productcatalogservice_nov2024.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service("sps")
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long productId) {
        System.out.println("Reading from db !!");
       Optional<Product> productOptional  = productRepo.findById(productId);
       if(productOptional.isPresent()) {
           return productOptional.get();
       }

       return  null;
    }

    @Override
    public Product createProduct(Product product) {
        System.out.println("storing into db !!");
        return productRepo.save(product);
    }

    @Override
    public Product replaceProduct(Long productId, Product inputProduct) {
        return null;
    }
}
