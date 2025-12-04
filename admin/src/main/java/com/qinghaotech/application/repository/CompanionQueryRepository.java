package com.qinghaotech.application.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.dto.CompanionDto;
import com.qinghaotech.application.model.dto.CompanionPageDto;

/**
 * @author jinx
 */
public interface CompanionQueryRepository {

    Page<CompanionPageDto> findAll(PageQuery query);

    CompanionDto findById(Integer id);
}
