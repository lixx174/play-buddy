package com.qinghaotech.infra.repository.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.dto.AuthorityDto;
import com.qinghaotech.application.repository.AuthorityQueryRepository;
import org.springframework.stereotype.Component;

/**
 * @author Jinx
 */
@Component
public class DefaultAuthorityQueryRepository implements AuthorityQueryRepository {
    @Override
    public Page<AuthorityDto> findAll(PageQuery query) {
        return null;
    }

    @Override
    public AuthorityDto findById(Integer id) {
        return null;
    }
}
