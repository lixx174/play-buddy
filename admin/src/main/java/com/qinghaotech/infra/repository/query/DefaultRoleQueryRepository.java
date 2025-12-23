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
import com.qinghaotech.infra.tree.TreeBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.stream.Collectors;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaQuery;

/**
 * @author Jinx
 */
@Component
@RequiredArgsConstructor
public class DefaultRoleQueryRepository implements RoleQueryRepository {

    private final RoleMapper roleMapper;
    private final RoleConverter roleConverter;
    private final RoleAuthorityMapper roleAuthorityMapper;

    private final AuthorityMapper authorityMapper;
    private final AuthorityConverter authorityConverter;

    @Override
    public PageReply<RoleSummaryDto> findAll(RolePageQuery query) {
        var wrapper = lambdaQuery(RoleDo.class)
                .eq(StringUtils.hasText(query.getName()), RoleDo::getName, query.getName());

        var page = roleMapper.selectPage(query, wrapper);

        var records = roleConverter.summaryConvert(page.getRecords());

        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), records);
    }

    @Override
    public RoleDetailDto findById(Integer id) {
        RoleDo roleDo = roleMapper.selectById(id);
        if (roleDo != null) {
            var authorityDos = authorityMapper.selectList(null);
            var authorityTreeDtos = authorityConverter.treeConvert(authorityDos);

            var checkedAuthorityIds = roleAuthorityMapper.selectByRoleId(id)
                    .stream()
                    .map(AuthorityDo::getId)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());

            var tree = TreeBuilder.builder()
                    .build(authorityTreeDtos, checkedAuthorityIds);

            RoleDetailDto roleDetailDto = roleConverter.detailConvert(roleDo);
            roleDetailDto.setAuthorities(tree);
            return roleDetailDto;
        }

        return null;
    }
}
