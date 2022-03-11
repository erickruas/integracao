package com.labs.integracao.util;

import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class ArchiveConfig {

    public static final int ID_USUARIO_INDEX_INICIAL = 0;
    public static final int ID_USUARIO_INDEX_FINAL = 10;
    public static final int NOME_INDEX_INICIAL = 10;
    public static final int NOME_INDEX_FINAL = 55;
    public static final int ID_PEDIDO_INDEX_INICIAL = 55;
    public static final int ID_PEDIDO_INDEX_FINAL = 65;
    public static final int ID_DATA_COMPRA_INDEX_INICIAL = 87;
    public static final int ID_DATA_COMPRA_INDEX_FINAL = 94;
    public static final int ID_PRODUTO_INDEX_INICIAL = 65;
    public static final int ID_PRODUTO_INDEX_FINAL = 75;
    public static final int VALOR_PRODUTO_INDEX_INICIAL = 75;
    public static final int VALOR_PRODUTO_INDEX_FINAL = 87;

}
