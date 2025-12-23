package com.qinghaotech.infra.repository.query;

import com.qinghaotech.application.converter.AuthorityConverter;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.AuthorityDetailDto;
import com.qinghaotech.application.model.dto.AuthoritySummaryDto;
import com.qinghaotech.application.model.query.AuthorityPageQuery;
import com.qinghaotech.application.repository.AuthorityQueryRepository;
import com.qinghaotech.infra.repository.persistence.mapper.AuthorityMapper;
import com.qinghaotech.infra.repository.persistence.model.AuthorityDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaQuery;

/**
 * @author Jinx
 */
@Component
@RequiredArgsConstructor
public class DefaultAuthorityQueryRepository implements AuthorityQueryRepository {

    private final AuthorityMapper authorityMapper;
    private final AuthorityConverter authorityConverter;

    @Override
    public PageReply<AuthoritySummaryDto> findAll(AuthorityPageQuery query) {
        var wrapper = lambdaQuery(AuthorityDo.class)
                .eq(StringUtils.hasText(query.getName()), AuthorityDo::getName, query.getName());

        var page = authorityMapper.selectPage(query, wrapper);

        var records = authorityConverter.summaryConvert(page.getRecords());

        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), records);
    }

    @Override
    public AuthorityDetailDto findById(Integer id) {
        var authorityDo = authorityMapper.selectById(id);
        return authorityConverter.detailConvert(authorityDo);
    }
}
