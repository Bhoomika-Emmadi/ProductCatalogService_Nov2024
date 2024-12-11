package org.example.productcatalogservice_nov2024.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice_nov2024.models.Category;
import org.example.productcatalogservice_nov2024.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;


    @Test
    @Transactional
    void testFetchTypes() {
        Category category = categoryRepo.findById(100L).get();
        System.out.println(category.getName());
        for(Product p : category.getProducts()) {
            System.out.println(p.getName());
        }
    }
}