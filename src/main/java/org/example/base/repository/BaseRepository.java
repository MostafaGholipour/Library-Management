package org.example.base.repository;

import org.example.base.entity.BaseEntity;

import java.util.List;

public interface BaseRepository <E extends BaseEntity> {
    void save(E entity);
    void deleteById(long id);
    E loadById(long id);
    void update(E entity);
    List<E> loadAll();
}
