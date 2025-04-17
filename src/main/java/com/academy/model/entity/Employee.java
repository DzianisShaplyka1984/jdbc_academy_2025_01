package com.academy.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Immutable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Employee")
public class Employee extends ModifierOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column(name = "job")
    private String job;
    @Formula(value = "CONCAT(name, ' ', job)")
    private String nameJob;
    @Column(name = "dob")
    private Integer dob;
    @Column(name = "phone")
    private String employeePhone;
    @Column(updatable = false)
    private Integer salary;
    @Column
    private Integer account;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "loginId")
    private Login login;
    @OneToMany(mappedBy = "employee")
    private List<Address> addresses;
    @OneToMany(mappedBy = "employee")
    private List<EmployeeDepartment> departments;
    @Embedded
    private DocData docData;
}
