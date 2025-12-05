package com.qinghaotech.application.model.dto;

import com.qinghaotech.domain.entity.authority.Authority;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author Jinx
 */
@Getter
@Setter
public class AuthorityDto {

    private Integer id;
    private String name;
    private String remark;
    private Collection<Authority> authorities;
}
