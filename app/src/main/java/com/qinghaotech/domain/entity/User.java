package com.qinghaotech.domain.entity;

import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.primitive.Credential;
import com.qinghaotech.domain.primitive.Status;
import com.qinghaotech.domain.service.UserDomainService;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * @author Jinx
 */
@Getter
public class User implements Entity {

    private final Integer id;

    private String nickname;

    private String avatar;

    private final Status status;

    private final Account account;

    private Credential credential;

    private User(Builder builder) {
        id = builder.id;
        nickname = builder.nickname;
        avatar = builder.avatar;
        status = builder.status;
        account = builder.account;
        credential = builder.credential;
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

    /***
     * 改名
     * @param nickname 新昵称
     * @param service 领域服务
     */
    public void rename(String nickname, UserDomainService service) {
        Assert.hasText(nickname, "nickname cannot be empty");
        if (service.isNicknameExisted(nickname)) {
            throw new UnprocessableException("Input nickname [%s] already existed".formatted(nickname));
        }

        // FIXME 昵称合法性校验
        this.nickname = nickname;
    }

    /**
     * 更换头像
     *
     * @param avatar  新头像
     * @param service 领域服务
     */
    public void changeAvatar(String avatar, UserDomainService service) {
        Assert.hasText(avatar, "avatar cannot be empty");

        // FIXME 色图校验
        this.avatar = avatar;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Integer id;
        private String nickname;
        private String avatar;
        private Status status;
        private Account account;
        private Credential credential;

        private Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder nickname(String nickname) {
            Assert.hasText(nickname, "nickname can't be empty");
            this.nickname = nickname;
            return this;
        }

        public Builder avatar(String avatar) {
            Assert.hasText(avatar, "avatar can't be empty");
            this.avatar = avatar;
            return this;
        }


        public Builder status(Status status) {
            Assert.notNull(status, "status can't be null");
            this.status = status;
            return this;
        }

        public Builder account(Account account) {
            Assert.notNull(account, "account can't be null");
            this.account = account;
            return this;
        }

        public Builder credential(Credential credential) {
            this.credential = credential;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
