package com.qinghaotech.application.service;

import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.ApplyCompanionCommand;
import com.qinghaotech.application.model.dto.CompanionDto;
import com.qinghaotech.application.model.dto.CompanionPageDto;
import com.qinghaotech.application.repository.CompanionQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class CompanionService {

    private final CompanionQueryRepository companionQueryRepository;


    public PageReply<CompanionPageDto> page(PageQuery query) {
        return PageReply.of(companionQueryRepository.findAll(query));
    }

    public CompanionDto detail(Integer id) {
        return companionQueryRepository.findById(id);
    }

    public void apply(ApplyCompanionCommand command) {

    }
}
