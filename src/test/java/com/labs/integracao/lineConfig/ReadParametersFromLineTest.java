package com.labs.integracao.lineConfig;

import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.labs.integracao.lineConfig.ReadParametersFromLine.*;
import static org.junit.jupiter.api.Assertions.*;

class ReadParametersFromLineTest {

    @Mock
    String validLine = "0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308";

    @Mock
    Customer underTestCustomer = Customer.createCustomer(70L,"Palmer Prosacco");

    @Mock
    Order underTestOrder = Order.createOrder(753L,LocalDate.now());

    @Mock
    Product underTesteProduct = Product.createProduct(3L, new BigDecimal(1836.74).setScale(2, RoundingMode.HALF_EVEN));

    @Test
    void itShouldGetUserIdFromLine() {
        Long userId = getUserId(validLine);
        assertEquals(userId, 70L);
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenTryToGetUserIdFromLine() {
        String line = "000--00070                              Palmer Prosacco00000007530000000003     1836.7420210308";
        assertThrowsExactly(NumberFormatException.class, () -> getUserId(line));
    }

    @Test
    void itShouldGetUserNameFromLine() {
        String name = getUserName(validLine);
        assertEquals(name, "Palmer Prosacco");
    }

    @Test
    void itShouldGetOrderIdFromLine() {
        Long orderId = getOrderId(validLine);
        assertEquals(orderId, 753L);
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenTryToGetOrderIdFromLine() {
        String line = "0000000070                              Palmer Prosacco0--d0007530000000003     1836.7420210308";
        assertThrowsExactly(NumberFormatException.class, () -> getOrderId(line));
    }

    @Test
    void itShouldGetDateFromLine() {
        LocalDate date = getOrderDate(validLine);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate.parse("20210308", format);
        assertEquals(date, date);
    }

    @Test
    void itShouldThrowADateTimeExceptionWhenTryToGetDateFromLine() {
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1836.742021030a";
        assertThrowsExactly(DateTimeParseException.class, () -> getOrderDate(line));
    }
    @Test
    void itShouldGetProductIdFromLine() {
        Long productId = getProductId(validLine);
        assertEquals(productId, 3L);
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenTryToGetProductIdFromLine() {
        String line = "0000000070                              Palmer Prosacco00000007530000ss0003     1836.7420210308";
        assertThrowsExactly(NumberFormatException.class, () -> getProductId(line));
    }

    @Test
    void itShouldGetValueFromLine() {
        BigDecimal value = new BigDecimal(getProductValue(validLine)).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(value, new BigDecimal("1836.74"));
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenTryToGetValueFromLine() {
        String line = "0000000070                              Palmer Prosacco00000007530000000003     18-a.7420210308";
        assertThrowsExactly(NumberFormatException.class, () -> getProductValue(line));
    }

    @Test
    void itShouldGetCustomerFromLine() {
        Customer customer = getCustomerFromLine(validLine);
        assertEquals(customer, underTestCustomer);
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenUserIdIsInvalid() {
        String line = "000--00070                              Palmer Prosacco00000007530000000003     1836.7420210308";
        assertThrowsExactly(NumberFormatException.class, () ->getCustomerFromLine(line));
    }


    @Test
    void itShouldGetOrderFromLine() {
        Order order = getOrderFromLine(validLine);
        assertEquals(order, underTestOrder);
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenOrderIdIsInvalid() {
        String line = "0000000070                              Palmer Prosacco00000--7530000000003     1836.7420210308";
        assertThrowsExactly(NumberFormatException.class, () ->getOrderFromLine(line));
    }

    @Test
    void itShouldThrowADateTimeParseExceptionWhenDateIsInvalid() {
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1836.742021-308";
        assertThrowsExactly(DateTimeParseException.class, () -> getOrderFromLine(line));
    }

    @Test
    void itShouldGetProductFromLine() {
        Product product = getProductFromLine(validLine);
        assertEquals(product.getProductId(), underTesteProduct.getProductId());
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenProductIdIsInvalid() {
        String line = "0000000070                              Palmer Prosacco0000000753000000+003     1836.7420210308";
        assertThrowsExactly(NumberFormatException.class, () ->getProductFromLine(line));
    }

    @Test
    void itShouldThrowANumberFormatExceptionWhenValueIsInvalid() {
        String line = "0000000070                              Palmer Prosacco00000007530000000003     183-.7420210308";
        assertThrowsExactly(NumberFormatException.class, () -> getProductFromLine(line));
    }

    @Test
    void itShouldBeAValidLine(){
        assertTrue(isAValidLine(validLine));
    }

    @Test
    void itShouldNotBeAValidLineBlank(){
        String line = "";
        assertFalse(isAValidLine(line));
    }

    @Test
    void itShouldNotBeAValidLineMoreLength(){
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1834.74202103088888";
        assertFalse(isAValidLine(line));
    }

    @Test
    void itShouldNotBeAValidLineLessLength(){
        String line = "0000000070                              Palmer Prosacco00000007530000000003     1834.74";
        assertFalse(isAValidLine(line));
    }
}