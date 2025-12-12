package com.qinghaotech.application.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author Jinx
 */
@Getter
@Setter
public class AuthorityTreeDto {

    private Integer id;
    private String name;
    private String remark;
    private Collection<AuthorityTreeDto> authorities;
}
