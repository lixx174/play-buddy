package com.qinghaotech.application.service;

import com.qinghaotech.application.model.command.ModifyUserCommand;
import com.qinghaotech.application.model.dto.UserDto;
import com.qinghaotech.application.repository.UserQueryRepository;
import com.qinghaotech.domain.entity.user.User;
import com.qinghaotech.domain.repository.UserRepository;
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

    public UserDto profile() {
        return userQueryRepository.findById(getUserId());
    }

    public void modify(ModifyUserCommand command) {
        User user = userRepository.findById(getUserId()).orElseThrow();

        user.rename(command.getNickname(), userRepository::isNicknameExisted);
        // FIXME 色图校验
        user.changeAvatar(command.getAvatar(), avatar -> true);

        userRepository.save(user);
    }
}
