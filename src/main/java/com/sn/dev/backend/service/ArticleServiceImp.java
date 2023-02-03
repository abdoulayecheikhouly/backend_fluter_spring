package com.sn.dev.backend.service;

import com.sn.dev.backend.dto.ArticleRequester;
import com.sn.dev.backend.exception.ArticleNotFoundException;
import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.model.Stock;
import com.sn.dev.backend.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public  Map<String,Object>  getArticleById(Long id) {

        Optional<Article> article= articleRepository.findById(id);
        if(article.isEmpty())
        {
            return new MapResponse().withSuccess(false).withMessage("id non trouvé").response();
        }else
            //return (Map<String, Object>) article;
            return  new MapResponse().withSuccess(true).withMessage("Article trouvé : ").withArrayObject(article).response();
    }

    @Override
    public Map<String,Object> updateArticle(Article updatedArticle) {
        Optional<Article> article= articleRepository.findById(updatedArticle.getId());;
        if (article.isEmpty()){
            return new MapResponse().withSuccess(false).withMessage("Article non trouvé").response();
        }else{
        updatedArticle.setName(updatedArticle.getName());
        //article.setCategory(updatedArticle.getCategory());
        articleRepository.save(updatedArticle);

        return new MapResponse().withSuccess(true).withMessage("le produit dont l'ID est : "+""+updatedArticle.getId()+"  a été modifié avec succes").withArrayObject(updatedArticle).response();
              }
        }

    @Override
    public  Map<String,Object>  deleteArticle(Long id) {
        Optional<Article> article=articleRepository.findById(id);
        if(article.isEmpty()){
            return new MapResponse().withSuccess(false).withMessage("Impossible de trouver l'article").response();
        }else {
            articleRepository.deleteById(id);
           return new MapResponse().withSuccess(true).withArrayObject(article).withMessage("Article supprimer avec succés").response();
        }
    }
}
