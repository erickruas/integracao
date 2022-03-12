package com.labs.integracao.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static com.labs.integracao.util.Substrings.*;

public class FileHandler {

    List<Customer> Customers = new ArrayList<>();

    public void readFile(){
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\erick\\Downloads\\data_2.txt"));
            String line;

            while((line = br.readLine()) != null) {
                Customer lineCustomer = getCustomerFromLine(line);
                addToList(lineCustomer);
            }
            br.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printJSON() {

         ObjectMapper mapper = new ObjectMapper();
         mapper.registerModule(new JavaTimeModule());
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         mapper.setDateFormat(dateFormat);
         try {
             String JSON =  mapper.writeValueAsString(Customers);
             System.out.println(JSON);
             Path file = Paths.get("JSON.txt");
             Files.writeString(file, JSON);
         }
         catch (IOException e) {
             e.printStackTrace();
         }
     }

    private Customer getCustomerFromLine(String line){
        Customer customer = new Customer(getUserIdSubstring(line),getUserNameSubstring(line));
        Order order = new Order(getOrderIdSubstring(line),getDateOrderSubstring(line));
        Product product = new Product(getProductIdSubstring(line),new BigDecimal(getValorSubstring(line)));
        order.addProduct(product);
        customer.addOrder(order);
        return customer;
    }

    private void addToList(Customer lineCustomer){
        int customerIndex = getCustomerIndex(lineCustomer);

        if(customerIndex == -1){
            Customers.add(lineCustomer);
        } else {
            int orderIndex = getOrderIndex(lineCustomer);
            if(orderIndex == -1){
                addNewOrder(customerIndex, lineCustomer);
            } else {
                addNewProductToOrder(customerIndex, orderIndex, lineCustomer);
            }
        }
    }

    private int getCustomerIndex(Customer lineCustomer){
        return Customers.indexOf(lineCustomer);
    }

    private int getOrderIndex(Customer lineCustomer){
        return Customers.get(getCustomerIndex(lineCustomer)).getOrders().indexOf(lineCustomer.getOrders().get(0));
    }

    private void addNewOrder(int customerIndex, Customer lineCustomer){
        Customers.get(customerIndex).addOrder(lineCustomer.getOrders().get(0));
    }

    private void addNewProductToOrder(int customerIndex, int orderIndex, Customer lineCustomer){
        Customers.get(customerIndex).getOrders().get(orderIndex).addProduct(lineCustomer.getOrders().get(0).getProducts().get(0));
    }
}
