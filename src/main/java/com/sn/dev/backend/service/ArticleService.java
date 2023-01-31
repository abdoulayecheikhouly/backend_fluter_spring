package com.sn.dev.backend.service;

import com.sn.dev.backend.dto.ArticleRequester;
import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.model.ProductSize;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {


    Article createArticle(ArticleRequester articleRequester);
    List<Article> getAllArticle();
    Article getArticleById(Long id);
    Article updateArticle( Article updatedArticle);
    void deleteArticle(Long id);
}
