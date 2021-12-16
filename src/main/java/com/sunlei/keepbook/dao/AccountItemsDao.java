package com.sunlei.keepbook.dao;

import com.sunlei.keepbook.dto.Account;
import com.sunlei.keepbook.dto.AccountItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface AccountItemsDao extends JpaRepository<Account, String> {

    List<Account> findAllByUserId(String userId);
}
