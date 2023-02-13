package com.sn.dev.backend.model;


//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Sale {

    //@javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private Date date;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public Long getId() {
        return id;
    }

    public Sale() {
    }

    public Sale(int quantity, Date date, Double price, Stock stock) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
