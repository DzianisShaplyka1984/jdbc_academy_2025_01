package com.academy.model.dao.impl;

import com.academy.model.dao.DefaultDao;
import com.academy.model.dao.TestDao;
import com.academy.model.entity.Test;

public class TestDaoImpl extends DefaultDaoImpl<Test, Integer> implements TestDao {
    public TestDaoImpl() {
        super(Test.class);
    }
}
