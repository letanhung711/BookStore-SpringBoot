package com.example.Library.repository;

import com.example.Library.model.OrderDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query("SELECT od.product, SUM(od.quantity) as totalSold FROM OrderDetail od GROUP BY od.product ORDER BY totalSold DESC")
    List<Object[]> findTopSellingProducts(Pageable pageable);
}
