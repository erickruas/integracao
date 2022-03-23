package com.labs.integracao.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    Customer customerA = Customer.createCustomer(1L, "customerA");

    Order order1 = Order.createOrder(2L, LocalDate.now());

    Product productA = Product.createProduct(1L, new BigDecimal("100.00"));

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