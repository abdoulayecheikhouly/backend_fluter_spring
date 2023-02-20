package com.sn.dev.backend.service;

import com.sn.dev.backend.model.ProductSize;
import com.sn.dev.backend.model.Stock;
import com.sn.dev.backend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class StockServiceImp implements StockService{

    @Autowired
    private StockRepository stockRepository;
    @Override
    public Map<String,Object> saveStock(Stock stock) {
        Stock savedStock = new Stock();
       List<Stock> stocks= stockRepository.findByArticle_id(stock.getId());
    Optional <Stock>existantStock=stocks.stream().filter(stockItem ->stockItem.getArticle().getId().equals(stock.getArticle().getId())
            && stockItem.getProductColor().equals(stock.getProductColor())
            && stockItem.getProductSize().equals(stock.getProductSize()) ).findFirst();
        if (existantStock.isPresent()){
            existantStock.get().setQuantity(existantStock.get().getQuantity()+stock.getQuantity());
            savedStock = stockRepository.save(existantStock.get());
        }
        else {
            savedStock = stockRepository.save(stock);}
        if(savedStock==null){
            return new MapResponse().withSuccess(false).withMessage("Stock non sauvegardé").response();
        }
        else return new MapResponse().withSuccess(true).withObject(savedStock).withMessage("Stock savegaedé avec succes").response();
    }

    @Override
    public Map<String, Object> saveStockAll(List<Stock> stocks) {
        List<Stock> stock=stockRepository.saveAll( stocks);
        if(stock==null){
            return new MapResponse().withSuccess(false).withMessage("Stocks non sauvegardé").response();
        }
        else
            return new MapResponse().withSuccess(true).withMessage("Stocks savegaedé avec succes").withArrayObject(stock).response();
    }


    @Override
    public  Map<String,Object>  updapeStock(Stock stock) {
        Optional<Stock> s= stockRepository.findById(stock.getId());

        if (s.isEmpty()){
            return new MapResponse().withSuccess(false).withMessage("Stock Introuvable").response();

        }else{
        stockRepository.save(stock);
        return new  MapResponse().withSuccess(true).withMessage("Stock updated").response();
        }
    }

    @Override
    public Map<String,Object> deletedStockId(Long id) {
        Optional<Stock> stock= stockRepository.findById(id);
        if (stock.isEmpty()){

            return new  MapResponse().withSuccess(false).withMessage("Stock Introuvable").response();

        }else{
        stockRepository.deleteById(id);

       return new  MapResponse().withSuccess(true).withMessage("Stock supprimé").response();
        }

    }

    @Override
    public  Map<String,Object> gellAllStock() {
       List <Stock> stocks= stockRepository.findAll();

       if (stocks.size()==0){
           return new MapResponse().withSuccess(false).withMessage(" Aucun stock disponible").response();
       }else
           return new MapResponse().withSuccess(true).withMessage(stocks.size()+" stock disponible").withArrayObject(stocks).response();
    }

    @Override
    public Map<String,Object> getStockById(Long id) {
       Stock stock =stockRepository.findById(id).get();
       if(stock.getId()==0 && stock==null){

           return new MapResponse().withSuccess(false).withMessage(" Aucun stock ne correspond à cet ID").response();

       }else
        //   return (Map<String, Object>) stock;
       return new MapResponse().withSuccess(false).withMessage(" Stock trouvé").response();
    }
}
