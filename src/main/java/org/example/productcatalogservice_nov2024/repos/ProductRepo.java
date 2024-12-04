package org.example.productcatalogservice_nov2024.repos;

import org.example.productcatalogservice_nov2024.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long productId);

    Product save(Product product);
}
