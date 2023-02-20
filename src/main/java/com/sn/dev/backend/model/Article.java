package com.sn.dev.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.core.io.Resource;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String imageUrl;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Boolean available=true;
    public  Article(){}

    public Article(String name,String imageUrl,Date date,Category category){

        this.name=name;
        this.imageUrl=imageUrl;
        this.date=date;
        this.category=category;
        this.available=true;
    }
    public Article(Long id,String name,String imageUrl,Date date,Category category){
        this.id = id;
        this.name=name;
        this.imageUrl=imageUrl;
        this.date=date;
        this.category=category;
        this.available=true;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Date getDate() {
        return date;
    }
 public Category getCategory() {
        return category;
    }

    public Boolean getAvailable() {
        return available;
    }
}
