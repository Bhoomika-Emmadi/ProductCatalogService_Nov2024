package org.example.productcatalogservice_nov2024.controllers;

import org.example.productcatalogservice_nov2024.dtos.ProductDto;
import org.example.productcatalogservice_nov2024.models.Product;
import org.example.productcatalogservice_nov2024.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private IProductService productService;

    @Test
    public void TestGetProductById_WithValidId_RunsSuccessfully() {
        //arrange
        Long productId = 2L;
        Product product = new Product();
        product.setId(productId);
        product.setName("Iphone");
        when(productService.getProductById(productId))
                .thenReturn(product);

        //act
        ResponseEntity<ProductDto> productDtoResponseEntity =
                productController.getProductById(productId);

        //assert
        assertNotNull(productDtoResponseEntity);
        assertNotNull(productDtoResponseEntity.getBody());
        assertEquals(productId,productDtoResponseEntity.getBody().getId());
        assertEquals("Iphone",productDtoResponseEntity.getBody().getName());
        verify(productService,times(1))
                .getProductById(productId);
    }

    @Test
    public void TestGetProductById_WithZeroId_ThrowsIllegalArgumentException() {

        //act and assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> productController.getProductById(0L));

        assertEquals("product with id 0 not accessible",exception.getMessage());
    }

    @Test
    //Considering a scenario where exception is getting thrown from downstream
    public void TestGetProductById_WhenProductServiceThrowsException_ThrowsSameException() {
        //arrange
        when(productService.getProductById(any(Long.class)))
                .thenThrow(new RuntimeException("something went bad !!"));

        //act and assert
        assertThrows(RuntimeException.class,()->productController
                .getProductById(101L));

    }

}