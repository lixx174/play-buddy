package com.qinghaotech.domain.repository;

import com.qinghaotech.domain.entity.Account;
import com.qinghaotech.domain.entity.User;
import com.qinghaotech.domain.primitive.Applet;

import java.util.Optional;

/**
 * @author Jinx
 */
public interface UserRepository {

    Optional<User> findByApplet(Applet applet);
}
