package com.sn.dev.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;


import java.util.Date;

public class ArticleTest {

    @Test
    public void testGetId() {
        Article article = new Article();
        article.setId(1L);
        assertEquals(1L, article.getId().longValue());
    }

    @Test
    public void testGetName() {
        Article article = new Article();
        article.setName("Article Name");
        assertEquals("Article Name", article.getName());
    }

    @Test
    public void testGetImageUrl() {
        Article article = new Article();
        article.setImageUrl("https://example.com/image.jpg");
        assertEquals("https://example.com/image.jpg", article.getImageUrl());
    }

    @Test
    public void testGetDate() {
        Article article = new Article();
        Date date = new Date();
        article.setDate(date);
        assertEquals(date, article.getDate());
    }

    @Test
    public void testGetCategory() {
        Article article = new Article();
        Category category = new Category();
        article.setCategory(category);
        assertEquals(category, article.getCategory());
    }

    @Test
    public void testGetAvailable() {
        Article article = new Article();
        article.setAvailable(false);
        assertEquals(false, article.getAvailable());
    }
}

