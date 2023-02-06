package com.sn.dev.backend.service;

import com.sn.dev.backend.model.Sale;
import com.sn.dev.backend.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleRepository saleRepository;
    @Override
    public Map<String, Object> saveSale(Sale sale) {
        return null;
    }

    @Override
    public Map<String, Object> saveSale(List<Sale> sales) {
        return null;
    }

    @Override
    public Map<String, Object> updapeSale(Sale sale) {
        return null;
    }

    @Override
    public Map<String, Object> deletedStockId(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> gellAllSale() {
        return null;
    }

    @Override
    public Map<String, Object> getSaleById(Long id) {
        return null;
    }
}
