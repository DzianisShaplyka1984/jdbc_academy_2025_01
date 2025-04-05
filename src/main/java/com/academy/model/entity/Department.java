package com.academy.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Department {
    @Id
    private Integer id;
    private String name;
    private String address;
    @ManyToMany
    private List<Employee> employees;
}
