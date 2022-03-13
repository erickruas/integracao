package com.labs.integracao.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.labs.integracao.domain.Customer;
import com.labs.integracao.domain.Order;
import com.labs.integracao.domain.Product;
import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static com.labs.integracao.util.Substrings.*;

public class FileHandler {

    /* Esta classe faz a leitura do arquivo txt que contem os pedidos. De acordo com a leitura linha a linha, ela tem
    a responsabilidade de organizar esse conteudo dentro do Array de Customers, por tanto é feita a leitura da linha do
    arquivo, após isso é criado um objeto Customer (que contem uma Order e um Product que pertence a essa Order).
    Após a criação do Customer, ele é adicionado no Array de acordo com as seguintes regras (Metodo addToList):
    1) Caso não exista esse Customer dentro do Array, ele é incluido junto com a Order e o Product.
    2) Caso já exista o Customer dentro do Array, é necessário verificar também se a Order já existe para esse Customer.
        2.1) Caso já exista a Order que foi lida na linha, só é adicionado o Product dentro do Customer/Order já contido
        no Array e atualizado o valor total da order; ou
        2.2) Caso não exista a Order dentro do Customer, é adicionada a Order para aquele Customer junto com o respectivo
        Product desta Order e atualizado o valor total da Order;

    */
    List<Customer> Customers = new ArrayList<>();

    public void readFile() {

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("data_1.txt"));
            String line;
            int indexLine = 1;
            while ((line = br.readLine()) != null) {

                if (isAValidLine(line)) {
                    Customer lineCustomer = getCustomerFromLine(line);
                    if (lineCustomer != null) {
                        addToList(lineCustomer);
                    } else {
                        System.out.println("Invalid content in line: " + indexLine);
                    }
                } else {
                    System.out.println("Invalid line size " + indexLine);
                }
                indexLine++;
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile() {

         ObjectMapper mapper = new ObjectMapper();
         mapper.registerModule(new JavaTimeModule());
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         mapper.setDateFormat(dateFormat);
         try {
             mapper.writeValue(new File("result.json"), Customers);
         }
         catch (IOException e) {
             e.printStackTrace();
         }
     }

    private Customer getCustomerFromLine(String line){

        try{
            Customer customer = new Customer(getUserIdSubstring(line),getUserNameSubstring(line));
            Order order = new Order(getOrderIdSubstring(line),getDateOrderSubstring(line));
            Product product = new Product(getProductIdSubstring(line),new BigDecimal(getValorSubstring(line)));
            order.addProduct(product);
            customer.addOrder(order);
            return customer;
        } catch (NumberFormatException exception){
            exception.printStackTrace();
        } catch (DateTimeParseException exception){
            exception.printStackTrace();
        }
        return null;
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

    private boolean isAValidLine(String line) {
        return (line.length() == 95 && !line.isBlank() && !line.isEmpty());
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
