package com.labs.integracao.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Mock
    Customer customerA = new Customer(1L, "customerA");

    @Mock
    Order order1 = new Order(2L, LocalDate.now());

    @Mock
    Product productA = new Product(1L, new BigDecimal("100.00"));

    @Test
    void itShouldAddAOrderAndAProductOrderTest() {
        customerA.addOrderAndProduct(order1, productA);
        int productSize = customerA.getOrders().get(0).getProducts().size();
        assertEquals(customerA.getOrders().size(), 1);
    }

    @Test
    void itShouldAddAOrderAndAProductProductTest() {
        customerA.addOrderAndProduct(order1, productA);
        assertEquals(customerA.getOrders().get(0).getProducts().size(), 1);
    }
}