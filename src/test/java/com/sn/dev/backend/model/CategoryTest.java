package com.sn.dev.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    public void testCategoryCreation() {
        Category category = new Category();
        assertNotNull(category);
    }

    @Test
    public void testGetAndSetName() {
        Category category = new Category();
        String name = "Test Category";
        category.setName(name);
        assertEquals(name, category.getName());
    }
/*
    @Test
    public void testGetAndSetArticles() {
        Category category = new Category();
        List<Article> articles = new ArrayList<>();
        articles.add(new Article());
        category.setArticles(articles);
        assertEquals(articles, category.getArticles());
    }*/
}

