package com.qinghaotech.domain.entity.authority;

import org.springframework.util.Assert;

/**
 * @author Jinx
 */
public record AuthorityResource(AuthorityType type, String path) {

    public AuthorityResource {
        Assert.notNull(type, "权限类型为空");
        if (type == AuthorityType.ROUTE) {
            Assert.hasText(path, "权限路由为空");
        }
    }

    public AuthorityResource(String type, String path) {
        this(AuthorityType.valueOf(type), path);
    }
}
