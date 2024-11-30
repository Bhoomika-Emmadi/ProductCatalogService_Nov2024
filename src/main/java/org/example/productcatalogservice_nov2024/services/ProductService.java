package org.example.productcatalogservice_nov2024.services;

import org.example.productcatalogservice_nov2024.dtos.FakeStoreProductDto;
import org.example.productcatalogservice_nov2024.dtos.ProductDto;
import org.example.productcatalogservice_nov2024.models.Category;
import org.example.productcatalogservice_nov2024.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public List<ProductDto> getProducts() {return null;}

    @Override
    public Product getProductById(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("http://fakestoreapi.com/products/{productId}", FakeStoreProductDto.class,productId);
        if(fakeStoreProductDtoResponseEntity.getBody() == null ||
                fakeStoreProductDtoResponseEntity.getStatusCode().equals(HttpStatusCode.valueOf(500))) {
            return null;
        }
        return from(fakeStoreProductDtoResponseEntity.getBody());
    }

    //https://fakestoreapi.com/products/1/{}/{}/{}

    @Override
    public Product createProduct(Product product) {
       return null;
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
