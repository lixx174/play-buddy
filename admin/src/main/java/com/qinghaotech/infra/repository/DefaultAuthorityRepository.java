package com.qinghaotech.infra.repository;

import com.qinghaotech.domain.entity.authority.Authority;
import com.qinghaotech.domain.repository.AuthorityRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * @author Jinx
 */
@Component
public class DefaultAuthorityRepository implements AuthorityRepository {
    @Override
    public Optional<Authority> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Authority> findByPermission(String permission) {
        return Optional.empty();
    }

    @Override
    public Collection<Authority> findByPid(Integer pid) {
        return null;
    }

    @Override
    public Collection<Authority> findByIds(Set<Integer> ids) {
        return null;
    }

    @Override
    public Optional<Authority> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void save(Authority authority) {

    }

    @Override
    public void remove(Authority authority) {

    }
}
