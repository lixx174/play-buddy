package com.qinghaotech.infra.repository;

import com.qinghaotech.domain.entity.role.Role;
import com.qinghaotech.domain.repository.RoleRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * @author Jinx
 */
@Component
public class DefaultRoleRepository implements RoleRepository {

    @Override
    public Optional<Role> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Collection<Role> findByIds(Set<Integer> integers) {
        return null;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public void remove(Role role) {

    }
}
