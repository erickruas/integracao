package com.labs.integracao.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Substrings {

    /*Esta classe separa os métodos substring configurados de acordo com o ArchiveConfig, afim de deixar o código
    da classe FileHandler mais limpo e organizado. */

    public static Long getUserIdSubstring(String line){
        return Long.parseLong(line.substring(ArchiveConfig.USER_ID_BEGIN_INDEX, ArchiveConfig.USER_ID_END_INDEX));
    }

    public static String getUserNameSubstring(String line){
        return line.substring(ArchiveConfig.NAME_BEGIN_INDEX, ArchiveConfig.NAME_END_INDEX).trim();
    }

    public static Long getOrderIdSubstring(String line){
        return Long.parseLong(line.substring(ArchiveConfig.ORDER_ID_BEGIN_INDEX, ArchiveConfig.ORDER_ID_END_INDEX));
    }

    public static LocalDate getDateOrderSubstring(String line){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(line.substring(ArchiveConfig.DATE_BEGIN_INDEX, ArchiveConfig.DATE_END_INDEX), format);
    }

    public static Long getProductIdSubstring(String line){
        return Long.parseLong(line.substring(ArchiveConfig.PRODUCT_ID_BEGIN_INDEX, ArchiveConfig.PRODUCT_ID_END_INDEX));
    }

    public static Double getValorSubstring(String line){
        return Double.parseDouble(line.substring(ArchiveConfig.VALUE_BEGIN_INDEX, ArchiveConfig.VALUE_END_INDEX));
    }

}
