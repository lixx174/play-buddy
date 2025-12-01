package com.qinghaotech.domain.entity.companion;

import com.qinghaotech.domain.entity.game.Game;
import com.qinghaotech.domain.entity.user.User;
import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;

import java.util.List;

/**
 * @author Jinx
 */
@Getter
public class Companion {

    private Integer id;

    /**
     * 持有系统user引用，陪玩师的基本信息使用user的基本信息。
     */
    private User user;

    /**
     * 陪玩师的账号状态不会影响到关联user的状态，但是user会影响到陪玩师。
     */
    private Status status;

    private CompanionStarLevel starLevel;
    private List<CompanionTag> tags;
    private List<Integer> gameIds;

    public void assertEnabled() {
        user.assertEnabled();
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
        return user.getNickname();
    }
}
