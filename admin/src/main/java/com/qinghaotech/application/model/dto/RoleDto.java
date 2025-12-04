package com.qinghaotech.application.model.dto;

import com.qinghaotech.domain.entity.authority.Authority;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Jinx
 */
@Getter
public class RoleDto {

    private Integer id;
    private String name;
    private String remark;
    private Collection<Authority> authorities;

    public Collection<String> getPermissions() {
        return authorities.stream()
                .map(Authority::getPermission)
                .filter(StringUtils::hasText)
                .collect(Collectors.toSet());
    }
}
