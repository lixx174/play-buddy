package com.qinghaotech.infra.repository;

import com.qinghaotech.domain.entity.user.User;
import com.qinghaotech.domain.repository.UserRepository;
import com.qinghaotech.domain.repository.query.CredentialQuery;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * @author Jinx
 */
@Component
public class DefaultUserRepository implements UserRepository {

    @Override
    public Optional<User> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Collection<User> findByIds(Set<Integer> integers) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public long findCount() {
        return 0;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByCredential(CredentialQuery credential) {
        return Optional.empty();
    }
}
