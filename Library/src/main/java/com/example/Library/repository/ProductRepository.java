package com.example.Library.repository;

import com.example.Library.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
    @Query("SELECT p FROM Product p ORDER BY p.create_time DESC")
    List<Product> findTop10ByOrderByCreate_timeDesc();
}
