package org.example.productcatalogservice_nov2024.repos;

import org.example.productcatalogservice_nov2024.models.Product;
import org.example.productcatalogservice_nov2024.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long productId);

    //List<Product> findProductByIdSAndState(Long id, State state);

    Product save(Product product);

    void deleteById(Long productId);

    List<Product> findProductByPriceBetween(Double low,Double high);

    List<Product> findProductByIsPrime(Boolean val);

    //List<Product> findProductOrderByPrice();  //Human Error
    List<Product> findProductByOrderByPriceDesc();
    List<Product> findProductByOrderById();

    @Query("SELECT p.description from Product p where p.id=?1")
    String findProductDescriptionById(Long productId);

    @Query("SELECT c.name FROM Category c join Product p on p.category.id=c.id where p.id=:pid")
    String findCategoryNameByProductId(Long pid);
}
