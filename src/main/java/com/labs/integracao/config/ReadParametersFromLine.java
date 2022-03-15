package com.labs.integracao.config;

import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ReadParametersFromLine {

    public static Long getUserId(String line) {
        try {
            return Long.parseLong(line.substring(LineIndexConfiguration.USER_ID_BEGIN_INDEX, LineIndexConfiguration.USER_ID_END_INDEX));
        } catch (NumberFormatException exception) {
            throw exception;
        }
    }

    public static String getUserName(String line) {
        return line.substring(LineIndexConfiguration.NAME_BEGIN_INDEX, LineIndexConfiguration.NAME_END_INDEX).trim();
    }

    public static Long getOrderId(String line) {
        try {
            return Long.parseLong(line.substring(LineIndexConfiguration.ORDER_ID_BEGIN_INDEX, LineIndexConfiguration.ORDER_ID_END_INDEX));
        } catch (NumberFormatException exception) {
            throw exception;
        }
    }

    public static LocalDate getOrderDate(String line) {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
            return LocalDate.parse(line.substring(LineIndexConfiguration.DATE_BEGIN_INDEX, LineIndexConfiguration.DATE_END_INDEX), format);
        } catch (DateTimeParseException exception) {
            throw exception;
        }
    }

    public static Long getProductId(String line) {
        try {
            return Long.parseLong(line.substring(LineIndexConfiguration.PRODUCT_ID_BEGIN_INDEX, LineIndexConfiguration.PRODUCT_ID_END_INDEX));
        } catch (NumberFormatException exception) {
            throw exception;
        }
    }

    public static Double getProductValue(String line) {
        try {
            return Double.parseDouble(line.substring(LineIndexConfiguration.VALUE_BEGIN_INDEX, LineIndexConfiguration.VALUE_END_INDEX));
        } catch (NumberFormatException exception) {
            throw exception;
        }
    }

    public static Customer getCustomerFromLine(String line) {

        try {
            return new Customer(getUserId(line), getUserName(line));
        } catch (NumberFormatException | DateTimeParseException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static Order getOrderFromLine(String line) {

        try {
            return new Order(getOrderId(line), getOrderDate(line));
        } catch (NumberFormatException | DateTimeParseException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static Product getProductFromLine(String line) {

        try {
            return new Product(getProductId(line), BigDecimal.valueOf(getProductValue(line)));
        } catch (NumberFormatException | DateTimeParseException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static boolean isAValidLine(String line) {
        return (line.length() == LineIndexConfiguration.LINE_LENGHT && !line.isBlank());
    }

}