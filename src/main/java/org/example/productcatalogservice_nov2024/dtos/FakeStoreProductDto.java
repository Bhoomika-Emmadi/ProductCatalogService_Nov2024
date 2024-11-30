package org.example.productcatalogservice_nov2024.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    Long id;
    String title;
    Double price;
    String description;
    String image;
    String category;
}
