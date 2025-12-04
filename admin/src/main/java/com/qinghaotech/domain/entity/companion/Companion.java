package com.qinghaotech.domain.entity.companion;

import com.qinghaotech.domain.Entity;
import com.qinghaotech.domain.entity.game.Game;
import com.qinghaotech.domain.entity.user.WechatUser;
import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.primitive.Status;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Jinx
 */
@Getter
public class Companion implements Entity {

    private final Integer id;

    /**
     * 持有小程序user引用，陪玩师的基本信息使用user的基本信息。
     */
    private final WechatUser wechatUser;
    /**
     * 陪玩师的账号状态不会影响到关联user的状态，但是user会影响到陪玩师。
     */
    private Status status;

    private CompanionStarLevel starLevel;
    private Collection<Integer> gameIds;

    @Builder
    public Companion(Integer id, WechatUser wechatUser, Status status, CompanionStarLevel starLevel, Collection<Integer> gameIds) {
        Assert.notNull(wechatUser, "微信小程序用户为null");
        Assert.notNull(status, "陪玩状态为null");
        Assert.notNull(starLevel, "陪玩星级为null");
        Assert.notNull(gameIds, "陪玩支持游戏为null");

        this.id = id;
        this.wechatUser = wechatUser;
        this.status = status;
        this.starLevel = starLevel;
        this.gameIds = gameIds;
    }

    public void assertEnabled() {
        wechatUser.assertEnabled();
        if (status != Status.ENABLE) {
            String companionName = getName();
            throw new UnprocessableException("陪玩师[%s] 未启用".formatted(companionName));
        }
    }

    public void assertSupport(Game game) {
        if (!gameIds.contains(game.getId())) {
            String companionName = getName();
            throw new UnprocessableException("陪玩师[%s] 不支持该游戏[%s]".formatted(companionName, game.getName()));
        }
    }

    public String getName() {
        return wechatUser.getNickname();
    }

    public void changeStatus(String status) {
        if (status != null) {
            this.status = Status.valueOf(status);
        }
    }

    public void changeStarLevel(Float starLevel) {
        if (starLevel != null) {
            this.starLevel = new CompanionStarLevel(starLevel);
        }
    }

    public void changeGames(Collection<Game> games) {
        this.gameIds = games.stream()
                .peek(Game::assertEnabled)
                .map(Game::getId)
                .collect(Collectors.toSet());
    }
}
