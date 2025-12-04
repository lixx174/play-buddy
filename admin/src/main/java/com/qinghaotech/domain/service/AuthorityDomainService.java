package com.qinghaotech.domain.service;

import com.qinghaotech.domain.entity.authority.Authority;
import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Jinx
 */
@Component
@RequiredArgsConstructor
public class AuthorityDomainService {

    private final AuthorityRepository authorityRepository;

    public void remove(Collection<Authority> authorities) {
        if (authorities != null) {
            for (Authority authority : authorities) {
                Collection<Authority> children = authorityRepository.findByPid(authority.getId());
                if (children.isEmpty()) {
                    authorityRepository.remove(authority);
                } else {
                    throw new UnprocessableException("该权限有子节点，不能删除。");
                }
            }
        }
    }
}
