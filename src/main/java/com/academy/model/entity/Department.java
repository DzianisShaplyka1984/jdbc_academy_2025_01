package com.academy.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Department extends ModifierOptions {
    @Id
    private Integer id;
    private String name;
    private String address;
}
