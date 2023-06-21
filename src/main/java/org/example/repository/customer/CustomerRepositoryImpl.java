package org.example.repository.customer;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.Book;
import org.example.entity.Customer;
import org.example.entity.Trust;
import org.example.repository.book.BookRepositoryImpl;
import org.example.repository.trust.TrustRepositoryImpl;
import org.example.service.book.BookServiceImpl;
import org.example.service.trust.TrustServiceImpl;
import org.example.util.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository{
    @Override
    public Class getClassName() {
        return Customer.class;
    }

    @Override
    public Customer login(long customerCode, long nationalCode) {
        EntityManager entityManager= Hibernate.getEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        String jql="SELECT m from Customer m where m.customerCode=:S";
        Customer resultList = entityManager.createQuery(jql, Customer.class)
                .setParameter("S", customerCode)
                .getSingleResult();
        if (resultList.getNationalCode()==nationalCode){
            System.out.println("--------------------------------");
            System.out.println("Welcome  "+resultList.getName());
            System.out.println("--------------------------------");
             Customer customer= resultList;
             return  customer;
        }
        else{
            System.out.println("Not Fount");
        return null;}
    }
}
