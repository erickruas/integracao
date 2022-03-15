package com.labs.integracao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labs.integracao.config.ListSorter;
import com.labs.integracao.config.ReadParametersFromLine;
import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;
import com.labs.integracao.file.ArchiveReader;
import com.labs.integracao.file.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntegracaoApplication {

    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>();

        try {
            ArchiveReader archiveReader = new ArchiveReader();
            BufferedReader br = archiveReader.readFile("data_1.txt");
            ListSorter listSorter = new ListSorter();
            String line;
            while ((line = br.readLine()) != null) {
                if (ReadParametersFromLine.isAValidLine(line)) {
                    Customer lineCustomer = ReadParametersFromLine.getCustomerFromLine(line);
                    Order lineOrder = ReadParametersFromLine.getOrderFromLine(line);
                    Product lineProduct = ReadParametersFromLine.getProductFromLine(line);
                    customerList = listSorter.sortIntoList(customerList, lineCustomer, lineOrder, lineProduct);
                } else {
                    System.out.print("Invalid line.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonParser jsonParser = new JsonParser();
        ObjectMapper objectMapper = jsonParser.configureMapper();

        try {
            objectMapper.writeValue(new File("data_1.json"), customerList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
