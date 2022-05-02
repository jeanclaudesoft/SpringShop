package com.claudylab.shop.repository;

import com.claudylab.shop.models.Approvisionnement;
import com.claudylab.shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApproviseRepository extends JpaRepository<Approvisionnement, Integer> {
    @Query("SELECT count(*) FROM Product p WHERE p.stockQuantity < p.quantitySeuil")
    Long underStockCount();
}
