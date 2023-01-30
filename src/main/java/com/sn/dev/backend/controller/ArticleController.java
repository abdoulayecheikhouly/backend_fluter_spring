package com.sn.dev.backend.controller;


import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.service.ArticleService;
import com.sn.dev.backend.service.ArticleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/article")

public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<Article> createProduct(@RequestBody Article article, @RequestParam("image") MultipartFile image) {
        Article createdProduct = articleService.createArticle(article, image);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping
    public List<Article> getAllProducts() {
        return articleService.getAllArticle();
    }

    @GetMapping("/{id}")
    public Article getProductById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @PutMapping("/{id}")
    public Article updateProduct(@PathVariable Long id, @RequestBody Article updatedArticle, @RequestParam("image") MultipartFile image) {
        return articleService.updateArticle(id, updatedArticle, image);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id)
    {

        articleService.deleteArticle(id);
    }
}
