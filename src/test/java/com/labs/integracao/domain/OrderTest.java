package com.labs.integracao.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Mock
    Order orderUnderTest = new Order(1L, LocalDate.now());

    @Test
    void itShouldAddAProduct() {
        //Given
        Product product = new Product(1L, new BigDecimal("10"));

        //When
        orderUnderTest.addProduct(product);

        //Then
        assertEquals(orderUnderTest.getProducts().get(0), product);
    }

    @Test
    void itShouldGetOrderId() {
        //Given
        orderUnderTest.setOrder_id(10L);

        //When
        Long order_id = orderUnderTest.getOrder_id();

        //Then
        assertEquals(order_id, 10L);
    }

    @Test
    void itShouldSetOrderId() {
        //Given
        Long order_id = 10L;

        //When
        orderUnderTest.setOrder_id(order_id);

        //Then
        assertEquals(orderUnderTest.getOrder_id(),10L);

    }

    @Test
    void itShouldGetTotal() {
        //Given
        orderUnderTest.setTotal(new BigDecimal("1000"));

        //When
        BigDecimal total = orderUnderTest.getTotal();

        //Then
        assertEquals(total, orderUnderTest.getTotal());
    }

    @Test
    void itShouldSetTotal() {
        //Given
        BigDecimal total = new BigDecimal("1000");

        //When
        orderUnderTest.setTotal(total);

        //Then
        assertEquals(orderUnderTest.getTotal(), total);
    }

    @Test
    void itShouldGetDate() {
        //Given
        orderUnderTest.setDate(LocalDate.now());

        //When
        LocalDate testDate = orderUnderTest.getDate();

        //Then
        assertEquals(testDate, orderUnderTest.getDate());
    }

    @Test
    void itShouldSetDate() {
        //Given
        LocalDate testDate = orderUnderTest.getDate();

        //When
        orderUnderTest.setDate(LocalDate.now());

        //Then
        assertEquals(orderUnderTest.getDate(),testDate);
    }

    @Test
    void itShouldGetProducts() {
        //Given
        Product product = new Product(1L, new BigDecimal("10"));
        List<Product> list = new ArrayList<>();
        list.add(product);
        orderUnderTest.setProducts(list);

        //When
        List<Product> testList = orderUnderTest.getProducts();

        //Then
        assertEquals(testList, orderUnderTest.getProducts());
    }

    @Test
    void itShouldSetProducts() {
        //Given
        Product product = new Product(1L, new BigDecimal("10"));
        List<Product> list = new ArrayList<>();
        list.add(product);

        //When
        orderUnderTest.setProducts(list);

        //Then
        assertEquals(orderUnderTest.getProducts(), list);
    }

    @Test
    void itShouldBeEqualWhenIdIsEqual() {
        //Given
        Order orderUnderTest2 = new Order(1L, LocalDate.now());

        //When
        boolean isEqual = orderUnderTest.equals(orderUnderTest2);

        //Then
        assertTrue(isEqual);
    }

    @Test
    void itShouldNotBeEqualWhenIdIsNotEqual() {
        //Given
        Order orderUnderTest2 = new Order(2L, LocalDate.now());

        //When
        boolean isEqual = orderUnderTest.equals(orderUnderTest2);

        //Then
        assertFalse(isEqual);
    }
}