package com.academy.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DocData {
    private String docType;
    private String docId;
    private String issueDate;
}
