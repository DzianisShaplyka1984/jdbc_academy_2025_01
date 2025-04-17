package com.academy.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Address extends ModifierOptions{
    @Id
    private Integer id;
    private String city;
    private String street;
    private String bulding;
    private String appartment;
    @ManyToOne
    @JoinColumn(name="employeeId")
    @ToString.Exclude private Employee employee;
}
