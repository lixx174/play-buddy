package com.qinghaotech.infra.repository;

import com.qinghaotech.domain.entity.user.WechatUser;
import com.qinghaotech.domain.repository.WechatUserRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * @author Jinx
 */
@Component
public class DefaultWechatUserRepository implements WechatUserRepository {
    @Override
    public Optional<WechatUser> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Collection<WechatUser> findByIds(Set<Integer> integers) {
        return null;
    }

    @Override
    public void save(WechatUser wechatUser) {

    }

    @Override
    public void remove(WechatUser wechatUser) {

    }
}
