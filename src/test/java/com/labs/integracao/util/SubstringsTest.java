package com.labs.integracao.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.labs.integracao.util.Substrings.*;
import static org.junit.jupiter.api.Assertions.*;

class SubstringsTest {

    @Test
    void itShouldGetUserIdFromSubstring() {
        //Given
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308";

        //When
        Long user_id = getUserIdSubstring(line);

        //Then
        assertEquals(user_id, 70L);
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenTryToGetUserIdFromSubstring() {
        //Given
        String line = "000--00070                              Palmer Prosacco00000007530000000003     1836.7420210308";

        //Then
        assertThrowsExactly(NumberFormatException.class, () ->getUserIdSubstring(line));
    }

    @Test
    void itShouldGetUserNameFromSubstring() {
        //Given
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308";

        //When
        String name = getUserNameSubstring(line);

        //Then
        assertEquals(name, "Palmer Prosacco");
    }

    @Test
    void itShouldGetOrderIdFromSubstring() {
        //Given
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308";

        //When
        Long order_id = getOrderIdSubstring(line);

        //Then
        assertEquals(order_id, 753L);
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenTryToGetOrderIdFromSubstring() {
        //Given
        String line = "0000000070                              Palmer Prosacco0--d0007530000000003     1836.7420210308";

        //Then
        assertThrowsExactly(NumberFormatException.class, () ->getOrderIdSubstring(line));
    }

    @Test
    void itShouldGetDateFromSubstring() {
        //Given
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308";

        //When
        LocalDate date = getDateOrderSubstring(line);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate.parse("20210308", format);

        //Then
        assertEquals(date, date);
    }

    @Test
    void itShouldThrowADateTimeExceptionWhenTryToGetDateFromSubstring() {
        //Given
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1836.742021030a";

        //Then
        assertThrowsExactly(DateTimeParseException.class, () ->getDateOrderSubstring(line));
    }
    @Test
    void itShouldGetProductIdFromSubstring() {
        //Given
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308";

        //When
        Long product_id = getProductIdSubstring(line);

        //Then
        assertEquals(product_id, 3L);
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenTryToGetProductIdFromSubstring() {
        //Given
        String line = "0000000070                              Palmer Prosacco00000007530000ss0003     1836.7420210308";

        //Then
        assertThrowsExactly(NumberFormatException.class, () ->getProductIdSubstring(line));
    }

    @Test
    void itShouldGetValueFromSubstring() {
        //Given
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308";

        //When
        BigDecimal value = new BigDecimal(getValueSubstring(line)).setScale(2, RoundingMode.HALF_EVEN);

        //Then
        assertEquals(value, new BigDecimal("1836.74"));
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenTryToGetValueFromSubstring() {
        //Given
        String line = "0000000070                              Palmer Prosacco00000007530000000003     18-a.7420210308";

        //Then
        assertThrowsExactly(NumberFormatException.class, () ->getValueSubstring(line));
    }
}