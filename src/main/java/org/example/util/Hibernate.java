package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernate {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY=
            Persistence.createEntityManagerFactory("jpa");

    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }
    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
