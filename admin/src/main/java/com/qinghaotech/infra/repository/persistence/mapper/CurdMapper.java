package com.qinghaotech.infra.repository.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.PageQuery;

/**
 * @author Jinx
 */
public interface CurdMapper<Entity> extends BaseMapper<Entity> {

    default Page<Entity> selectPage(PageQuery pageQuery, Wrapper<Entity> queryWrapper) {
        Number current = pageQuery.getCurrent() == null ? 1 : pageQuery.getCurrent();
        Number size = pageQuery.getSize() == null ? 1 : pageQuery.getSize();

        Page<Entity> page = Page.of(current.longValue(), size.longValue());
        return selectPage(page, queryWrapper);
    }
}
