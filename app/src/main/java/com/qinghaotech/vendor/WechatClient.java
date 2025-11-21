package com.qinghaotech.vendor;

import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * @author Jinx
 */
@HttpExchange(url = "https://api.weixin.qq.com")
public interface WechatClient{

    @PostExchange("/sns/jscode2session")
    WechatLoginResponse login(WechatLoginRequest request);
}
