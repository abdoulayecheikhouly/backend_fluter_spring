package com.sn.dev.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ProductSizeTest {

    @Test
    public void testProductSize() {
        ProductSize productSize = new ProductSize();
        productSize.setName("Large");
        assertNotNull(productSize);
        assertEquals("Large", productSize.getName());
    }
}

