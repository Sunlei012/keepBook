package com.sunlei.keepbook.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_", schema = "public")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String userName;

    private String password;

    private String name;


}
