package com.qinghaotech.infra.repository.query;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.UserDto;
import com.qinghaotech.application.model.dto.UserSummaryDto;
import com.qinghaotech.application.model.query.UserPageQuery;
import com.qinghaotech.application.repository.UserQueryRepository;
import org.springframework.stereotype.Component;

/**
 * @author Jinx
 */
@Component
public class DefaultUserQueryRepository implements UserQueryRepository {
    @Override
    public UserDto findById(Integer id) {
        return null;
    }

    @Override
    public PageReply<UserSummaryDto> findAll(UserPageQuery query) {
        return null;
    }
}
