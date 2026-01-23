package com.qinghaotech.infra.repository.persistence.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jinx
 */
@Getter
@Setter
public class UserDo extends BaseDo {
    private String name;
    private String remark;
    private String status;
}
