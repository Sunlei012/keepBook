package com.sunlei.keepbook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AccountItem {
    public AccountItem(String id,String name) {
        this.id = id;
        this.name = name;
    }

    String id;
    String name;
}
