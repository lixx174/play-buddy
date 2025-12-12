package com.qinghaotech.infra.repository.query;

import com.qinghaotech.application.converter.AuthorityConverter;
import com.qinghaotech.application.converter.RoleConverter;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.RoleDetailDto;
import com.qinghaotech.application.model.dto.RoleSummaryDto;
import com.qinghaotech.application.model.query.RolePageQuery;
import com.qinghaotech.application.repository.RoleQueryRepository;
import com.qinghaotech.infra.repository.persistence.mapper.AuthorityMapper;
import com.qinghaotech.infra.repository.persistence.mapper.RoleAuthorityMapper;
import com.qinghaotech.infra.repository.persistence.mapper.RoleMapper;
import com.qinghaotech.infra.repository.persistence.model.AuthorityDo;
import com.qinghaotech.infra.repository.persistence.model.RoleDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Jinx
 */
@Component
@RequiredArgsConstructor
public class DefaultRoleQueryRepository implements RoleQueryRepository {

    private final RoleMapper roleMapper;
    private final RoleConverter roleConverter;
    private final AuthorityMapper authorityMapper;
    private final AuthorityConverter authorityConverter;
    private final RoleAuthorityMapper roleAuthorityMapper;

    @Override
    public PageReply<RoleSummaryDto> findAll(RolePageQuery query) {
        return null;
    }

    @Override
    public RoleDetailDto findById(Integer id) {
        RoleDo roleDo = roleMapper.selectById(id);
        if (roleDo != null) {
            Collection<AuthorityDo> authorityDos = roleAuthorityMapper.selectByRoleId(roleDo.getId());
        }

        return null;
    }
}
