package com.qinghaotech.domain.entity.account;

import com.qinghaotech.domain.entity.Entity;
import com.qinghaotech.domain.primitive.Applet;
import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * FIXME 注意小程序选不同手机号登录场景
 *
 * @author Jinx
 */
@Getter
public class Account implements Entity {

    private final Integer id;

    private final Applet applet;

    private Status status;

    public Account(Applet applet) {
        this(null, applet, Status.ENABLE);
    }

    public Account(Integer id, Applet applet, Status status) {
        Assert.notNull(applet, "applet cannot be null");
        Assert.notNull(status, "status cannot be null");

        this.id = id;
        this.applet = applet;
        this.status = status;
    }

    public void changesStatus(Status status) {
        this.status = status;
    }
}
