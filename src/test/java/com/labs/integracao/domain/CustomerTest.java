package com.labs.integracao.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Mock
    Customer customerUnderTest = new Customer(1L, "Test User");

    @Test
    void addOrder() {
        //Given
        Order order = new Order(10L, LocalDate.now());

        //When
        customerUnderTest.addOrder(order);

        //Then
        assertEquals(customerUnderTest.getOrders().get(0), order);
    }

    @Test
    void itShouldGetUserId() {
        //Given
        customerUnderTest.setUser_id(10L);

        //When
        Long user_id = customerUnderTest.getUser_id();

        //Then
        assertEquals(user_id, 10L);
    }

    @Test
    void itShouldSetUserId() {
        //Given
        Long user_id = 10L;

        //When
        customerUnderTest.setUser_id(user_id);

        //Then
        assertEquals(customerUnderTest.getUser_id(),10L);
    }

    @Test
    void itShouldGetName() {
        //Given
        customerUnderTest.setName("Erick");

        //When
        String name = customerUnderTest.getName();

        //Then
        assertEquals(name, "Erick");
    }

    @Test
    void itShouldSetName() {
        //Given
        String name = "Erick";

        //When
        customerUnderTest.setName(name);

        //Then
        assertEquals(customerUnderTest.getName(), "Erick");
    }

    @Test
    void itShouldGetOrders() {
        //Given
        Order order = new Order(10L, LocalDate.now());
        List<Order> listOrder = new ArrayList<>();
        listOrder.add(order);
        customerUnderTest.setOrders(listOrder);

        //When
        List<Order> orders = customerUnderTest.getOrders();

        //Then
        assertEquals(orders, listOrder);
    }

    @Test
    void itShouldSetOrders() {
        //Given
        Order order = new Order(10L, LocalDate.now());

        List<Order> orders = new ArrayList<>();
        orders.add(order);

        //When
        customerUnderTest.setOrders(orders);

        //Then
        assertEquals(customerUnderTest.getOrders(), orders);
    }

    @Test
    void testEqualsShouldReturnTrue() {
        //Given
        Customer underTestEquals = new Customer(1L, "Test User");

        //When
        boolean isEqual = underTestEquals.equals(customerUnderTest);

        assertTrue(isEqual);
    }

    @Test
    void testEqualsShouldReturnFalseWhenNameIsDifferent() {
        //Given
        Customer underTestEquals = new Customer(1L, "User Test");

        //When
        boolean isEqual = underTestEquals.equals(customerUnderTest);

        assertFalse(isEqual);
    }

    @Test
    void testEqualsShouldReturnFalseWhenIdIsDifferent() {
        //Given
        Customer underTestEquals = new Customer(2L, "Test User");

        //When
        boolean isEqual = underTestEquals.equals(customerUnderTest);

        assertFalse(isEqual);
    }
}