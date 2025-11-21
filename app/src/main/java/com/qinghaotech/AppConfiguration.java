package com.qinghaotech;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jinx
 */
@Getter
@Configuration
public class AppConfiguration {

    private final WechatApplet wechatApplet = new WechatApplet();

    @Getter
    @Setter
    public static class WechatApplet{
        /**
         * 微信小程序 appId
         */
        private String appId;
        /**
         * 微信小程序 appSecret
         */
        private String appSecret;
    }
}
