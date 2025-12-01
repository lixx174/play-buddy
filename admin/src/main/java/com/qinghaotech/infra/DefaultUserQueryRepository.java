package com.qinghaotech.infra;

import com.qinghaotech.application.model.dto.UserDto;
import com.qinghaotech.application.repository.UserQueryRepository;

/**
 * @author Jinx
 */
public class DefaultUserQueryRepository implements UserQueryRepository {
    @Override
    public UserDto findById(Integer id) {
        return null;
    }
}
