package com.academy.model.dao;

import com.academy.model.entity.Employee;
import com.academy.model.entity.Login;
import java.util.List;

public interface EmployeeDao extends DefaultDao<Employee, Integer> {
    List<Employee> findByName(String name);
    List<String> getNames();
    List<Employee> getNameAndSalary();
    List<String> getLogins();
    List<Employee> getSalary(Integer salary);
    List<Object> getSalaryByJobs();
    void updateSalary(Integer id, Integer salary);
    void deleteEmployee(Integer id);
    void createEmployee(String name, Integer salary);
}
