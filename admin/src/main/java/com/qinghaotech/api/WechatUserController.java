package com.qinghaotech.api;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.dto.WechatUserDto;
import com.qinghaotech.application.model.query.WechatUserPageQuery;
import com.qinghaotech.application.service.WechatUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信小程序用户管理API
 *
 * @author Jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/wechat")
public class WechatUserController {

    private final WechatUserService service;

    /**
     * 分页
     *
     * @param query 分页条件
     * @return 微信小程序用户分页信息
     */
    @GetMapping("/page")
    public Result<PageReply<WechatUserDto>> page(WechatUserPageQuery query) {
        return Result.succeed(service.page(query));
    }

    /**
     * 详情
     *
     * @param id 微信小程序用户id
     * @return 微信小程序用户详情
     */
    @GetMapping("/detail")
    public Result<WechatUserDto> detail(Integer id) {
        return Result.succeed(service.detail(id));
    }
}
