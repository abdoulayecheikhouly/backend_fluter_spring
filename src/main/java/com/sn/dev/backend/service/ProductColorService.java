package com.sn.dev.backend.service;

import com.sn.dev.backend.model.ProductColor;

import java.util.List;

public interface ProductColorService {

    ProductColor saveProductColor(ProductColor productColor);

    ProductColor updateProductColor(ProductColor productColor);
    void deleteProductColor(ProductColor productColor);
    void deleteProductColorById(Long id);
    ProductColor getProductColor(Long id);
    List<ProductColor> getAllProductColor();
}
