package com.sn.dev.backend.service;

import com.sn.dev.backend.exception.ArticleNotFoundException;
import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {

    private final ArticleRepository articleRepository;
    private final FileStorageService fileStorageService;

    public ArticleServiceImp(ArticleRepository articleRepository, FileStorageService fileStorageService) {
        this.articleRepository = articleRepository;
        this.fileStorageService = fileStorageService;
    }


    @Override
    public Article createArticle(Article article, MultipartFile image) {
        // Sauvegarder l'article
        String imageUrl = fileStorageService.storeFile(image);
        article.setImageUrl(imageUrl);

        // Enregistrer l' article
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long id) {
        return  articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("Article not found"));
    }

    @Override
    public Article updateArticle(Long id, Article updatedArticle, MultipartFile image) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("Product not found"));
        article.setName(updatedArticle.getName());
        article.setCategory(updatedArticle.getCategory());

        // Si une nouvelle image est téléchargée, stocker la nouvelle image
        if (image != null) {
            String imageUrl = fileStorageService.storeFile(image);
            article.setImageUrl(imageUrl);
        }

        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {

        articleRepository.deleteById(id);

    }
}
