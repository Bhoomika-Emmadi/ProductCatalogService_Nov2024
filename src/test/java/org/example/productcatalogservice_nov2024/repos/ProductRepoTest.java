package org.example.productcatalogservice_nov2024.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice_nov2024.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    public void addTestProductsInAwsDb() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Iphone");
        product.setPrice(150000D);
        productRepo.save(product);

        Product product1 = new Product();
        product1.setPrice(200000D);
        product1.setId(10L);
        product1.setName("MacBook");
        productRepo.save(product1);
    }


    //@Test
    //@Transactional
    public void testJpaMethods() {
      String s = productRepo.findCategoryNameByProductId(25L);
        System.out.println(s);
      //System.out.println(productList.size());
    }

}