package com.sn.dev.backend.service;

import com.sn.dev.backend.model.Sale;

import java.util.Map;

public interface SaleService {

    Map<String,Object> saveSale(Sale sale);

    Map<String,Object>  updateSale(Sale sale);
    Map<String,Object> deletedSaleId(Long id);
    Map<String,Object> gellAllSale();
    Map<String,Object>  getSaleById(Long id);
}
