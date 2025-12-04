package com.qinghaotech.domain.repository;

import com.qinghaotech.domain.entity.user.User;
import com.qinghaotech.domain.repository.query.CredentialQuery;

import java.util.Optional;

/**
 * @author Jinx
 */
public interface UserRepository extends CurdRepository<Integer, User> {

    /**
     * 查询用户数量
     *
     * @return 用户数量
     */
    long findCount();

    /**
     * 根据账号查询用户
     *
     * @param username 账号
     * @return 用户领域
     */
    Optional<User> findByUsername(String username);

    /**
     * 通过凭证信息查询用户
     *
     * @param credential 凭证信息
     * @return 用户领域
     */
    Optional<User> findByCredential(CredentialQuery credential);
}
