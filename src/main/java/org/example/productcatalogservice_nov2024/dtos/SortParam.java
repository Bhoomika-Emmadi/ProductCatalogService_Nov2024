package org.example.productcatalogservice_nov2024.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortParam {
   private SortType sortType;
   private String sortCriteria;

}
