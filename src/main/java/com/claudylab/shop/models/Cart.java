package com.claudylab.shop.models;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cartId;
    private int quantity;
    private int price;
    @ManyToOne
    @JoinColumn(name ="articleId",insertable = false,updatable = false)
    private Product product;
    private int articleId;


    public Cart() {
    }

    public Cart(int id, String cartId, int quantity, int price,  Product product, int articleId) {
        this.id = id;
        this.cartId = cartId;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.articleId = articleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
