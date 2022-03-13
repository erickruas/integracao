package com.labs.integracao.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Mock
    Product productUnderTest = new Product(1L, new BigDecimal("1000"));
    @Test
    void itShouldSetProductId() {
        //Given
        Long product_id = productUnderTest.getProduct_id();

        //When
        productUnderTest.setProduct_id(product_id);

        //Then
        assertEquals(productUnderTest.getProduct_id(), product_id);
    }

    @Test
    void itShouldGetProductId() {
        //Given
        productUnderTest.setProduct_id(10L);

        //When
        Long product_id = productUnderTest.getProduct_id();

        //Then
        assertEquals(product_id, 10L);
    }

    @Test
    void itShouldGetValue() {
        //Given
        productUnderTest.setValue(new BigDecimal("1000"));

        //When
        BigDecimal value = productUnderTest.getValue();

        //Then
        assertEquals(value, productUnderTest.getValue());
    }

    @Test
    void itShouldSetValue() {
        //Given
        BigDecimal value = new BigDecimal("1000");

        //When
        productUnderTest.setValue(value);

        //Then
        assertEquals(productUnderTest.getValue(), value);
    }
}