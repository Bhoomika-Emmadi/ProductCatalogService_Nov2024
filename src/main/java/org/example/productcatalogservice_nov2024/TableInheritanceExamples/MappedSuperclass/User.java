package org.example.productcatalogservice_nov2024.TableInheritanceExamples.MappedSuperclass;

import jakarta.persistence.*;

@MappedSuperclass
public class User {
    @Id
    private Long id;
    private String email;
}
