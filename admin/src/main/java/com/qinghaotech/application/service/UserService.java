package com.qinghaotech.application.service;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.CreateUserCommand;
import com.qinghaotech.application.model.command.ModifyUserCommand;
import com.qinghaotech.application.model.dto.UserDto;
import com.qinghaotech.application.model.dto.UserSummaryDto;
import com.qinghaotech.application.model.query.UserPageQuery;
import com.qinghaotech.application.repository.UserQueryRepository;
import com.qinghaotech.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static com.qinghaotech.application.support.SecuritySupport.getUserId;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class UserService {


    private final UserQueryRepository userQueryRepository;
    private final UserRepository userRepository;

    public PageReply<UserSummaryDto> page(UserPageQuery query) {
        return userQueryRepository.findAll(query);
    }


    public UserDto detail(Integer id) {
        return null;
    }

    public void create(CreateUserCommand command) {

    }

    public void modify(ModifyUserCommand command) {

    }

    public void remove(Collection<Integer> ids) {

    }

    public UserDto profile() {
        return userQueryRepository.findById(getUserId());
    }

}
