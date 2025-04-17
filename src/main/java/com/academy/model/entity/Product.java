package com.academy.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product extends ModifierOptions {
    @EmbeddedId
    private ProductId id;
    private Integer price;
}
