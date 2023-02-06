package com.sn.dev.backend.service;

import com.sn.dev.backend.model.Sale;
import com.sn.dev.backend.model.Stock;

import java.util.List;
import java.util.Map;

public interface SaleService {

    Map<String,Object> saveSale(Sale sale);
    Map<String,Object> saveSale(List<Sale> sales);
    Map<String,Object>  updapeSale(Sale sale);
    Map<String,Object> deletedStockId(Long id);
    Map<String,Object> gellAllSale();
    Map<String,Object>  getSaleById(Long id);
}
