package com.sunlei.keepbook.endpoint;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.sunlei.keepbook.dto.Account;
import com.sunlei.keepbook.dto.AccountItem;
import com.sunlei.keepbook.service.AccountItemsService;
import com.sunlei.keepbook.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class AccountItemsController {
    private AccountItemsService accountItemsService;

    @Autowired
    public void setAccountItemsService(AccountItemsService accountItemsService){
        this.accountItemsService=accountItemsService;
    }

    @SaCheckRole("defaultUser")
    @PostMapping("/accountItem")
    public AjaxJson addOneAccountItem(@RequestBody Account account){
        return accountItemsService.insertOneAccount(account);
    }

    @SaCheckRole("defaultUser")
    @GetMapping("/accountItem")
    public AccountItem queryOneAccountItem(){
        return new AccountItem("1","");
    }

    @GetMapping("/accountItems")
    @SaCheckRole("defaultUser")
    public AjaxJson queryAllAccountItems(){
        return accountItemsService.getAllAccount();
    }
}
