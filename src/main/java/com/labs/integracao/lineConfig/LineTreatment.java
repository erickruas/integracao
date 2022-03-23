package com.labs.integracao.lineConfig;

import com.labs.integracao.domain.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineTreatment {

    public static List<Customer> readLinesFromBr(BufferedReader br) {
        List<Customer> customerList = new ArrayList<>();
        var listSorter = new ListSorter();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                if (ReadParametersFromLine.isAValidLine(line)) {
                    var lineCustomer = ReadParametersFromLine.getCustomerFromLine(line);
                    var lineOrder = ReadParametersFromLine.getOrderFromLine(line);
                    var lineProduct = ReadParametersFromLine.getProductFromLine(line);
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