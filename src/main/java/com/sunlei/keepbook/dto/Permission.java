package com.sunlei.keepbook.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "permission", schema = "public")
public class Permission {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String permission;

    private String role;

}
