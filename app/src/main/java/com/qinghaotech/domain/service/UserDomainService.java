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


}
