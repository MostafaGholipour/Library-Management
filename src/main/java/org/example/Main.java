package org.example;

import org.example.entity.*;
import org.example.menu.Home;
import org.example.repository.admin.AdminRepositoryImpl;
import org.example.repository.book.BookRepositoryImpl;
import org.example.repository.bookGroups.BookGroupsRepositoryImpl;
import org.example.repository.customer.CustomerRepositoryImpl;
import org.example.repository.trust.TrustRepositoryImpl;
import org.example.service.admin.AdminServiceImpl;
import org.example.service.book.BookServiceImpl;
import org.example.service.bookGroups.BookGroupsServiceImpl;
import org.example.service.customer.CustomerServiceImpl;
import org.example.service.trust.TrustServiceImpl;
import org.example.util.Application;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl(new BookRepositoryImpl());
        BookGroupsServiceImpl bookGroupsService = new BookGroupsServiceImpl(new BookGroupsRepositoryImpl());
        CustomerServiceImpl customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());
        TrustServiceImpl trustService = new TrustServiceImpl(new TrustRepositoryImpl());
        AdminServiceImpl adminService = new AdminServiceImpl(new AdminRepositoryImpl());
//        BookGroups bookGroups = new BookGroups("Religious");
//        bookGroupsService.save(bookGroups);


//        Book book = new Book();
//        book.setName("Make Your Bed11");
//        book.setWriter("Riona");
//        book.setNumberPages(125);
//        book.setBookGroups(bookGroupsService.loadById(1L));
//        bookService.save(book);


//        BookGroups bookGroups1 = bookGroupsService.loadById(1L);
//        System.out.println(bookGroups1.getBooks());


//        System.out.println(bookGroupsService.LoadAll());
//          bookService.deleteById(2L);
//        System.out.println(bookService.LoadAll());


//        bookService.changeBookGroups(1L,2L);          //2.3


//        System.out.println(bookService.LoadAll());      //2.4


//        Customer customer=new Customer();                //3.1
//        customer.setName("Ali");
//        customer.setNationalCode(12212121L);
//        customer.setCustomerCode(1212112L);
//        customerService.save(customer);

//        Customer customer = customerService.loadById(1L);     //3.3
//        customer.requestBook(1L);

//        Admin admin=new Admin();
//        admin.setName("Morteza");
//        admin.setNationalCode(1111111L);
//        admin.setUsername(1212L);
//        admin.setPassword("AA");
//        adminService.save(admin);


//       adminService.requestToExtend();
//      adminService.confirm(adminService.loadById(1L),3L, StatusTrust.accept);
//        System.out.println(adminService.searchTrust(1L, 2L));
//        Customer customer = customerService.loadById(1L);
//        System.out.println(customer.getList());
//--------------------------------------------------------------------------------------------
     /*   Application app = Application.getApp();
        Random random = new Random();
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
                app.customerWork(baseCustomer);
                break;

            case (2):
                System.out.println("please Enter Username :");
                Long username = scanner.nextLong();
                System.out.println("please Enter password");
                String password = scanner.next();
                Admin login1 = adminService.login(username, password);
                baseAdmin = login1;
                app.adminWork(baseAdmin);
                break;
            default:
                System.out.println("Entered Wrong number");
        }*/
//        System.out.println(customerService.loadById(6L).getList());
       Home home=new Home();
        home.getHome();
    }
}
