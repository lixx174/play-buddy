package com.qinghaotech.infra.configuration;

import com.qinghaotech.vendor.WechatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author Jinx
 */
@Configuration
public class HttpExchangeClientConfig {

    @Bean
    public WechatClient defaultEmbeddingClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl("https://api.weixin.qq.com")
                .build();
        RestClientAdapter exchangeAdapter = RestClientAdapter.create(restClient);
        return HttpServiceProxyFactory.builderFor(exchangeAdapter)
                .build()
                .createClient(WechatClient.class);
    }
}
