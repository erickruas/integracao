package com.labs.integracao.lineConfig;

import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListSorterTest {

    ListSorter listSorter = new ListSorter();

    Customer customerA = Customer.createCustomer(1L, "customerA");

    Customer customerB = Customer.createCustomer(2L, "customerB");

    Order order1 = Order.createOrder(1L, LocalDate.now());

    Order order2 = Order.createOrder(2L, LocalDate.now());

    Product productA = Product.createProduct(1L, new BigDecimal("100.00"));

    Product productB = Product.createProduct(2L, new BigDecimal("100.00"));

    List<Customer> customerList = new ArrayList<>();

    @Test
    void itShouldAddANewCustomer() {
        listSorter.sortIntoList(customerList, customerA, order1, productA);
        customerA.addOrderAndProduct(order1, productA);
        assertEquals(customerList.get(0), customerA);
    }

    @Test
    void itShouldAddANewOrder(){
        listSorter.sortIntoList(customerList, customerA, order1, productA);
        customerA.addOrderAndProduct(order1, productA);
        assertEquals(customerList.get(0).getOrders().get(0), order1);
    }

    @Test
    void itShouldAddANewProduct(){
        listSorter.sortIntoList(customerList, customerA, order1, productA);
        customerA.addOrderAndProduct(order1, productA);
        assertEquals(customerList.get(0).getOrders().get(0).getProducts().get(0), productA);
    }

    @Test
    void itShouldAddTwoOrMoreCustomers(){
        listSorter.sortIntoList(customerList, customerA, order1, productA);
        listSorter.sortIntoList(customerList, customerB, order2, productA);
        assertEquals(customerList.size(), 2);
    }

    @Test
    void itShouldAddTwoOrMoreOrdersForACustomer(){
        listSorter.sortIntoList(customerList, customerA, order1, productA);
        listSorter.sortIntoList(customerList, customerA, order2, productA);
        assertEquals(customerList.get(0).getOrders().size(), 2);
    }

    @Test
    void itShouldAddTwoOrMoreProductsIntoAOrder(){
        listSorter.sortIntoList(customerList, customerA, order1, productA);
        listSorter.sortIntoList(customerList, customerA, order1, productB);
        assertEquals(customerList.get(0).getOrders().get(0).getProducts().size(), 2);
    }

    @Test
    void itShouldCalculateTotalValueOfAOrder(){
        listSorter.sortIntoList(customerList, customerA, order1, productA);
        listSorter.sortIntoList(customerList, customerA, order1, productB);
        assertEquals(customerList.get(0).getOrders().get(0).getTotal(), new BigDecimal("200.00"));
    }

}