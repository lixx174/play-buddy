package com.qinghaotech.application.model.dto;

import com.qinghaotech.domain.entity.Account;
import com.qinghaotech.domain.entity.Entity;
import com.qinghaotech.domain.primitive.Credential;
import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jinx
 */
@Getter
@Setter
public class UserDto implements Entity {

    private Integer id;

    private String nickname;

    private String avatar;

    private Status status;

    private Account account;

    private Credential credential;
}
