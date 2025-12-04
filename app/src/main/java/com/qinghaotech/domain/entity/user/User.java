package com.qinghaotech.domain.entity.user;

import com.qinghaotech.domain.entity.Entity;
import com.qinghaotech.domain.entity.account.Account;
import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.primitive.Credential;
import com.qinghaotech.domain.primitive.Gender;
import com.qinghaotech.domain.primitive.Status;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.function.Predicate;

/**
 * @author Jinx
 */
@Getter
public class User implements Entity {

    private final Integer id;

    private String nickname;

    private String avatar;

    private Gender gender;

    private final Status status;

    private final Account account;

    private Credential credential;

    @Builder
    private User(Integer id, String nickname, String avatar, Gender gender, Status status, Account account, Credential credential) {
        Assert.hasText(nickname, "nickname can't be empty");
        Assert.hasText(avatar, "avatar can't be empty");
        Assert.notNull(gender, "gender can't be null");
        Assert.notNull(status, "status can't be null");
        Assert.notNull(account, "account can't be null");
        if (id != null) {
            Assert.notNull(credential, "credential can't be null");
        }

        this.id = id;
        this.nickname = nickname;
        this.avatar = avatar;
        this.gender = gender;
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

    /***
     * 改名
     * @param nickname 新昵称
     * @param action 断言回调，判断该昵称是否存在。
     */
    public void rename(String nickname, Predicate<String> action) {
        if (StringUtils.hasText(nickname)) {
            if (action.test(nickname)) {
                throw new UnprocessableException("昵称:%s 已存在".formatted(nickname));
            }

            this.nickname = nickname;
        }
    }

    /**
     * 更换头像
     *
     * @param avatar 新头像
     * @param action 断言回调，判断该头像是否合法。
     */
    public void changeAvatar(String avatar, Predicate<String> action) {
        if (StringUtils.hasText(avatar)) {
            if (action.test(avatar)) {
                throw new UnprocessableException("头像:%s 不合法".formatted(nickname));
            }

            this.avatar = avatar;
        }
    }

    /**
     * 修改性别
     *
     * @param gender 新性别
     */
    public void changeGender(String gender) {
        if (StringUtils.hasText(gender)) {
            this.gender = Gender.valueOf(gender);
        }
    }

    public void assertEnabled() {
        if (status != Status.ENABLE) {
            throw new UnprocessableException("用户[%s] 未启用".formatted(nickname));
        }
    }
}
