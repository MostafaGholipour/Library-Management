package org.example.menu;

import org.example.entity.Customer;
import org.example.entity.Trust;
import org.example.repository.customer.CustomerRepositoryImpl;
import org.example.service.customer.CustomerServiceImpl;

import java.util.Scanner;
import java.util.Set;

public class CustomerWork {
    CustomerServiceImpl customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());
    public void customerWork(Customer customer) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Profile");
            System.out.println("2. Request a Book");
            System.out.println("3. Book renewal request");
            System.out.println("4. History Request");
            System.out.println("5. back meno");
            int input = scanner.nextInt();


            if (input == 1) {
                System.out.println(customerService.loadById(customer.getId()));
            } else if (input == 2) {
                System.out.println("Enter BookId");
                customer.requestBook(scanner.nextLong());
            } else if (input == 3) {
                System.out.println("Enter Id Book In your List:");
                customerService.requestToExtend(customer, scanner.nextLong());
            } else if (input == 4) {
                Set<Trust> list = customer.getList();
                list.forEach(System.out::println);
            } else if (input == 5) {
                break;
            }
        }
    }
}
