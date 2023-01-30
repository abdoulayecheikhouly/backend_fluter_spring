package com.sn.dev.backend.service;

import com.sn.dev.backend.model.ProductColor;
import com.sn.dev.backend.model.ProductSize;
import com.sn.dev.backend.repository.ProductColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductColorServiceImp implements ProductColorService{

    @Autowired
    private ProductColorRepository productColorRepository;
    @Override
    public ProductColor saveProductColor(ProductColor productColor) {
        return productColorRepository.save(productColor);
    }

    @Override
    public ProductColor updateProductColor(ProductColor productColor) {
        return productColorRepository.save(productColor);
    }

    @Override
    public void deleteProductColor(ProductColor productColor) {

        productColorRepository.delete(productColor);

    }

    @Override
    public void deleteProductColorById(Long id) {
        productColorRepository.deleteById(id);

    }

    @Override
    public ProductColor getProductColor(Long id) {
        return productColorRepository.findById(id).get();
    }

    @Override
    public List<ProductColor> getAllProductColor() {
        return productColorRepository.findAll();
    }
}
