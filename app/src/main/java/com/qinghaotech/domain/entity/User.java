package com.qinghaotech.domain.entity;

import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.primitive.Credential;
import com.qinghaotech.domain.primitive.Gender;
import com.qinghaotech.domain.primitive.Status;
import com.qinghaotech.domain.service.UserDomainService;
import lombok.Builder;
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

    /**
     * 修改性别
     *
     * @param gender 新性别
     */
    public void changeGender(Gender gender) {
        Assert.notNull(gender, "gender cannot be null");
        Assert.isTrue(gender != Gender.UNKNOWN, "gender cannot be UNKNOWN");

        this.gender = gender;
    }
}
