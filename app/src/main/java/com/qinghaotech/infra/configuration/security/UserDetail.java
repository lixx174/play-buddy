package com.qinghaotech.infra.configuration.security;

import com.qinghaotech.domain.entity.User;
import com.qinghaotech.domain.primitive.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Collections;

/**
 * @author jinx
 */
public record UserDetail(User user) implements UserDetails {

    public UserDetail {
        Assert.notNull(user, "Fail to construct UserDetail : user is null");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptySet();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return user.getAccount().getMobile();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getStatus() == Status.FORBIDDEN;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus() == Status.FORBIDDEN;
    }
}
