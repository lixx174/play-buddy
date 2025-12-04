package com.qinghaotech.domain.repository;

import com.qinghaotech.domain.entity.user.User;

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
     * 根据昵称查询用户数量
     *
     * @param nickname 昵称
     * @return 用户领域
     */
    Optional<User> findByNickname(String nickname);

    /**
     * 通过小程序信息查询用户
     *
     * @param applet 小程序信息
     * @return 用户领域
     */
    Optional<User> findByApplet(AppletQuery applet);

    /**
     * 通过凭证信息查询用户
     *
     * @param credential 凭证信息
     * @return 用户领域
     */
    Optional<User> findByCredential(CredentialQuery credential);

    /**
     * 昵称是否存在
     *
     * @param nickname 昵称
     * @return true：存在
     */
    default boolean isNicknameExisted(String nickname) {
        return findByNickname(nickname).isPresent();
    }
}
