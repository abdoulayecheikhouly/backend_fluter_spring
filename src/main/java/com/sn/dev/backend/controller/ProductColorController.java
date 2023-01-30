package com.sn.dev.backend.controller;


import com.sn.dev.backend.model.ProductColor;
import com.sn.dev.backend.model.ProductSize;
import com.sn.dev.backend.service.ProductColorService;
import com.sn.dev.backend.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productcolor")
public class ProductColorController {

    @Autowired
    private ProductColorService productColorService;
    @GetMapping()
    private List<ProductColor> getAllProductColor() {
        return productColorService.getAllProductColor();

    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ProductColor getProductColorById(@PathVariable("id") Long id) {
        return productColorService.getProductColor(id);
    }
    @PostMapping
    public ProductColor savePro(@RequestBody ProductColor p){
        return productColorService.saveProductColor(p);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ProductColor updateProductSize(@RequestBody ProductColor productColor) {
        return productColorService.updateProductColor(productColor);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable("id") Long id)
    {

        productColorService.deleteProductColorById(id);
    }

}
