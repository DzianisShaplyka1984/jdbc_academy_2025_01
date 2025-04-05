package com.academy.model.dao;

import com.academy.model.entity.Employee;
import java.util.List;

public interface EmployeeDao extends DefaultDao<Employee> {
    List<Employee> findByName(String name);
}
