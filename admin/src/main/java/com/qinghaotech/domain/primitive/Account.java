package com.qinghaotech.domain.primitive;

import org.springframework.util.Assert;

/**
 * 后台账号
 *
 * @author Jinx
 */
public record Account(String username, String password) {

    public Account {
        Assert.hasText(username, "username 为空");
        Assert.hasText(password, "password 为空");

        // TODO 密码加密？
    }
}
