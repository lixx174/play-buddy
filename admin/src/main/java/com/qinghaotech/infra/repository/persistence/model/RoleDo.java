package com.qinghaotech.infra.repository.persistence.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jinx
 */
@Getter
@Setter
public class RoleDo extends BaseDo {
    private String name;
    private String remark;
    private String status;
}
