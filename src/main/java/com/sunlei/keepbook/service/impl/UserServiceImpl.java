package com.sunlei.keepbook.service.impl;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.sunlei.keepbook.dao.RoleDao;
import com.sunlei.keepbook.dao.UserDao;
import com.sunlei.keepbook.dto.Role;
import com.sunlei.keepbook.dto.User;
import com.sunlei.keepbook.service.UserService;
import com.sunlei.keepbook.util.AjaxJson;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public AjaxJson login(User user) {

        User findUser = userDao.findAllByUserName(user.getUserName());

        if (findUser != null) {
            if (SaSecureUtil.md5BySalt(user.getPassword(),"abc").equals(findUser.getPassword())){
                findUser.setPassword(null);
                StpUtil.login(findUser.getId());
                return AjaxJson.getSuccess("Login Success",StpUtil.getTokenValue());
            }
        }
        throw new NotLoginException("用户名或密码不正确","1","1");

    }

    @Transactional
    @Override
    public AjaxJson register(User user) {
        if (userDao.findAllByUserName(user.getUserName()) == null) {
            if (user.getId() == null)
                user.setId(UUID.randomUUID().toString());
            user.setPassword(SaSecureUtil.md5BySalt(user.getPassword(), "abc"));
            User save = userDao.save(user);
            save.setPassword(null);
            roleDao.save(new Role(UUID.randomUUID().toString(),"defaultUser",user.getId()));
            return AjaxJson.getSuccess("Register Success",save);
        }
        return AjaxJson.getError("Register Field");
    }

}
