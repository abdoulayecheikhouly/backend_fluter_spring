package com.sn.dev.backend.controller;


import com.sn.dev.backend.dto.ArticleRequester;
import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.service.ArticleService;
import com.sn.dev.backend.service.ArticleServiceImp;
import com.sn.dev.backend.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/article")

public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private FileStorageService storageService;

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Map<String,Object>> createProduct(@ModelAttribute ArticleRequester articleRequester) {
        Map<String,Object> map = articleService.createArticle(articleRequester);
        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }

    @GetMapping
    public List<Article> getAllProducts() {
        return articleService.getAllArticle();
    }
    @GetMapping("/image/{fileName}")
    public Resource getImage(@PathVariable("fileName") String filename){
        return  storageService.loadFileAsResource(filename);
    }

    @GetMapping("/{id}")
    public Article getProductById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @PutMapping("/{id}")
    public Article updateProduct( @RequestBody Article updatedArticle) {
        return articleService.updateArticle( updatedArticle);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id)
    {

        articleService.deleteArticle(id);
    }
}
