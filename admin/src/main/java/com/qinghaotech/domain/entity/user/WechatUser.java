package com.qinghaotech.domain.entity.user;

import com.qinghaotech.domain.Entity;
import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.primitive.Gender;
import com.qinghaotech.domain.primitive.Status;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * @author Jinx
 */
@Getter
public class WechatUser implements Entity {

    private final Integer id;
    private final String nickname;
    private final String avatar;
    private Gender gender;
    private final Status status;

    @Builder
    private WechatUser(Integer id, String nickname, String avatar, Gender gender, Status status) {
        Assert.hasText(nickname, "nickname can't be empty");
        Assert.hasText(avatar, "avatar can't be empty");
        Assert.notNull(gender, "gender can't be null");
        Assert.notNull(status, "status can't be null");

        this.id = id;
        this.nickname = nickname;
        this.avatar = avatar;
        this.gender = gender;
        this.status = status;
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

    public void assertEnabled() {
        if (status != Status.ENABLE) {
            throw new UnprocessableException("用户[%s] 未启用".formatted(nickname));
        }
    }
}
