package com.sn.dev.backend.controller;

import com.sn.dev.backend.model.Sale;
import com.sn.dev.backend.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/add")
    public Map<String, Object> saveSale(@RequestBody Sale sale) {
        return saleService.saveSale(sale);
    }

    @PutMapping("/update")
    public Map<String, Object> updateSale(@RequestBody Sale sale) {
        return saleService.updateSale(sale);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteSale(@PathVariable Long id) {
        return saleService.deletedSaleId(id);
    }

    @GetMapping("/all")
    public Map<String, Object> getAllSale() {
        return saleService.gellAllSale();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getSaleById(@PathVariable Long id) {
        return saleService.getSaleById(id);
    }
}
