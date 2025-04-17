package com.academy.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Embeddable
public class ProductId {
    private String name;
    private String brand;
}
