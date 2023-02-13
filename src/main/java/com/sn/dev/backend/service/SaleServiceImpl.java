package com.sn.dev.backend.service;

import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.model.Sale;
import com.sn.dev.backend.model.Stock;
import com.sn.dev.backend.repository.ArticleRepository;
import com.sn.dev.backend.repository.SaleRepository;
import com.sn.dev.backend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private  StockRepository stockRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Map<String, Object> saveSale(Sale sale) {

        Long stockId = sale.getStock().getId();
        if(stockId==null){
          return   new MapResponse().withSuccess(false).withMessage("Vous n'avez pas choisi de produit").response();
        }else{
            Optional<Stock> stock = stockRepository.findById(stockId);
            if (stock.isEmpty()){
             return   new  MapResponse().withSuccess(false).withMessage(" Produit introuvable").response();
            }else {
                Integer quantity=sale.getStock().getQuantity();
                if (sale.getQuantity()>quantity){
                    return new MapResponse().withSuccess(false).withMessage(" quantité non disponible").response();
                }
                else{

                    stock.get().setQuantity(stock.get().getQuantity() - quantity);
                        // Optional<Sale>  savedSale=saleRepository.save(sale);

                    Sale savedSale= saleRepository.save(sale);
                         if (savedSale==null){
                             return new MapResponse().withSuccess(false).withMessage("Vente echoué").response();
                         }else {
                             Stock savedStock = stockRepository.save(stock.get());
                             if (savedStock == null) {
                                 return new MapResponse().withSuccess(false).withMessage("failed to update").response();
                             } else {
                                 if(getAvailabeQuantity(savedStock.getArticle().getId()).equals(0)){

                                     Optional<Article>article=articleRepository.findById(savedStock.getArticle().getId());
                                     article.get().setAvailable(false);
                                     articleRepository.save(article.get());
                                 }
                                     return new MapResponse().withSuccess(true).withMessage("Vente Succes").withObject(savedSale).response();
                             }

                         }
                }
            }
        }


    }


    @Override
    public Map<String, Object> updateSale(Sale sale) {
        Optional<Sale> existingSale = saleRepository.findById(sale.getId());
        if (existingSale.isEmpty()) {
            return new MapResponse().withSuccess(false).withMessage("Vente introuvable").response();
        } else {
            Sale updatedSale = saleRepository.save(sale);
            if (updatedSale == null) {
                return new MapResponse().withSuccess(false).withMessage("Mise à jour a échoué").response();
            } else {
                return new MapResponse().withSuccess(true).withMessage("Mise à jour avec succès").withObject(updatedSale).response();
            }
        }
    }

    @Override
    public Map<String, Object> deletedSaleId(Long id) {

        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isPresent()) {
            saleRepository.delete(sale.get());
            return new MapResponse().withSuccess(true).withMessage("Suppression réussie").response();
        } else {
            return new MapResponse().withSuccess(false).withMessage("Vente introuvable").response();
        }
    }

    @Override
    public Map<String, Object> gellAllSale() {

        List<Sale> sales = saleRepository.findAll();
        if (sales.isEmpty()) {
            return new MapResponse().withSuccess(false).withMessage("No sales found").response();
        } else {
            return new MapResponse().withSuccess(true).withMessage("Sales retrieved").withObject(sales).response();
        }
    }

    @Override
    public Map<String, Object> getSaleById(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isEmpty()) {
            return new MapResponse().withSuccess(false).withMessage("Vente introuvable").response();
        } else {
            return new MapResponse().withSuccess(true).withMessage("Vente trouvé").withObject(sale.get()).response();
        }
    }

    private Integer getAvailabeQuantity(Long articleId){
        // This line mean select * from stock in sql
        List<Stock> stocks= stockRepository.findAll();
        //this line mean select * from stock where article_id = articleId;
        stocks=stocks.stream().filter(stock -> stock.getArticle().
                getId().equals(articleId)).collect(Collectors.toList());
        // this line mean select sum quantity from stock where article id =
        Integer quantity=stocks.stream().mapToInt(stock->stock.getQuantity()).sum();

        return  quantity;
    }
}
