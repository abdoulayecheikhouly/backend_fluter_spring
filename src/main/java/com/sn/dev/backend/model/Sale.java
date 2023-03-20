package com.sn.dev.backend.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity

public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private LocalDateTime date;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public Long getId() {
        return id;
    }

    public Sale() {
    }

    public Sale(int quantity, Double price, Stock stock) {
        this.quantity = quantity;
        this.price= price;
        this.stock = stock;
    }

    public Sale(Long id,int quantity, LocalDateTime date, Double price, Stock stock) {
        this.quantity = quantity;
        this.date = date;
        this.price= price;
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPric(Double prix) {
        this.price= prix;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
