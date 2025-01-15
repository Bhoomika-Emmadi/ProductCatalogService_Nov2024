package org.example.productcatalogservice_nov2024.services;

import org.example.productcatalogservice_nov2024.dtos.SortParam;
import org.example.productcatalogservice_nov2024.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {

    Page<Product> search(String query, Integer pageSize, Integer pageNumber,List<SortParam> sortParams);
}
