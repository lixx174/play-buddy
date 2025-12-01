package com.qinghaotech.domain.entity.game;

import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * @author Jinx
 */
@Getter
public class Game {

    private final Integer id;
    private final String name;
    private final String avatar;
    private final Status status;

    public Game(String name, String avatar) {
        this(null, name, avatar, Status.ENABLE);
    }

    public Game(Integer id, String name, String avatar, Status status) {
        Assert.hasText(name, "Game name is empty");
        Assert.hasText(avatar, "Game avatar is empty");
        Assert.notNull(status, "Game status is null");

        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.status = status;
    }

    public void assertEnabled() {
        if (status != Status.ENABLE) {
            throw new UnprocessableException("游戏[%s] 未启用".formatted(name));
        }
    }
}
