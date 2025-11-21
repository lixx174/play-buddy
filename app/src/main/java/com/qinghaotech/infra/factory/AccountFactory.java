package com.qinghaotech.infra.factory;

import com.qinghaotech.domain.entity.Account;
import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.factory.EntityFactory;
import com.qinghaotech.domain.primitive.Applet;
import com.qinghaotech.domain.primitive.Status;
import com.qinghaotech.domain.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author Jinx
 */
@Component
@RequiredArgsConstructor
public class AccountFactory implements EntityFactory<Account> {

    private final AccountRepository accountRepo;

    @Override
    public Account create(Object source, Consumer<Account> callback) {
        if (source == null) {
            throw new UnprocessableException("Parameter source can't be null");
        }

        Account account = switch (source) {
            case Applet applet -> createByApplet(applet);
            default -> throw new UnprocessableException("Type {%s} not support".formatted(source.getClass()));
        };

        callback.accept(account);

        return account;
    }

    private Account createByApplet(Applet applet) {
        long count = accountRepo.findCount();
        return new Account(
                "微信用户_%010d".formatted(count),
                "https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132",
                Status.ENABLE,
                applet
        );
    }
}
