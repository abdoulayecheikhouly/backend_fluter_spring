package com.sn.dev.backend.controller;


import com.sn.dev.backend.model.ProductSize;
import com.sn.dev.backend.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productsize")
public class ProductSizeController {

    @Autowired
    private ProductSizeService productSizeService;
    @GetMapping()
    private List<ProductSize> getAllProductSize() {
        return productSizeService.getAllProduitsSize();

    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ProductSize getProductSizeById(@PathVariable("id") Long id) {
        return productSizeService.getProduitSize(id);
    }
    @PostMapping
    public ProductSize savePro(@RequestBody ProductSize productSize){
        return productSizeService.saveProductSize(productSize);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ProductSize updateProductSize(@RequestBody ProductSize productSize) {
        return productSizeService.updateProduitSize(productSize);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable("id") Long id)
    {

        productSizeService.deleteProduitSizeById(id);
    }

}
