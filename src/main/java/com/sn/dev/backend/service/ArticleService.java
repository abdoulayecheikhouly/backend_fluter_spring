package com.sn.dev.backend.service;

import com.sn.dev.backend.dto.ArticleRequester;
import com.sn.dev.backend.model.Article;

import java.util.Map;

public interface ArticleService {


    Map<String,Object> createArticle(ArticleRequester articleRequester);
    Map<String, Object> getAllArticle();
    // Map<String,List<Article> > getAllArticle();
    Article getArticleById(Long id);
    Article updateArticle( Article updatedArticle);
    void deleteArticle(Long id);
}
