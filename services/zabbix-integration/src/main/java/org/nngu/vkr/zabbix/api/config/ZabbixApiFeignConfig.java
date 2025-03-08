package org.nngu.vkr.zabbix.api.config;

import feign.Request;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZabbixApiFeignConfig {
    @Autowired
    ZabbixClientConfiguration zabbixClient;

    @Bean
    public RequestInterceptor zabbixApiRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.uri(zabbixClient.getServerUrl());
            requestTemplate.header("Content-Type", "application/json-rpc");
            requestTemplate.header("Authorization", "Bearer " + zabbixClient.getApiKey());
        };
    }

    @Bean
    Request.Options zabbixFeignOptions() {
        return new Request.Options(
                zabbixClient.getConnectTimeout(),
                zabbixClient.getReadTimeout()
        );
    }
}
