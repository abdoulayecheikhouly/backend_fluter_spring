package com.sn.dev.backend.service;

import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.model.ProductSize;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {


    Article createArticle(Article article, MultipartFile image);
    List<Article> getAllArticle();
    Article getArticleById(Long id);
    Article updateArticle(Long id, Article updatedArticle, MultipartFile image);
    void deleteArticle(Long id);
}
