package com.sn.dev.backend.service;

import com.sn.dev.backend.model.Category;
import com.sn.dev.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category CreateCategegory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {


        Category cat=categoryRepository.findById(id).orElseThrow();

        cat.setName(category.getName());

        return categoryRepository.save(category);


    }


    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);

    }

    @Override
    public void deleteCategoryId(Long id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
