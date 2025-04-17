package com.academy.model.dao.impl;

import com.academy.model.DataSource;
import com.academy.model.dao.AddressDao;
import com.academy.model.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class AddressDaoImpl extends DefaultDaoImpl<Address, Integer> implements AddressDao {
    public AddressDaoImpl() {
        super(Address.class);
    }

    public List<Address> findAll() {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();
        Query query = entityManager.createQuery("from Address");

        return query.getResultList();
    }
}
