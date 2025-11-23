package com.qinghaotech.infra.factory;

import com.qinghaotech.domain.entity.Account;
import com.qinghaotech.domain.entity.User;
import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.factory.EntityFactory;
import com.qinghaotech.domain.primitive.Applet;
import com.qinghaotech.domain.primitive.Status;
import com.qinghaotech.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author Jinx
 */
@Component
@RequiredArgsConstructor
public class UserFactory implements EntityFactory<User> {

    private final UserRepository repo;

    @Override
    public User create(Object source, Consumer<User> callback) {
        if (source == null) {
            throw new UnprocessableException("Parameter source can't be null");
        }

        User user = switch (source) {
            case Applet applet -> createByApplet(applet);
            default -> throw new UnprocessableException("Type {%s} not support".formatted(source.getClass()));
        };

        callback.accept(user);

        return user;
    }

    private User createByApplet(Applet applet) {
        long count = repo.findCount();
        Account account = new Account(applet);

        return User.builder()
                .nickname("微信用户_%010d".formatted(count))
                .avatar("https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132")
                .status(Status.ENABLE)
                .account(account)
                .build();
    }
}
