package com.sn.dev.backend.controller;


import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.model.Stock;
import com.sn.dev.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping
     public ResponseEntity<Map<String,Object>> createStock(@RequestBody Stock stock){
        Map<String,Object> map =stockService.saveStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }
    @PostMapping("/all")
    public ResponseEntity<Map<String,Object>> createStockAll(@RequestBody List<Stock> stocks){
        Map<String,Object> map =stockService.saveStockAll(stocks);
        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }
    @GetMapping
    public Map<String, Object> getAllStocks() {

        return stockService.gellAllStock();
    }


    @GetMapping("/{id}")
    public Map<String, Object>  getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateStock( @RequestBody Stock stock) {
        return stockService.updapeStock( stock);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id)
    {
        stockService.deletedStockId(id);
    }
}
