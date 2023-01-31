package com.sn.dev.backend.service;

import com.sn.dev.backend.model.ProductSize;
import com.sn.dev.backend.model.Stock;
import com.sn.dev.backend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StockServiceImp implements StockService{

    @Autowired
    private StockRepository stockRepository;
    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updapeStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deletedStockId(Long id) {

        stockRepository.deleteById(id);

    }

    @Override
    public List<Stock> gellAllStock(Stock stock) {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).get();
    }
}
