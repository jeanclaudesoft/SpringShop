package com.claudylab.shop.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    @Column(name = "stockQuantity", nullable = true)
    private int stockQuantity;
    private int price;
    private int quantitySeuil;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreation;
    @ManyToOne
    @JoinColumn(name = "categoryId", insertable = false,updatable = false)
    private Category category;
    private int categoryId;

    public Product() {
    }

    public Product(String libelle, int stockQuantity, int price, int quantitySeuil, LocalDate dateCreation, Category category) {
        this.libelle = libelle;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.quantitySeuil = quantitySeuil;
        this.dateCreation = dateCreation;
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantitySeuil() {
        return quantitySeuil;
    }

    public void setQuantitySeuil(int quantitySeuil) {
        this.quantitySeuil = quantitySeuil;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
