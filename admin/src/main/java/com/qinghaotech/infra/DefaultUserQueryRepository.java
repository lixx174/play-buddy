package com.qinghaotech.infra;

import com.qinghaotech.application.model.dto.UserDto;
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
}
