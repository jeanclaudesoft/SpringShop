package com.claudylab.shop.services;

import com.claudylab.shop.models.Product;
import com.claudylab.shop.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

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

    public Long totalStock(){
        return  articleRepository.totalStock();
    }


    public void updateStock(int id,int qte){
        articleRepository.updateStock(id,qte);
    }

    public void minusStock(int id,int qte){
        articleRepository.minusStock(id,qte);
    }

    public List<Product> StocktList(){
        return articleRepository.StockProduct();
    }

    public List<Product> underStocktList(){
        return articleRepository.underStockProduct();
    }

}
