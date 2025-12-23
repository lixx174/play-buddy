package com.qinghaotech.application.repository;

import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.CompanionDto;
import com.qinghaotech.application.model.dto.CompanionPageDto;

/**
 * @author jinx
 */
public interface CompanionQueryRepository {

    PageReply<CompanionPageDto> findAll(PageQuery query);

    CompanionDto findById(Integer id);
}
