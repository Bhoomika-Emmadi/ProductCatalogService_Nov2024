package org.example.productcatalogservice_nov2024.services;

import org.example.productcatalogservice_nov2024.dtos.UserDto;
import org.example.productcatalogservice_nov2024.models.Product;
import org.example.productcatalogservice_nov2024.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service("sps")
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

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

    @Override
    public Product getProductBasedOnUserScope(Long productId, Long userId) {
       Optional<Product> optionalProduct = productRepo.findById(productId);
       if(optionalProduct.isEmpty()) return null;

        //RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate
                .getForEntity("http://userservice/users/{userId}", UserDto.class,userId).getBody();

        if(userDto != null) {
            System.out.println(userDto.getEmail());
            return optionalProduct.get();
        }

        return null;
    }
}
