package com.sunlei.keepbook.dao;

import com.sunlei.keepbook.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User findAllByUserName(String userName);
}
