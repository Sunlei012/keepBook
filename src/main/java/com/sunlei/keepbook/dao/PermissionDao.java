package com.sunlei.keepbook.dao;

import com.sunlei.keepbook.dto.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PermissionDao extends JpaRepository<Permission,String> {

    List<Permission> findAllByRole(String roleId);
}
