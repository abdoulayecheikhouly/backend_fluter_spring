package com.sn.dev.backend.dto;

import com.sn.dev.backend.model.Category;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;

public class ArticleRequester {



    private String name;
    private Date date;
    private Category category;
    private Long category_id;
    private Boolean available;
    private MultipartFile image;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    public MultipartFile getImage() {
        return image;
    }
    public void setImage(MultipartFile image) {
        this.image = image;
    }
    public Long getCategory_id() {
        return category_id;
    }
    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

}