package com.qinghaotech.application.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author Jinx
 */
@Getter
@Setter
public class RoleDetailDto extends BaseDto {
    private String name;
    private String remark;
    private String status;
    private Collection<AuthorityDto> authorities;
}
