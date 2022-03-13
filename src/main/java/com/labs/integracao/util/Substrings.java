package com.labs.integracao.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Substrings {

    /*Esta classe separa os métodos substring configurados de acordo com o ArchiveConfig, afim de deixar o código
    da classe FileHandler mais limpo e organizado. */

    public static Long getUserIdSubstring(String line){
        try {
            return Long.parseLong(line.substring(ArchiveConfig.USER_ID_BEGIN_INDEX, ArchiveConfig.USER_ID_END_INDEX));
        }catch (NumberFormatException exception){
            throw exception;
        }
    }

    public static String getUserNameSubstring(String line){
        return line.substring(ArchiveConfig.NAME_BEGIN_INDEX, ArchiveConfig.NAME_END_INDEX).trim();
    }

    public static Long getOrderIdSubstring(String line){
        try{
            return Long.parseLong(line.substring(ArchiveConfig.ORDER_ID_BEGIN_INDEX, ArchiveConfig.ORDER_ID_END_INDEX));
        }catch (NumberFormatException exception){
            throw exception;
        }
    }

    public static LocalDate getDateOrderSubstring(String line){
        try{
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
            return LocalDate.parse(line.substring(ArchiveConfig.DATE_BEGIN_INDEX, ArchiveConfig.DATE_END_INDEX), format);
        } catch (DateTimeException exception) {
            throw exception;
        }
    }

    public static Long getProductIdSubstring(String line){
        try {
            return Long.parseLong(line.substring(ArchiveConfig.PRODUCT_ID_BEGIN_INDEX, ArchiveConfig.PRODUCT_ID_END_INDEX));
        }catch (NumberFormatException exception){
            throw exception;
        }
    }

    public static Double getValorSubstring(String line){
        try{
            return Double.parseDouble(line.substring(ArchiveConfig.VALUE_BEGIN_INDEX, ArchiveConfig.VALUE_END_INDEX));
        } catch (NumberFormatException exception){
            throw exception;
        }
    }

}
