package com.labs.integracao.config;

import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineTreatment {

    public List<Customer> readLinesFromBr(BufferedReader br) {
        List<Customer> customerList = new ArrayList<>();
        ListSorter listSorter = new ListSorter();
        String line;
        try {
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
            return null;
        }
        return customerList;
    }
}