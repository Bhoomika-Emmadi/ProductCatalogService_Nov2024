package org.example.productcatalogservice_nov2024.controllers;

import org.example.productcatalogservice_nov2024.dtos.CategoryDto;
import org.example.productcatalogservice_nov2024.dtos.ProductDto;
import org.example.productcatalogservice_nov2024.dtos.SearchDto;
import org.example.productcatalogservice_nov2024.models.Product;
import org.example.productcatalogservice_nov2024.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ISearchService searchService;

    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchDto searchDto)
    {
      //  List<ProductDto> results = new ArrayList<>();
       return searchService.search(searchDto.getQuery(),
               searchDto.getPageSize(), searchDto.getPageNumber(),searchDto.getSortParams());
//       for(Product product : products) {
//            results.add(from(product));
//       }
//
//       return results;
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


//{
//        "query" : "laptop",
//        "pageSize" : 10,
//        "pageNumber" : 0,
//        "sortParams" : [
//        {
//        "sortType" : "ASC",
//        "sortCriteria" : "price"
//        },
//        {
//        "sortType" : "DESC",
//        "sortCriteria" : "id"
//        }
//        ]
//        }