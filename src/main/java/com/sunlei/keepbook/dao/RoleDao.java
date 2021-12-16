package com.sunlei.keepbook.dao;

import com.sunlei.keepbook.dto.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface RoleDao extends JpaRepository<Role,String> {

    List<Role> findAllByUserId(String userId);
}
