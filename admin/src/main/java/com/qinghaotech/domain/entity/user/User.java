package com.qinghaotech.domain.entity.user;

import com.qinghaotech.domain.Entity;
import com.qinghaotech.domain.entity.account.Account;
import com.qinghaotech.domain.entity.role.Role;
import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.primitive.Credential;
import com.qinghaotech.domain.primitive.Status;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * @author Jinx
 */
@Getter
public class User implements Entity {

    private final Integer id;
    private final String name;
    private final String avatar;
    private final Status status;
    private final Account account;
    private Collection<Role> roles;
    private Credential credential;

    @Builder
    private User(Integer id, String name, String avatar, Status status, Account account, Credential credential) {
        Assert.hasText(name, "name can't be empty");
        Assert.hasText(avatar, "avatar can't be empty");
        Assert.notNull(status, "status can't be null");
        Assert.notNull(account, "account can't be null");
        if (id != null) {
            Assert.notNull(credential, "credential can't be null");
        }

        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.status = status;
        this.account = account;
        this.credential = credential;
    }


    /**
     * 颁发凭证
     *
     * @param credential 凭证信息
     */
    public void issueCredential(Credential credential) {
        Assert.notNull(credential, "Credential cannot be null");
        this.credential = credential;
    }


    public void assertEnabled() {
        if (!isEnable()) {
            throw new UnprocessableException("用户[%s] 未启用".formatted(name));
        }
    }

    public boolean isEnable() {
        return status == Status.ENABLE;
    }

    public boolean isForbidden() {
        return status == Status.FORBIDDEN;
    }

    public String getUsername() {
        return account.getUsername();
    }

    public String getPassword() {
        return account.getPassword();
    }
}
