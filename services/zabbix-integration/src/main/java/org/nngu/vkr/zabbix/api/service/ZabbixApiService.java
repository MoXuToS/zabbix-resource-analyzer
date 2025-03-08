package org.nngu.vkr.zabbix.api.service;

import lombok.RequiredArgsConstructor;
import org.nngu.vkr.zabbix.api.config.ZabbixClientConfiguration;
import org.nngu.vkr.zabbix.api.config.ZabbixRestTemplateConfig;
import org.nngu.vkr.zabbix.api.dto.ZabbixApiRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * Сервис по обращению к данным zabbix через Api
 */
@Service
@RequiredArgsConstructor
public class ZabbixApiService {
    private final ZabbixClientConfiguration zabbixConfig;

    @Qualifier("zabbixRestTemplate")
    private final RestTemplate zabbixRestTemplate;
    private static final Logger log = LoggerFactory.getLogger(ZabbixApiService.class);

    public String sendRequest(ZabbixApiRequestDTO request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType("application/json-rpc"));

        String authToken = zabbixConfig.getApiKey();
        String authHeader = "Bearer " +  authToken;
        httpHeaders.add("Authorization", authHeader);

        log.debug("Sending request to Zabbix: URL={}, Headers={}, Body={}",
                zabbixConfig.getServerApiUrl(), httpHeaders, request);

        HttpEntity<ZabbixApiRequestDTO> entity = new HttpEntity<>(request, httpHeaders);
        ResponseEntity<String> response = zabbixRestTemplate.postForEntity(
                zabbixConfig.getServerApiUrl(),entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Zabbix API request failed: " + response.getStatusCode());
        }
    }
}
