package com.labs.integracao.config;

import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;

import java.util.List;

public class ListSorter {

    public List<Customer> SortIntoList(List<Customer> customersList, Customer lineCustomer, Order lineOrder, Product lineProduct) {

        int customerIndex = customersList.indexOf(lineCustomer);

        if (customerIndex == -1) {
            lineCustomer.addOrderAndProduct(lineOrder, lineProduct);
            customersList.add(lineCustomer);
        } else {
            int orderIndex = customersList.get(customerIndex).getOrders().indexOf(lineOrder);
            if (orderIndex == -1) {
                customersList.get(customerIndex).addOrderAndProduct(lineOrder, lineProduct);
            } else {
                customersList.get(customerIndex).getOrders().get(orderIndex).addProduct(lineProduct);
            }
        }

        return customersList;

    }
}
