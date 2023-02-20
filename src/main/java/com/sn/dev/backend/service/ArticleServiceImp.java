package com.sn.dev.backend.service;

import com.sn.dev.backend.dto.ArticleRequester;
import com.sn.dev.backend.exception.ArticleNotFoundException;
import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.model.Category;
import com.sn.dev.backend.repository.ArticleRepository;
import com.sn.dev.backend.repository.CategoryRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImp implements ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final FileStorageService fileStorageService;

    public ArticleServiceImp(ArticleRepository articleRepository, FileStorageService fileStorageService,CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.fileStorageService = fileStorageService;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Map<String,Object> createArticle(ArticleRequester articleRequester) {
        // Sauvegarder l'article
        String imageUrl = fileStorageService.storeFile(articleRequester.getImage());
        Category category = categoryRepository.findById(articleRequester.getCategory_id()).get();
        Article article= new Article(articleRequester.getName(),imageUrl,articleRequester.getDate(),category);
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
        Article article=articleRepository.findById(id).get();
        if(article.getId().intValue() == 0 && article.getId() ==null)
        {
            return new MapResponse().withSuccess(false).withMessage("id non trouvé").response();
        }else
            //return (Map<String, Object>) article;
            return  new MapResponse().withSuccess(true).withMessage("Nom "+ article.getName()+" "+ "ImageUrl :"+ article.getImageUrl()+" " + "Category : "+ article.getCategory() +" "+ "Available : "+ article.getAvailable()+"      "+"Article "+article.getId()).response();
    }

    @Override
    public Map<String,Object> updateArticle(Article updatedArticle) {
        Article article = articleRepository.findById(updatedArticle.getId()).get();
        if (article==null){
            return new MapResponse().withSuccess(false).withMessage("Article non trouvé").response();
        }else{
        article.setName(updatedArticle.getName());
        //article.setCategory(updatedArticle.getCategory());
        articleRepository.save(article);

        return new MapResponse().withSuccess(true).withMessage("le produit dont l'ID est : "+""+updatedArticle.getId()+"  a été modifié avec succes").response();
    }
        }

    @Override
    public void deleteArticle(Long id) {
        Article article=articleRepository.findById(id).get();
        if(article==null && article.getId()==0){
             new MapResponse().withSuccess(false).withMessage("Impossible de trouver l'article").response();
        }
        articleRepository.deleteById(id);
        new MapResponse().withSuccess(true).withMessage("Article supprimer avec succés").response();

    }
}
