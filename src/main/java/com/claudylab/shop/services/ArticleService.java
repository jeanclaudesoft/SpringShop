package com.claudylab.shop.services;

import com.claudylab.shop.models.Product;
import com.claudylab.shop.models.Product;
import com.claudylab.shop.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleyService {

    @Autowired
    private ArticleRepository articleRepository;

    public void createProduct(Product product){
        articleRepository.save(product);
    }

    public List<Product> ProductList(){
        return articleRepository.findAll();
    }

    public Product singleProduct(int ProductId){
        return  articleRepository.findById(ProductId).get();
    }

    public void deleteProduct(int ProductId){
        articleRepository.deleteById(ProductId);
    }

    public Long ProductCount(){
        return  articleRepository.count();
    }

    public void updateStock(int id,int qte){
        articleRepository.updateStock(id,qte);
    }

}
