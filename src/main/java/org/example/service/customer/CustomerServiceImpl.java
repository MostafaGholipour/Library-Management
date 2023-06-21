package org.example.service.customer;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.Customer;
import org.example.entity.Status;
import org.example.entity.StatusTrust;
import org.example.entity.Trust;
import org.example.repository.customer.CustomerRepositoryImpl;
import org.example.repository.trust.TrustRepositoryImpl;
import org.example.service.trust.TrustServiceImpl;

import java.time.LocalDate;
import java.util.Set;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, CustomerRepositoryImpl> implements CustomerService {
    CustomerRepositoryImpl repository1;

    public CustomerServiceImpl(CustomerRepositoryImpl repository) {
        super(repository);
        repository1 = repository;
    }

    @Override
    public Customer login(long customerCode, long cationalCode) {
        return repository1.login(customerCode, cationalCode);
    }

    @Override
    public void requestToExtend(Customer customer, Long idBookInlistCustomer) {
        TrustServiceImpl trustService = new TrustServiceImpl(new TrustRepositoryImpl());
        Customer customer1 = repository1.loadById(customer.getId());
        LocalDate localDate = LocalDate.now();
        boolean b = false;
        Set<Trust> list = customer1.getList();
        for (Trust trust : list) {
            if (trust.getId() == idBookInlistCustomer) {
                if (trust.getStatusTrust() == StatusTrust.accept) {
                    if (localDate.isBefore(trust.getEndTime())) {
                        Trust trustTable = new Trust();
                        trustTable.setCustomer(customer);
                        trustTable.setBook(trust.getBook());
                        trustTable.setStatus(Status.ToExtend);
                        trustTable.setStartTime(trust.getEndTime());
                        trustService.save(trustTable);
                        System.out.println("The request was registered");
                        b = true;
                    } else {
                        System.out.println("--------------------------------");
                        System.out.println("It cannot be renewed because the date has expired");
                        System.out.println("--------------------------------");
                    }
                } else {
                    System.out.println("--------------------------------");
                    System.out.println("This request has not been approved yet");
                    System.out.println("--------------------------------");
                }
            }
        }
        if (b == false)
            System.out.println("Invalid request");
    }
}
