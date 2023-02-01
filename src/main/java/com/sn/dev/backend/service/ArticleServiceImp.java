package com.sn.dev.backend.service;

import com.sn.dev.backend.dto.ArticleRequester;
import com.sn.dev.backend.exception.ArticleNotFoundException;
import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImp implements ArticleService {

    private final ArticleRepository articleRepository;
    private final FileStorageService fileStorageService;

    public ArticleServiceImp(ArticleRepository articleRepository, FileStorageService fileStorageService) {
        this.articleRepository = articleRepository;
        this.fileStorageService = fileStorageService;
    }


    @Override
    public Map<String,Object> createArticle(ArticleRequester articleRequester) {
        // Sauvegarder l'article
        String imageUrl = fileStorageService.storeFile(articleRequester.getImage());
        Article article=new Article(articleRequester.getName(),imageUrl,articleRequester.getDate(),articleRequester.getCategory());
        // Enregistrer l' articile

        Article savedArticle = articleRepository.save(article);
        if(savedArticle == null){
            return new MapResponse().withSuccess(false).withMessage("L'enregistement a echoué").response();
        }else{
            return new MapResponse().withSuccess(true).withMessage("Enregistrement reussit").withObject(savedArticle).response();
        }
    }

    @Override
    public Map<String, Object> getAllArticle() {

        List<Article> articles=articleRepository.findAll();


        if (articles.size()==0){
            return new MapResponse().withSuccess(false).withMessage("La liste des article est vide").response();
        }
        else
        {return new MapResponse().withSuccess(true).withMessage(articles.size()+" Enregistrements trouvés").withArrayObject(articles).response();}

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
