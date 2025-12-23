package com.qinghaotech.application.repository;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.UserDto;
import com.qinghaotech.application.model.dto.UserSummaryDto;
import com.qinghaotech.application.model.query.UserPageQuery;

/**
 * @author jinx
 */
public interface UserQueryRepository {

    UserDto findById(Integer id);

    PageReply<UserSummaryDto> findAll(UserPageQuery query);
}
