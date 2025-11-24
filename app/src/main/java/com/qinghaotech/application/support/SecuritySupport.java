package com.qinghaotech.application.support;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Jinx
 */
public class SecuritySupport {

    /**
     * 获取当前登录用户id
     *
     * @return userId
     */
    public static Integer getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            var principal = authentication.getPrincipal();
            if (principal instanceof UserDetail userDetail) {
                return userDetail.getId();
            }
        }

        throw new AccessDeniedException("Unsupported authentication principal");
    }
}
