package com.qinghaotech.infra.repository.persistence.model;

import com.qinghaotech.domain.entity.authority.AuthorityResource;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jinx
 */
@Getter
@Setter
public class AuthorityDo extends BaseDo {
    private Integer parentId;
    private String name;
    private AuthorityResource resource;
    private String permission;
    private Integer sortNo;
}
