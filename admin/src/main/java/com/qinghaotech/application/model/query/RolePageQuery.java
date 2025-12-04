package com.qinghaotech.application.model.query;

import com.qinghaotech.application.model.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jinx
 */
@Getter
@Setter
public class RolePageQuery extends PageQuery {

    /**
     * 名称
     */
    private String name;
}
