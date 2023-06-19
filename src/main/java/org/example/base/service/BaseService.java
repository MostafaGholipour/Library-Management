package org.example.base.service;

import org.example.base.entity.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity> {
    void save(E entity);
    void update(E entity);
    E loadById(long id);
    void deleteById(long id);
    List<E> LoadAll();
}
