package com.academy.model.dao;

import java.util.List;

public interface DefaultDao<T> {
    void save(T entity);
    void delete(T entity);
    List<T> findAll();
    T findById(Integer id);
}
