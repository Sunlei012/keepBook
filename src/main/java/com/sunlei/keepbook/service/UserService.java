package com.sunlei.keepbook.service;

import com.sunlei.keepbook.dto.User;
import com.sunlei.keepbook.util.AjaxJson;
import org.springframework.http.ResponseEntity;


public interface UserService {
    AjaxJson login(User user);

    AjaxJson register(User user);
}
