package com.claudylab.shop.repository;

import com.claudylab.shop.models.Category;
import com.claudylab.shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query("update Product p set p.stockQuantity=p.stockQuantity + :quantity where p.id= :id")
    void updateStock(@Param("id") int id, @Param("quantity") int qte);
    @Modifying
    @Transactional
    @Query("update Product p set p.stockQuantity=p.stockQuantity - :quantity where p.id= :id")
    void minusStock(@Param("id") int id, @Param("quantity") int qte);

    @Query("SELECT p FROM Product p WHERE p.stockQuantity <p.quantitySeuil")
    List<Product> underStockProduct();

    @Query("SELECT p FROM Product p WHERE p.stockQuantity >0")
    List<Product> StockProduct();

    @Query(value = "SELECT sum(stockQuantity) FROM Product")
    public Long totalStock();

}
