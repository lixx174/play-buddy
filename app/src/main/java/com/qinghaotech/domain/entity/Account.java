package com.qinghaotech.domain.entity;

import com.qinghaotech.domain.primitive.Applet;
import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;

/**
 * @author Jinx
 */
@Getter
public class Account implements Entity{

    private Integer id;

    private String mobile;

    private String username;

    private String password;

    private String nickname;

    private String avatar;

    private Status status;

    private Applet applet;

    public Account(String nickname, String avatar, Status status, Applet applet) {
        this.nickname = nickname;
        this.avatar = avatar;
        this.status = status;
        this.applet = applet;
    }
}
