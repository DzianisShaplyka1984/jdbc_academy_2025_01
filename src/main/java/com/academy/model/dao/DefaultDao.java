package com.academy.model.dao;

import java.util.List;

public interface DefaultDao<T, ID> {
    void save(T entity);
    void delete(T entity);
    List<T> findAll();
    T findById(ID id);
}
