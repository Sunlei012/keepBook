package com.sunlei.keepbook.config;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.SaSessionCustomUtil;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.sunlei.keepbook.dao.PermissionDao;
import com.sunlei.keepbook.dao.RoleDao;
import com.sunlei.keepbook.dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
    PermissionDao permissionDao;

    RoleDao roleDao;

    @Override
    public List<String> getPermissionList(Object o, String s) {

        // 1. 声明权限码集合
        List<String> permissionList = new ArrayList<>();

        // 2. 遍历角色列表，查询拥有的权限码
        for (String roleId : getRoleList(o.toString(), s)) {
            SaSession roleSession = SaSessionCustomUtil.getSessionById("role-" + roleId);
            List<String> list = roleSession.get("Permission_List",() -> permissionDao.findAllByRole(roleId));
            permissionList.addAll(list);
        }
        return permissionList;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        SaSession session = StpUtil.getSessionByLoginId(o.toString());
        return session.get("Role_List", () ->
             roleDao.findAllByUserId(o.toString()).stream().map(Role::getRole).toList());
    }

    @Autowired
    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
