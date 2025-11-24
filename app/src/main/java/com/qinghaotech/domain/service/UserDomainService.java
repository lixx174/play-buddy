package com.qinghaotech.domain.service;

import com.qinghaotech.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class UserDomainService {

    private final UserRepository userRepository;

    /**
     * 昵称是否存在
     *
     * @param nickname 昵称
     * @return true：已存在
     */
    public boolean isNicknameExisted(String nickname) {
        return userRepository.findCountByNickname(nickname) > 0;
    }


}
