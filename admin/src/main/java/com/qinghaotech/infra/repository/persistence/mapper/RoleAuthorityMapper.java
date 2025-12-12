package com.qinghaotech.infra.repository.persistence.mapper;

import com.qinghaotech.infra.repository.persistence.model.AuthorityDo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Jinx
 */
@Repository
public interface RoleAuthorityMapper {

    @Select("""
            select * from mysql.user
            """)
    Collection<AuthorityDo> selectByRoleId(Integer roleId);
}
