package com.qinghaotech.domain.repository.query;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Jinx
 */
@Getter
@Builder
public class AuthorityDomainQuery {

    private String name;
    private String permission;
}
