package com.qinghaotech.application.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.dto.AuthorityDto;

/**
 * @author jinx
 */
public interface AuthorityQueryRepository {

    Page<AuthorityDto> findAll(PageQuery query);

    AuthorityDto findById(Integer id);
}
