package com.qinghaotech.domain.repository;

import com.qinghaotech.domain.entity.User;

import java.util.Optional;

/**
 * @author Jinx
 */
public interface UserRepository {

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
     * @return 用户数量
     */
    long findCountByNickname(String nickname);

    /**
     * 通过id查询用户
     *
     * @param id 用户id
     * @return 用户领域
     */
    Optional<User> findById(Integer id);

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
     * 保存
     *
     * @param user 用户领域
     */
    void save(User user);
}
