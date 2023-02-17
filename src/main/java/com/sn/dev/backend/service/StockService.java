package com.sn.dev.backend.service;

import com.sn.dev.backend.model.ProductSize;
import com.sn.dev.backend.model.Stock;

import java.util.List;
import java.util.Map;

public interface StockService {

    Map<String,Object> saveStock(Stock stock);
    Map<String,Object> saveStockAll(List<Stock> stocks);
    Map<String,Object>  updapeStock(Stock stock);
    Map<String,Object> deletedStockId(Long id);
    Map<String,Object> gellAllStock();
    Map<String,Object>  getStockById(Long id);

}
