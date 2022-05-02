package com.claudylab.shop.repository;

import com.claudylab.shop.models.Category;
import com.claudylab.shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Product, Integer> {
}
