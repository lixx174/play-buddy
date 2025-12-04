package com.qinghaotech.infra.factory;

import com.qinghaotech.application.model.command.CreateCompanionCommand;
import com.qinghaotech.domain.entity.companion.Companion;
import com.qinghaotech.domain.entity.companion.CompanionStarLevel;
import com.qinghaotech.domain.entity.game.Game;
import com.qinghaotech.domain.entity.user.WechatUser;
import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.factory.EntityFactory;
import com.qinghaotech.domain.primitive.Status;
import com.qinghaotech.domain.repository.GameRepository;
import com.qinghaotech.domain.repository.WechatUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author Jinx
 */
@Component
@RequiredArgsConstructor
public class CompanionFactory implements EntityFactory<Companion> {

    private final WechatUserRepository wechatUserRepository;
    private final GameRepository gameRepository;

    @Override
    public Companion create(@NonNull Object source, Consumer<Companion> callback) {
        return switch (source) {
            case CreateCompanionCommand command -> doCreate(command, callback);
            default -> throw new UnprocessableException("不支持的类型: %s".formatted(source.getClass().getName()));
        };
    }

    private Companion doCreate(CreateCompanionCommand source, Consumer<Companion> callback) {
        CompanionStarLevel starLevel = new CompanionStarLevel(source.getStarLevel());

        WechatUser wechatUser = wechatUserRepository.findByIdOrElseThrow(source.getWechatUserId());
        wechatUser.assertEnabled();

        Collection<Game> games = gameRepository.findByIds(source.getGameIds());
        Assert.isTrue(games.size() == source.getGameIds().size(), "有游戏不存在");

        Set<Integer> gameIds = games.stream()
                .peek(Game::assertEnabled)
                .map(Game::getId)
                .collect(Collectors.toSet());

        Companion companion = Companion.builder()
                .wechatUser(wechatUser)
                .status(Status.ENABLE)
                .starLevel(starLevel)
                .gameIds(gameIds)
                .build();

        callback.accept(companion);

        return companion;
    }
}
