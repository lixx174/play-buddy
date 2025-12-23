package com.qinghaotech.application.service;

import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.CreateCompanionCommand;
import com.qinghaotech.application.model.command.ModifyCompanionCommand;
import com.qinghaotech.application.model.dto.CompanionDto;
import com.qinghaotech.application.model.dto.CompanionPageDto;
import com.qinghaotech.application.repository.CompanionQueryRepository;
import com.qinghaotech.domain.entity.companion.Companion;
import com.qinghaotech.domain.entity.game.Game;
import com.qinghaotech.domain.factory.EntityFactory;
import com.qinghaotech.domain.repository.CompanionRepository;
import com.qinghaotech.domain.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class CompanionService {

    private final CompanionQueryRepository companionQueryRepository;
    private final GameRepository gameRepository;
    private final CompanionRepository companionRepository;
    private final EntityFactory<Companion> entityFactory;


    public PageReply<CompanionPageDto> page(PageQuery query) {
        return companionQueryRepository.findAll(query);
    }

    public CompanionDto detail(Integer id) {
        return companionQueryRepository.findById(id);
    }

    public void create(CreateCompanionCommand command) {
        Companion companion = entityFactory.create(command);
        companionRepository.save(companion);
    }

    public void modify(ModifyCompanionCommand command) {
        Companion companion = companionRepository.findByIdOrElseThrow(command.getId());
        Collection<Game> games = gameRepository.findByIdsOrElseThrow(command.getGameIds());

        companion.changeStatus(command.getStatus());
        companion.changeStarLevel(command.getStarLevel());
        companion.changeGames(games);

        companionRepository.save(companion);
    }
}
