package com.labs.integracao.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    Order order1 = Order.createOrder(2L, LocalDate.now());

    Product productA = Product.createProduct(1L, new BigDecimal("100.00"));

    @Test
    void itShouldAddAProduct() {
        order1.addProduct(productA);
        assertEquals(order1.getProducts().get(0), productA);
    }


}