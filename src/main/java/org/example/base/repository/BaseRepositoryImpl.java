package org.example.base.repository;

import org.example.base.entity.BaseEntity;
import org.example.util.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity> implements BaseRepository<E>{
public abstract Class getClassName();
    @Override
    public void save(E entity) {
        EntityTransaction transaction = null;
        EntityManager entityManager = null;
        try {
            entityManager = Hibernate.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
   /* @Override
    public void deleteById(long id); {
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = Hibernate.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(entity);
            //entityManager.createQuery("delete from "+getClassName().getSimpleName()+" where id=:x").setParameter("x",entity.getId()).executeUpdate();
                        transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }*/

    @Override
    public void deleteById(long id) {
        E x = loadById(id);
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = Hibernate.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(x);
            //entityManager.createQuery("delete from"+getClassName().getSimpleName()+" where id="+"'"+id+"'").executeUpdate();
            //entityManager.createQuery("delete from "+getClassName().getSimpleName()+" where id=:x").setParameter("x",entity.getId()).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public E loadById(long id) {
        EntityManager entityManager= Hibernate.getEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        E e=(E)entityManager.find(getClassName(),id);
        transaction.commit();
        return e;
    }

    @Override
    public void update(E entity) {
        EntityTransaction transaction = null;
        EntityManager entityManager = null;
        try {
            entityManager = Hibernate.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public List<E> loadAll() {
        EntityManager entityManager= Hibernate.getEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        List resultList = entityManager.createQuery("from " + getClassName().getSimpleName(),getClassName())
                .getResultList();
       /* for(int i=0;i< resultList.size();i++){
            System.out.println(resultList.get(i));
        }*/
//        System.out.println(resultList);
        return resultList;
    }

}
