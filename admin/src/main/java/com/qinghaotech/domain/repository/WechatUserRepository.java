package com.qinghaotech.domain.repository;

import com.qinghaotech.domain.entity.user.WechatUser;
import org.springframework.stereotype.Component;

/**
 * @author Jinx
 */
@Component
public interface WechatUserRepository extends CurdRepository<Integer, WechatUser> {

}
