package com.qinghaotech.application.service;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.ModifyWechatUserCommand;
import com.qinghaotech.application.model.dto.WechatUserDto;
import com.qinghaotech.application.model.query.WechatUserPageQuery;
import com.qinghaotech.application.repository.WechatUserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class WechatUserService {

    private final WechatUserQueryRepository wechatUserQueryRepository;

    public PageReply<WechatUserDto> page(WechatUserPageQuery query) {
        return PageReply.of(wechatUserQueryRepository.findAll(query));
    }

    public WechatUserDto detail(Integer id) {
        return wechatUserQueryRepository.findById(id);
    }

    public void modify(ModifyWechatUserCommand command) {
    }
}
