package org.example.repository.bookGroups;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.BookGroups;
import org.example.util.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BookGroupsRepositoryImpl extends BaseRepositoryImpl<BookGroups> implements BookGroupsRepository {
    @Override
    public Class getClassName() {
        return BookGroups.class;
    }

    @Override
    public List<BookGroups> findAtLeast() {
        EntityManager entityManager= Hibernate.getEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        String jql="SELECT m from BookGroups m where m.books.size>0";
        List<BookGroups> resultList = entityManager.createQuery(jql, BookGroups.class).getResultList();
        return resultList;
    }
}
