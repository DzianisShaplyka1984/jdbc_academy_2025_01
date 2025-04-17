package com.academy.model.dao.impl;

import com.academy.model.dao.DefaultDao;
import com.academy.model.dao.ProductDao;
import com.academy.model.entity.Product;

public class ProductDaoImpl extends DefaultDaoImpl<Product, Integer> implements ProductDao {
    public ProductDaoImpl() {
        super(Product.class);
    }
}
