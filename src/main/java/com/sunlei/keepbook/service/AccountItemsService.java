package com.sunlei.keepbook.service;

import com.sunlei.keepbook.dto.Account;
import com.sunlei.keepbook.util.AjaxJson;

import java.util.List;

public interface AccountItemsService {
    AjaxJson insertOneAccount(Account account);

    AjaxJson getAllAccount();
}
