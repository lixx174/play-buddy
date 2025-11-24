package com.qinghaotech.application.repository;

import com.qinghaotech.application.model.dto.UserDto;

/**
 *
 * @author jinx
 */
public interface UserQueryRepository {

    UserDto findById(Integer id);
}
