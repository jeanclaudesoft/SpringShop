package com.claudylab.shop.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cartId;
    private int total;
    private String client;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Vente() {
    }

    public Vente(int id, int total, String client, LocalDate date, String cartId) {
        this.id = id;
        this.total = total;
        this.client = client;
        this.date = date;
        this.cartId = cartId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}
