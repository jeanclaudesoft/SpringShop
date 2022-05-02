package com.claudylab.shop.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Approvisionnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAppro;
    private int quantity;
    @ManyToOne
    @JoinColumn(name ="articleId",insertable = false,updatable = false)
    private Product product;
    private int articleId;

    public Approvisionnement() {
    }

    public Approvisionnement(int id, LocalDate dateAppro, int quantity, Product product, int articleId) {
        this.id = id;
        this.dateAppro = dateAppro;
        this.quantity = quantity;
        this.product = product;
        this.articleId = articleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateAppro() {
        return dateAppro;
    }

    public void setDateAppro(LocalDate dateAppro) {
        this.dateAppro = dateAppro;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
