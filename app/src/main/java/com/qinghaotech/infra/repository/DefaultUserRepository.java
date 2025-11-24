package com.qinghaotech.infra.repository;

import com.qinghaotech.domain.entity.User;
import com.qinghaotech.domain.repository.AppletQuery;
import com.qinghaotech.domain.repository.CredentialQuery;
import com.qinghaotech.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Jinx
 */
@Component
public class DefaultUserRepository implements UserRepository {

    @Override
    public long findCount() {
        return 0;
    }

    @Override
    public Optional<User> findByApplet(AppletQuery applet) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByCredential(CredentialQuery credential) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }
}
