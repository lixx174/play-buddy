package com.qinghaotech.infra.repository;

import com.qinghaotech.domain.entity.companion.Companion;
import com.qinghaotech.domain.repository.CompanionRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * @author Jinx
 */
@Component
public class DefaultCompanionRepository implements CompanionRepository {
    @Override
    public Optional<Companion> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Collection<Companion> findByIds(Set<Integer> integers) {
        return null;
    }

    @Override
    public void save(Companion companion) {

    }

    @Override
    public void remove(Companion companion) {

    }
}
