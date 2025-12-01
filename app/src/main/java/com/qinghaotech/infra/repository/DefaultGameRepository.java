package com.qinghaotech.infra.repository;

import com.qinghaotech.domain.entity.game.Game;
import com.qinghaotech.domain.repository.GameRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Jinx
 */
@Component
public class DefaultGameRepository implements GameRepository {


    @Override
    public Optional<Game> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void save(Game game) {

    }
}
