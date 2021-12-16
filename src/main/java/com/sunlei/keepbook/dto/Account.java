package com.sunlei.keepbook.dto;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Data
@Entity
@Table(schema = "public",name = "account")
public class Account {
  @Id
  @Column(name = "id", nullable = false)
  private String id;

  private String amount;
  private long classify;
  private String productName;
  private long accountInfo;
  @CreationTimestamp
  private java.sql.Date date;
  private String timeAmount;
  private String bigAmount;
  private String userId;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Account account = (Account) o;
    return id != null && Objects.equals(id, account.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
