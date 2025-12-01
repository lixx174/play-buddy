package com.qinghaotech.infra;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.dto.WechatUserDto;
import com.qinghaotech.application.repository.WechatUserQueryRepository;

/**
 * @author Jinx
 */
public class DefaultWechatUserQueryRepository implements WechatUserQueryRepository {
    @Override
    public Page<WechatUserDto> findAll(PageQuery query) {
        return null;
    }

    @Override
    public WechatUserDto findById(Integer id) {
        return null;
    }
}
