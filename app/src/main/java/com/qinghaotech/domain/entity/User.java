package com.qinghaotech.domain.entity;

import com.qinghaotech.domain.primitive.Credential;
import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * @author Jinx
 */
@Getter
public class User implements Entity {

    private Integer id;

    private String nickname;

    private String avatar;

    private Status status;

    private Account account;

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
