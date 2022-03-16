package com.labs.integracao.lineConfig;

import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListSorterTest {

    @Mock
    ListSorter listSorter = new ListSorter();

    @Mock
    Customer customerA = new Customer(1L, "customerA");

    @Mock
    Customer customerB = new Customer(2L, "customerB");

    @Mock
    Order order1 = new Order(1L, LocalDate.now());

    @Mock
    Order order2 = new Order(2L, LocalDate.now());

    @Mock
    Product productA = new Product(1L, new BigDecimal("100.00"));

    @Mock
    Product productB = new Product(2L, new BigDecimal("100.00"));

    @Mock
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