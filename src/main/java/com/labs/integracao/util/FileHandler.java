package com.labs.integracao.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    List<Customer> Customers = new ArrayList<>();

    public void readFile() throws IOException {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\erick\\Downloads\\data_2.txt"));
            String line;

            while((line = br.readLine()) != null) {
                Customer lineCustomer = getCustomer(line);
                Order lineOrder = getOrder(line);
                Product lineProduct = getProduct(line);
                addToList(lineCustomer, lineOrder, lineProduct);
            }
            br.close();

        } catch (IOException ex){
            throw ex;
        }
    }

    public void printJSON() throws JsonProcessingException {

         ObjectMapper mapper = new ObjectMapper();
         mapper.registerModule(new JavaTimeModule());
         try {
             String JSON =  mapper.writeValueAsString(Customers);
             System.out.println(JSON);
         }
         catch (JsonGenerationException | JsonMappingException e) {
             e.printStackTrace();
         }
     }


    public Customer getCustomer(String line){
        return new Customer(getUserIdSubstring(line),getUserNameSubstring(line));
    }

    public Order getOrder(String line){
        return new Order(getOrderIdSubstring(line),getDateOrderSubstring(line));
    }

    public Product getProduct(String line){
        Product product = new Product();
        product.setId_produto(getProductIdSubstring(line));
        product.setValor_produto(getValorSubstring(line));
        return product;
    }

    public Long getUserIdSubstring(String line){
        return Long.parseLong(line.substring(ArchiveConfig.ID_USUARIO_INDEX_INICIAL, ArchiveConfig.ID_USUARIO_INDEX_FINAL));
    }

    public String getUserNameSubstring(String line){
        return line.substring(ArchiveConfig.NOME_INDEX_INICIAL, ArchiveConfig.NOME_INDEX_FINAL).trim();
    }

    public Long getOrderIdSubstring(String line){
        return Long.parseLong(line.substring(ArchiveConfig.ID_PEDIDO_INDEX_INICIAL, ArchiveConfig.ID_PEDIDO_INDEX_FINAL));
    }

    public LocalDate getDateOrderSubstring(String line){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(line.substring(ArchiveConfig.DATA_COMPRA_INDEX_INICIAL, ArchiveConfig.DATA_COMPRA_INDEX_FINAL), format);
    }

    public Long getProductIdSubstring(String line){
        return Long.parseLong(line.substring(ArchiveConfig.ID_PRODUTO_INDEX_INICIAL, ArchiveConfig.ID_PRODUTO_INDEX_FINAL));
    }

    public Double getValorSubstring(String line){
        return Double.parseDouble(line.substring(ArchiveConfig.VALOR_PRODUTO_INDEX_INICIAL, ArchiveConfig.VALOR_PRODUTO_INDEX_FINAL));
    }

    public void addToList(Customer lineCustomer, Order lineOrder, Product lineProduct){

        for(Customer customer : Customers){
            if(customer.equals(lineCustomer)){
                for(Order order : customer.getOrders()){
                    if(order.equals(lineOrder)){
                        order.addProduct(lineProduct);
                        return;
                    }
                }
                lineOrder.addProduct(lineProduct);
                customer.addOrder(lineOrder);
                return;
            }
        }
        lineOrder.addProduct(lineProduct);
        lineCustomer.addOrder(lineOrder);
        Customers.add(lineCustomer);
    }
}
