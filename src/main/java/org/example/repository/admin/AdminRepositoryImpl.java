package org.example.repository.admin;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.*;
import org.example.repository.book.BookRepositoryImpl;
import org.example.repository.customer.CustomerRepositoryImpl;
import org.example.repository.trust.TrustRepositoryImpl;
import org.example.service.book.BookServiceImpl;
import org.example.service.customer.CustomerServiceImpl;
import org.example.service.trust.TrustServiceImpl;
import org.example.util.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.List;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin> implements AdminRepository {
    @Override
    public Class getClassName() {
        return Admin.class;
    }

    @Override
    public void requestBorrow() {
        EntityManager entityManager = Hibernate.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jql = "SELECT m from Trust m where m.status=:S and m.statusTrust=:A";
        List<Trust> resultList = entityManager.createQuery(jql, Trust.class).setParameter("S", Status.Borrow).setParameter("A", StatusTrust.waiting).getResultList();
        resultList.forEach(System.out::println);
        transaction.commit();
    }

    @Override
    public void requestToExtend() {
        EntityManager entityManager = Hibernate.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jql = "SELECT m from Trust m where m.status=:S and m.statusTrust=:A";
        List<Trust> resultList = entityManager.createQuery(jql, Trust.class).setParameter("S", Status.ToExtend).setParameter("A", StatusTrust.waiting).getResultList();
        resultList.forEach(System.out::println);
        transaction.commit();
    }

    public void confirmBorrow(Admin admin, long trustId, StatusTrust statusTrust) {
        TrustServiceImpl trustService = new TrustServiceImpl(new TrustRepositoryImpl());
        Trust trust = trustService.loadById(trustId);
        if (trust == null) {
            System.out.println("not found ");
        } else {
            trust.setAdmin(admin);
            trust.setStatusTrust(statusTrust);
            trust.setStartTime(LocalDate.now());
            trust.getBook().setReady(false);
            //booservice.update (trust.getbook);
            trustService.update(trust);
            System.out.println("-------------------");
            System.out.println("Success!");
            System.out.println("-------------------");
        }
    }

    public void confirmToExtend(Admin admin, long trustId, StatusTrust statusTrust) {
        TrustServiceImpl trustService = new TrustServiceImpl(new TrustRepositoryImpl());
        Trust trust = trustService.loadById(trustId);
        if (trust == null) {
            System.out.println("not found ");
        } else {
            trust.setAdmin(admin);
            trust.setStatusTrust(statusTrust);
            trust.setStartTime(LocalDate.of(trust.getEndTime().getYear(), trust.getEndTime().getMonth(), trust.getEndTime().getDayOfMonth() + 7));
            trustService.update(trust);
            System.out.println("-------------------");
            System.out.println("Success!");
            System.out.println("-------------------");
        }
    }

    @Override
    public Admin login(long adminCode, String password) {
        EntityManager entityManager = Hibernate.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jql = "SELECT m from Admin m where m.username=:S";
        Admin admin = entityManager.createQuery(jql, Admin.class).setParameter("S", adminCode).getSingleResult();
        if (admin.getPassword().equals(password)) {
            System.out.println("Welcome----------" + admin.getName());
            return admin;
        } else {
            System.out.println("NOt Found !");
            return null;
        }
    }

    public List<Trust> searchTrust(long customerId, long bookId) {
        EntityManager entityManager = Hibernate.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jql = "SELECT m from Trust m where m.status=:S and m.statusTrust=:A";
        List<Trust> resultList = entityManager.createQuery(jql, Trust.class).setParameter("S", Status.ToExtend).setParameter("A", StatusTrust.accept).getResultList();
        resultList.forEach(System.out::println);
        transaction.commit();



        /*BookServiceImpl bookService = new BookServiceImpl(new BookRepositoryImpl());
        CustomerServiceImpl customerService= new CustomerServiceImpl(new CustomerRepositoryImpl());
        EntityManager entityManager= Hibernate.getEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        String jql="SELECT m from Trust m where m.customer=:S and m.book=:A";
        List resultList = entityManager.createQuery(jql, Trust.class).setParameter("S", 1L)
                .setParameter("A", 2L).getResultList();
        System.out.println(resultList);*/
        return null;
    }
}
