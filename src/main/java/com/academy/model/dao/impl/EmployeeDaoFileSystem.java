package com.academy.model.dao.impl;

import com.academy.model.dao.EmployeeDao;
import com.academy.model.entity.Employee;
import java.util.List;

public class EmployeeDaoFileSystem implements EmployeeDao {
    @Override
    public void save(Employee employee) {
        System.out.println("Write data to file");

    }

    @Override
    public void delete(Employee employee) {
        System.out.println("Write data to file");
    }

    @Override
    public List<Employee> findAll() {
        System.out.println("Read data from file");

        return List.of();
    }

    @Override
    public Employee findById(Integer id) {
        System.out.println("Read data from file");
        return null;
    }

    @Override
    public List<Employee> findByName(String name) {
        System.out.println("Read data from file");
        return List.of();
    }
}
