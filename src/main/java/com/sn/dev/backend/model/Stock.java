package com.sn.dev.backend.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stock {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @OneToMany(mappedBy = "")
    List<Sale> sale;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "prodSize_id")
    private ProductSize productSize;

    public Stock(int quantity, Article article, ProductSize productSize, ProductColor productColor) {
        this.quantity = quantity;
        this.article = article;
        this.productSize = productSize;
        this.productColor = productColor;
    }

    public Stock() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }

    public ProductColor getProductColor() {
        return productColor;
    }

    public void setProductColor(ProductColor productColor) {
        this.productColor = productColor;
    }

    @ManyToOne
    @JoinColumn(name = "prodColor_id")
    private ProductColor productColor;




    public Long getId() {
        return id;
    }
}
