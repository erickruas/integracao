package com.labs.integracao.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Mock
    Order order1 = new Order(2L, LocalDate.now());

    @Mock
    Product productA = new Product(1L, new BigDecimal("100.00"));

    @Test
    void itShouldAddAProduct() {
        order1.addProduct(productA);
        assertEquals(order1.getProducts().get(0), productA);
    }


}