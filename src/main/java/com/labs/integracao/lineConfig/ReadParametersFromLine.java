package com.labs.integracao.lineConfig;

import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReadParametersFromLine {

    public static Long getUserId(String line) {
        return Long.parseLong(line.substring(LineIndexConfiguration.USER_ID_BEGIN_INDEX, LineIndexConfiguration.USER_ID_END_INDEX));
    }

    public static String getUserName(String line) {
        return line.substring(LineIndexConfiguration.NAME_BEGIN_INDEX, LineIndexConfiguration.NAME_END_INDEX).trim();
    }

    public static Long getOrderId(String line) {
        return Long.parseLong(line.substring(LineIndexConfiguration.ORDER_ID_BEGIN_INDEX, LineIndexConfiguration.ORDER_ID_END_INDEX));
    }

    public static LocalDate getOrderDate(String line) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(line.substring(LineIndexConfiguration.DATE_BEGIN_INDEX, LineIndexConfiguration.DATE_END_INDEX), format);
    }

    public static Long getProductId(String line) {
        return Long.parseLong(line.substring(LineIndexConfiguration.PRODUCT_ID_BEGIN_INDEX, LineIndexConfiguration.PRODUCT_ID_END_INDEX));
    }

    public static Double getProductValue(String line) {
        return Double.parseDouble(line.substring(LineIndexConfiguration.VALUE_BEGIN_INDEX, LineIndexConfiguration.VALUE_END_INDEX));
    }

    public static Customer getCustomerFromLine(String line) {
        return Customer.createCustomer(getUserId(line), getUserName(line));
    }

    public static Order getOrderFromLine(String line) {
        return Order.createOrder(getOrderId(line), getOrderDate(line));
    }

    public static Product getProductFromLine(String line) {
        return Product.createProduct(getProductId(line), BigDecimal.valueOf(getProductValue(line)));
    }

    public static boolean isAValidLine(String line) {
        return (line.length() == LineIndexConfiguration.LINE_LENGHT && !line.isBlank());
    }

}