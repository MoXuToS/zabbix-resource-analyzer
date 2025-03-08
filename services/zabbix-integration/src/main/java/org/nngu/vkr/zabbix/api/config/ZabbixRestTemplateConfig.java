package org.nngu.vkr.zabbix.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class ZabbixRestTemplateConfig {

    @Value("${zabbix.api.readTimeout:30}")
    private int readTimeout;

    @Value("${zabbix.api.connectTimeout:10}")
    private int connectTimeout;

    @Bean
    public RestTemplate zabbixRestTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofSeconds(connectTimeout))
                .setReadTimeout(Duration.ofSeconds(readTimeout))
                .additionalMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();
    }
}