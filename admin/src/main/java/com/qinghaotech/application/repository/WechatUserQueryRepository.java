package com.qinghaotech.application.repository;

import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.WechatUserDto;

/**
 * @author jinx
 */
public interface WechatUserQueryRepository {

    PageReply<WechatUserDto> findAll(PageQuery query);

    WechatUserDto findById(Integer id);
}
