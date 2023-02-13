package com.sn.dev.backend.model;import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ProductColorTest {

    @Test
    public void testProductColor() {
        ProductColor productColor = new ProductColor();
        productColor.setName("Red");
        assertNotNull(productColor);
        assertEquals("Red", productColor.getName());
    }
}

