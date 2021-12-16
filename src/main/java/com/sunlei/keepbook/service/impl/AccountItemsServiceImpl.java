package com.sunlei.keepbook.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.sunlei.keepbook.dao.AccountItemsDao;
import com.sunlei.keepbook.dto.Account;
import com.sunlei.keepbook.service.AccountItemsService;
import com.sunlei.keepbook.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountItemsServiceImpl implements AccountItemsService {
    private AccountItemsDao accountItemsDao;

    @Autowired
    public void setAccountItemsDao(AccountItemsDao accountItemsDao){
        this.accountItemsDao = accountItemsDao;
    }

    @Override
    public AjaxJson insertOneAccount(Account account) {
        account.setId(UUID.randomUUID().toString());
        account.setUserId(StpUtil.getLoginId().toString());
        return AjaxJson.getSuccess("Insert Success",accountItemsDao.save(account));
    }

    @Override
    public AjaxJson getAllAccount() {
        return AjaxJson.getSuccess("Query Success",accountItemsDao.findAllByUserId(StpUtil.getLoginId().toString()));
    }
}
