package com.sn.dev.backend.service;

import com.sn.dev.backend.dto.ArticleRequester;
import com.sn.dev.backend.model.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {


    Map<String,Object> createArticle(ArticleRequester articleRequester);
    List<Article> getAllArticle();
    Article getArticleById(Long id);
    Article updateArticle( Article updatedArticle);
    void deleteArticle(Long id);
}
