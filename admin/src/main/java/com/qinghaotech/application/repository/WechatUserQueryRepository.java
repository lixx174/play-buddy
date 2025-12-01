package com.qinghaotech.application.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.dto.WechatUserDto;

/**
 * @author jinx
 */
public interface WechatUserQueryRepository {

    Page<WechatUserDto> findAll(PageQuery query);

    WechatUserDto findById(Integer id);
}
