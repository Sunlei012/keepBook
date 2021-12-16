package com.sunlei.keepbook;

import com.sunlei.keepbook.dao.AccountItemsDao;
import com.sunlei.keepbook.dto.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KeepBookApplicationTests {

	@Autowired
	AccountItemsDao accountItemsDao;

	@Test
	void contextLoads() {
		List<Account> all = accountItemsDao.findAll();
		System.out.println(all);
	}

}
