package com.qinghaotech.application.repository;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.AuthorityDetailDto;
import com.qinghaotech.application.model.dto.AuthoritySummaryDto;
import com.qinghaotech.application.model.query.AuthorityPageQuery;

/**
 * @author jinx
 */
public interface AuthorityQueryRepository {

    PageReply<AuthoritySummaryDto> findAll(AuthorityPageQuery query);

    AuthorityDetailDto findById(Integer id);
}
