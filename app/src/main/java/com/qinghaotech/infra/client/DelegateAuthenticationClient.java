package com.qinghaotech.infra.client;

import com.qinghaotech.application.client.AuthenticationClient;
import com.qinghaotech.vendor.WechatClient;

/**
 * @author Jinx
 */
public class DelegateAuthenticationClient implements AuthenticationClient {

    private final WechatClient wechatClient;

}
