package org.example.base.service;

import org.example.base.entity.BaseEntity;
import org.example.base.repository.BaseRepositoryImpl;

import java.util.List;

public class BaseServiceImpl <E extends BaseEntity ,R extends BaseRepositoryImpl> implements BaseService<E> {
    private final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void save(E entity) {
        repository.save(entity);
    }

    @Override
    public void update(E entity) {
        repository.update(entity);
    }

    @Override
    public E loadById(long id) {
        return (E)repository.loadById(id);
    }

    /*@Override
    public void delete(E entity) {
        repository.deleteById(entity);
    }*/

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<E> LoadAll() {
        return repository.loadAll();
    }
}
