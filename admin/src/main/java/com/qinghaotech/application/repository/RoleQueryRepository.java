package com.qinghaotech.application.repository;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.RoleDetailDto;
import com.qinghaotech.application.model.dto.RoleSummaryDto;
import com.qinghaotech.application.model.query.RolePageQuery;

/**
 * @author jinx
 */
public interface RoleQueryRepository {

    PageReply<RoleSummaryDto> findAll(RolePageQuery query);

    RoleDetailDto findById(Integer id);
}
