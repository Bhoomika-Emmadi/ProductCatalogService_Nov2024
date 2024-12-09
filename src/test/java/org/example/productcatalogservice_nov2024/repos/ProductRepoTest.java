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
    @Transactional
    public void testJpaMethods() {
      String s = productRepo.findCategoryNameByProductId(25L);
        System.out.println(s);
      //System.out.println(productList.size());
    }

}