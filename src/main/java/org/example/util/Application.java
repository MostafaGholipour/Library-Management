package org.example.util;

import lombok.Getter;
import lombok.Setter;
import org.example.Main;
import org.example.entity.*;
import org.example.repository.admin.AdminRepositoryImpl;
import org.example.repository.book.BookRepositoryImpl;
import org.example.repository.bookGroups.BookGroupsRepositoryImpl;
import org.example.repository.customer.CustomerRepositoryImpl;
import org.example.repository.trust.TrustRepositoryImpl;
import org.example.service.admin.AdminServiceImpl;
import org.example.service.book.BookService;
import org.example.service.book.BookServiceImpl;
import org.example.service.bookGroups.BookGroupsServiceImpl;
import org.example.service.customer.CustomerServiceImpl;
import org.example.service.trust.TrustServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

@Getter
@Setter
public class Application {
    private static Application app = null;
    BookServiceImpl bookService = new BookServiceImpl(new BookRepositoryImpl());
    BookGroupsServiceImpl bookGroupsService = new BookGroupsServiceImpl(new BookGroupsRepositoryImpl());
    CustomerServiceImpl customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());
    TrustServiceImpl trustService = new TrustServiceImpl(new TrustRepositoryImpl());
    AdminServiceImpl adminService = new AdminServiceImpl(new AdminRepositoryImpl());

    public static Application getApp() {
        if (app == null)
            app = new Application();
        return app;
    }

    public void adminWork(Admin admin) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. BookGroups");
        System.out.println("2. Add Book");
        System.out.println("3. requests");
        System.out.println("4. register Admin");


        int input = scanner.nextInt();


        while (true) {
            if (input == 1) {
                System.out.println("1.Create BookGroup");
                System.out.println("2.Delete BookGroup");
                System.out.println("3.update BookGroup");
                System.out.println("4.Show All BookGroup");
                System.out.println("5.Show BookGroups of one Book");
                System.out.println("6. back meno");
                int inputBookGroups = scanner.nextInt();

                if (inputBookGroups == 1) {
                    System.out.println("Enter title BookGroup");
                    BookGroups bookGroups = new BookGroups(scanner.next());
                    bookGroupsService.save(bookGroups);
                } else if (inputBookGroups == 2) {
                    System.out.println("Enter id BookGroup");
                    bookGroupsService.deleteById(scanner.nextLong());
                } else if (inputBookGroups == 3) {
                    System.out.println("Enter id BookGroup");
                    BookGroups bookGroups1 = bookGroupsService.loadById(scanner.nextLong());
                    System.out.println("Enter new title BookGroup");
                    bookGroups1.setTitle(scanner.next());
                    bookGroupsService.update(bookGroups1);
                    System.out.println("Success!");
                } else if (inputBookGroups == 4) {
                    System.out.println("----------------------------");
                    List<BookGroups> bookGroups2 = bookGroupsService.LoadAll();
                    bookGroups2.forEach(System.out::println);
                } else if (inputBookGroups == 5) {
                    List<BookGroups> atLeast = bookGroupsService.findAtLeast();
                    atLeast.forEach(System.out::println);
                } else if (inputBookGroups == 6) {
                    break;
                }
            }
            if (input == 2) {
                System.out.println("1.Create Book");
                System.out.println("2.Delete Book");
                System.out.println("3.update BookGroup");
                System.out.println("4.Show All Book");
                System.out.println("5. back meno");
                int inputBook = scanner.nextInt();


                if (inputBook == 1) {
                    System.out.println("enter Name Book");
                    Book book = new Book();
                    book.setName(scanner.next());
                    System.out.println("Enter Name Writer");
                    book.setWriter(scanner.next());
                    System.out.println("Enter number Page");
                    book.setNumberPages(scanner.nextInt());
                    System.out.println("Enter BookGroup id ");
                    book.setBookGroups(bookGroupsService.loadById(scanner.nextLong()));
                    bookService.save(book);
                } else if (inputBook == 2) {
                    System.out.println("Enter Id Book");
                    bookService.deleteById(scanner.nextLong());
                    System.out.println("Success");

                } else if (inputBook == 3) {
                    System.out.println("Enter Id Book");
                    Book book = bookService.loadById(scanner.nextLong());
                    System.out.println("Enter new id BookGroups");
                    book.setBookGroups(bookGroupsService.loadById(scanner.nextLong()));
                    bookService.update(book);
                } else if (inputBook == 4) {
                    System.out.println("---------------------");
                    List<Book> books = bookService.LoadAll();
                    books.forEach(System.out::println);
                    System.out.println("---------------------");
                } else if (inputBook == 5) {
                    break;
                }
            }
            if (input == 3) {
                System.out.println("1. requests Borrow");
                System.out.println("2. show request Borrow");
                System.out.println("3. show requestToExtend");
                System.out.println("4.  request ToExtend");
                System.out.println("5. back meno");
                int inputRequest= scanner.nextInt();

                if(inputRequest==1) {
                    System.out.println("Enter Trust Id");
                    long id = scanner.nextLong();
                    System.out.println("accept   =  0 ,Refuse   = 1");
                    adminService.confirmBorrow(admin, id, scanner.nextInt());
                }else if (inputRequest==2){
                    System.out.println("---------------------------");
                    adminService.requestBorrow();
                    System.out.println("---------------------------");
                } else if (inputRequest==3) {
                    System.out.println("---------------------------");
                    adminService.requestToExtend();
                    System.out.println("---------------------------");
                } else if (inputRequest==4) {
                    System.out.println("Enter Trust Id");
                    long id = scanner.nextLong();
                    System.out.println("accept   =  0 ,Refuse   = 1");
                    adminService.confirmToExtend(admin, id, scanner.nextInt());
                } else if (inputRequest==5) {
                    break;
                }
            }
            if(input==4){
                Random random = new Random();
                System.out.println("please complete Form");
                System.out.println("Enter Name :");
                Admin admin1 = new Admin();
                admin1.setName(scanner.next());
                System.out.println("Enter NationalCode :");
                long l = scanner.nextLong();
                admin1.setNationalCode(l);
                System.out.println("Enter UserName :");
                admin1.setUsername(scanner.nextLong());
                System.out.println("Enter Password :");
                admin1.setPassword(scanner.next());
                adminService.save(admin1);
            }
        }
        adminWork(admin);
    }

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

