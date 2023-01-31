package com.sn.dev.backend.service;

import com.sn.dev.backend.model.ProductSize;
import com.sn.dev.backend.model.Stock;

import java.util.List;

public interface StockService {

    Stock saveStock(Stock stock);
    Stock updapeStock(Stock stock);
    void deletedStockId(Long id);
    List<Stock> gellAllStock(Stock stock);
    Stock getStockById(Long id);

}
