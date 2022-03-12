package com.labs.integracao.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Substrings {

    public static Long getUserIdSubstring(String line){
        return Long.parseLong(line.substring(ArchiveConfig.ID_USUARIO_INDEX_INICIAL, ArchiveConfig.ID_USUARIO_INDEX_FINAL));
    }

    public static String getUserNameSubstring(String line){
        return line.substring(ArchiveConfig.NOME_INDEX_INICIAL, ArchiveConfig.NOME_INDEX_FINAL).trim();
    }

    public static Long getOrderIdSubstring(String line){
        return Long.parseLong(line.substring(ArchiveConfig.ID_PEDIDO_INDEX_INICIAL, ArchiveConfig.ID_PEDIDO_INDEX_FINAL));
    }

    public static LocalDate getDateOrderSubstring(String line){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(line.substring(ArchiveConfig.DATA_COMPRA_INDEX_INICIAL, ArchiveConfig.DATA_COMPRA_INDEX_FINAL), format);
    }

    public static Long getProductIdSubstring(String line){
        return Long.parseLong(line.substring(ArchiveConfig.ID_PRODUTO_INDEX_INICIAL, ArchiveConfig.ID_PRODUTO_INDEX_FINAL));
    }

    public static Double getValorSubstring(String line){
        return Double.parseDouble(line.substring(ArchiveConfig.VALOR_PRODUTO_INDEX_INICIAL, ArchiveConfig.VALOR_PRODUTO_INDEX_FINAL));
    }

}
