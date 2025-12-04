package com.qinghaotech.domain.repository;

import com.qinghaotech.domain.entity.account.Account;

import java.util.Optional;

/**
 * @author Jinx
 */
public interface AccountRepository extends CurdRepository<Integer, Account> {

    Optional<Account> findByUsername(String username);

}
