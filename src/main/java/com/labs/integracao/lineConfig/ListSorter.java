package com.labs.integracao.lineConfig;

import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;

import java.util.List;

public class ListSorter {

    public List<Customer> sortIntoList(List<Customer> customersList, Customer lineCustomer, Order lineOrder, Product lineProduct) {

        List<Customer> list = customersList;

        int customerIndex = list.indexOf(lineCustomer);

        if (customerIndex == -1) {
            lineCustomer.addOrderAndProduct(lineOrder, lineProduct);
            list.add(lineCustomer);
        } else {
            int orderIndex = list.get(customerIndex).getOrders().indexOf(lineOrder);
            if (orderIndex == -1) {
                list.get(customerIndex).addOrderAndProduct(lineOrder, lineProduct);
            } else {
                list.get(customerIndex).getOrders().get(orderIndex).addProduct(lineProduct);
            }
        }
        return list;
    }
}
