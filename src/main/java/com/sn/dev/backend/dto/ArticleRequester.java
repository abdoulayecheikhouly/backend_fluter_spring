package com.sn.dev.backend.dto;

import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.model.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ManyToOne;
import java.util.Date;
@Data
public class ArticleRequester {



    private String name;
    private Date date;
    private Category category;
    private Boolean available;
    private MultipartFile image;

}