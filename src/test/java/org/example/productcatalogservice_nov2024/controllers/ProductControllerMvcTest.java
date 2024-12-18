package org.example.productcatalogservice_nov2024.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogservice_nov2024.dtos.ProductDto;
import org.example.productcatalogservice_nov2024.models.Product;
import org.example.productcatalogservice_nov2024.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void TestGetAllProducts_RunsSuccessfully() throws Exception {
      mockMvc.perform(get("/products")).andExpect(status().isOk());
    }

    @Test
    public void TestGetAllProducts_ReceivesProductList() throws Exception {
        //Arrange
        Product product1 = new Product();
        product1.setName("Iphone12");
        product1.setId(1L);
        product1.setDescription("lalallla");
        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("MacBook");
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        when(productService.getProducts()).thenReturn(products);

         // Because underlying JSON structure of product and productDto is same, thats why below test passed with
        //products(List<Product>) also
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper
                        .writeValueAsString(products)))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].length()").value(3))
                .andExpect(jsonPath("$[1].name").value("MacBook"));
    }

    @Test
    public void TestCreateProductApi_RunsSuccessfully() throws Exception {
        //Arrange
        Product product = new Product();
        product.setId(1L);
        product.setName("Anurag");

        ProductDto productdto = new ProductDto();
        productdto.setId(1L);
        productdto.setName("Anurag");

        when(productService.createProduct(any(Product.class)))
                .thenReturn(product);

        //Act and Assert
        mockMvc.perform(post("/products")
                        .content(objectMapper.writeValueAsString(productdto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(productdto)))
                .andExpect(jsonPath("$.id").value(product.getId()))
                .andExpect(jsonPath("$.length()").value(2));


    }
}

//{
//    "id" : 1,"name" : "Anurag"
//}