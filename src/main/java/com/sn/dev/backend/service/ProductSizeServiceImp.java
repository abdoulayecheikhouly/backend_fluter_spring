package com.sn.dev.backend.service;

import com.sn.dev.backend.model.ProductSize;
import com.sn.dev.backend.repository.ProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductSizeServiceImp  implements ProductSizeService{

    @Autowired
    private ProductSizeRepository productSizeRepository;
    @Override
    public ProductSize saveProductSize(ProductSize productSize) {
        return productSizeRepository.save(productSize);
    }

    @Override
    public ProductSize updateProduitSize(ProductSize productSize) {
        return productSizeRepository.save(productSize);
    }

    @Override
    public void deleteProduitSize(ProductSize productSize) {

        productSizeRepository.delete(productSize);

    }

    @Override
    public void deleteProduitSizeById(Long id) {

        productSizeRepository.deleteById(id);

    }

    @Override
    public ProductSize getProduitSize(Long id) {
        return productSizeRepository.findById(id).get();
    }

    @Override
    public List<ProductSize> getAllProduitsSize() {
        return productSizeRepository.findAll();
    }
}
