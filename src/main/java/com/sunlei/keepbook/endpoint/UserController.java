package com.sunlei.keepbook.endpoint;

import cn.dev33.satoken.stp.StpUtil;
import com.sunlei.keepbook.dto.User;
import com.sunlei.keepbook.service.UserService;
import com.sunlei.keepbook.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public AjaxJson login(@RequestBody User user){
        AjaxJson login = userService.login(user);
        boolean login1 = StpUtil.isLogin();
        boolean b = StpUtil.hasPermission("user-update");
        String tokenValue = StpUtil.getTokenValue();
        return login;
    }

    @PostMapping("/register")
    public AjaxJson register(@RequestBody User user){
        return userService.register(user);
    }
}
