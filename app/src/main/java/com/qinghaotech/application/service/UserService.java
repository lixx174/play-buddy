package com.qinghaotech.application.service;

import com.qinghaotech.application.model.command.UserProfileModifyCommand;
import com.qinghaotech.application.model.dto.UserDto;
import com.qinghaotech.application.repository.UserQueryRepository;
import com.qinghaotech.domain.entity.User;
import com.qinghaotech.domain.repository.UserRepository;
import com.qinghaotech.domain.service.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.qinghaotech.application.support.SecuritySupport.getUserId;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserQueryRepository userQueryRepository;
    private final UserDomainService userDomainService;

    public UserDto profile() {
        return userQueryRepository.findById(getUserId());
    }

    public void modify(UserProfileModifyCommand command) {
        User user = userRepository.findById(getUserId()).orElseThrow();

        user.rename(command.getNickname(), userDomainService);
        user.changeAvatar(command.getAvatar(), userDomainService);

        userRepository.save(user);
    }
}
