package com.academy.model.dao.impl;

import com.academy.model.DataSource;
import com.academy.model.dao.DefaultDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;

public class DefaultDaoImpl<T> implements DefaultDao<T> {
    private Class<T> type;

    public DefaultDaoImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public void save(T entity) {
//        EntityManager entityManager = DataSource.getInstance().getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(entity);
//        entityManager.getTransaction().commit();

        Session session = DataSource.getInstance().getEntityManager().unwrap(Session.class);
        session.beginTransaction();

        session.saveOrUpdate(entity);

        session.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entity);

        entityManager.getTransaction().commit();
    }

    @Override
    public List<T> findAll() {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();

        Query query = entityManager.createQuery("from " + type.getTypeName());

        return query.getResultList();
    }

    @Override
    public T findById(Integer id) {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();

        return entityManager.find(type, id);
    }
}
