package org.example.menu;

import org.example.entity.Admin;
import org.example.entity.Customer;
import org.example.repository.admin.AdminRepositoryImpl;
import org.example.repository.customer.CustomerRepositoryImpl;
import org.example.service.admin.AdminServiceImpl;
import org.example.service.customer.CustomerServiceImpl;

import java.util.Random;
import java.util.Scanner;

public class Home {
    AdminServiceImpl adminService = new AdminServiceImpl(new AdminRepositoryImpl());
    CustomerServiceImpl customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());

    public void getHome() {
        Random random = new Random();
        CustomerWork customerWork=new CustomerWork();
        AdminWork adminWork=new AdminWork();
        Customer baseCustomer;
        Admin baseAdmin;

        System.out.println("------------WELCOME----------");
        System.out.println("1.Login to Customer");
        System.out.println("2.login to Admin");
        System.out.println("3.register Customer");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case (3):
                System.out.println("please complete Form");
                System.out.println("Enter Name :");
                Customer customer = new Customer();
                customer.setName(scanner.next());
                System.out.println("Enter NationalCode :");
                long l = scanner.nextLong();
                long r = random.nextLong()%1000L;
                customer.setNationalCode(l);
                customer.setCustomerCode(r);
                customerService.save(customer);
                break;

            case (1):
                System.out.println("please Enter CustomerCode :");
                Long customerCode = scanner.nextLong();
                System.out.println("please Enter nationalCode");
                long nationalCode = scanner.nextLong();
                Customer login = customerService.login(customerCode, nationalCode);
                baseCustomer = login;
                customerWork.customerWork(baseCustomer);
                break;

            case (2):
                System.out.println("please Enter Username :");
                Long username = scanner.nextLong();
                System.out.println("please Enter password");
                String password = scanner.next();
                Admin login1 = adminService.login(username, password);
                baseAdmin = login1;
                adminWork.adminWork(baseAdmin);
                break;
            default:
                System.out.println("Entered Wrong number");
        }
    }
}
