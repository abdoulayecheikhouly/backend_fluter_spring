package com.sn.dev.backend.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StockTest {

    @Test
    public void testSetQuantity() {
        Stock stock = new Stock();
        stock.setQuantity(10);
        assertEquals(10, stock.getQuantity());
    }

    @Test
    public void testSetArticle() {
        Stock stock = new Stock();
        Article article = new Article();
        stock.setArticle(article);
        assertEquals(article, stock.getArticle());
    }
}

