package com.qinghaotech.domain.entity.account;

import com.qinghaotech.domain.Entity;
import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * @author Jinx
 */
@Getter
public class Account implements Entity {

    private final Integer id;
    private final String username;
    private final String password;
    private Status status;

    public Account(String username, String password) {
        this(null, username, password, Status.ENABLE.name());
    }

    public Account(Integer id, String username, String password, String status) {
        Assert.notNull(username, "username为空");
        Assert.notNull(password, "password为空");
        Assert.notNull(status, "status为空");

        this.id = id;
        this.username = username;
        this.password = password;
        this.status = Status.valueOf(status);
    }

    public void changesStatus(String status) {
        if (status != null) {
            this.status = Status.valueOf(status);
        }
    }
}
