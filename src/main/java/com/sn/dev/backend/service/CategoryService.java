package com.sn.dev.backend.service;

import com.sn.dev.backend.model.Category;
import com.sn.dev.backend.model.ProductSize;

import java.util.List;

public interface CategoryService {

    Category CreateCategegory(Category category);
    Category updateCategory(Long id,Category category);
    void deleteCategory(Category category);
    void deleteCategoryId(Long id);
    Category getCategory(Long id);
    List<Category> getAllCategory();
}

