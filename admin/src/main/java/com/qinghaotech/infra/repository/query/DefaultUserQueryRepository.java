package com.qinghaotech.infra.repository.query;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.UserDto;
import com.qinghaotech.application.model.dto.UserSummaryDto;
import com.qinghaotech.application.model.query.UserPageQuery;
import com.qinghaotech.application.repository.UserQueryRepository;
import com.qinghaotech.infra.repository.persistence.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Jinx
 */
@Component
@RequiredArgsConstructor
public class DefaultUserQueryRepository implements UserQueryRepository {

    private final UserMapper userMapper;

    @Override
    public UserDto findById(Integer id) {
        return null;
    }

    @Override
    public PageReply<UserSummaryDto> findAll(UserPageQuery query) {
        return null;
    }
}
