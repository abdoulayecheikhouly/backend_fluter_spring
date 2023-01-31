package com.sn.dev.backend.service;

import com.sn.dev.backend.dto.ArticleRequester;
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
    public Article createArticle(ArticleRequester articleRequester) {
        // Sauvegarder l'article
        String imageUrl = fileStorageService.storeFile(articleRequester.getImage());
        Article article=new Article(articleRequester.getName(),imageUrl,articleRequester.getDate(),articleRequester.getCategory());
        // Enregistrer l' articile

        Article savedArticle = articleRepository.save(article);
        savedArticle.setImage(fileStorageService.loadFileAsResource(article.getImageUrl()));
        return  savedArticle;
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
    public Article updateArticle( Article updatedArticle) {
        Article article = articleRepository.findById(updatedArticle.getId()).orElseThrow(() -> new ArticleNotFoundException("Product not found"));
        article.setName(updatedArticle.getName());
        article.setCategory(updatedArticle.getCategory());

        // Si une nouvelle image est téléchargée, stocker la nouvelle image

        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {

        articleRepository.deleteById(id);

    }
}
