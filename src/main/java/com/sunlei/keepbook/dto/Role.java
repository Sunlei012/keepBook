package com.sunlei.keepbook.dto;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "role", schema = "public")
public class Role {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String role;

    private String userId;

    public Role(String id, String role, String userId) {
        this.id = id;
        this.role = role;
        this.userId = userId;
    }

    public Role() {

    }
}
