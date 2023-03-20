package com.sn.dev.backend.service;

import com.sn.dev.backend.model.ProductSize;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductSizeService {

    ProductSize saveProductSize(ProductSize productSize);

    ProductSize updateProduitSize(ProductSize productSize);
    void deleteProduitSize(ProductSize productSize);
    void deleteProduitSizeById(Long id);
    ProductSize getProduitSize(Long id);
    List<ProductSize> getAllProduitsSize();
}
