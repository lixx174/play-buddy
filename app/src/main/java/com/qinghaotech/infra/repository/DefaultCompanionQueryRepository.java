package com.qinghaotech.infra.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.dto.CompanionDto;
import com.qinghaotech.application.model.dto.CompanionPageDto;
import com.qinghaotech.application.repository.CompanionQueryRepository;
import org.springframework.stereotype.Component;

/**
 * @author Jinx
 */
@Component
public class DefaultCompanionQueryRepository implements CompanionQueryRepository {
    @Override
    public Page<CompanionPageDto> findAll(PageQuery query) {
        return null;
    }

    @Override
    public CompanionDto findById(Integer id) {
        return null;
    }
}
