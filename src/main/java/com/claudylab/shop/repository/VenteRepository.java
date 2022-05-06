package com.claudylab.shop.repository;

import com.claudylab.shop.models.Approvisionnement;
import com.claudylab.shop.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("select c from Cart c where c.cartId = :ref")
    List<Cart> getListe(@Param("ref") String ref);

}
