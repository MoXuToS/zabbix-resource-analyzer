package org.nngu.vkr.zabbix.api.service;

import lombok.RequiredArgsConstructor;
import org.nngu.vkr.zabbix.api.feign.ZabbixApiClient;
import org.nngu.vkr.shared.zabbix.integration.dto.ZabbixApiRequestDTO;
import org.nngu.vkr.shared.zabbix.integration.dto.ZabbixApiResponseDTO;
import org.nngu.vkr.shared.zabbix.integration.exception.ZabbixApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Сервис по обращению к данным zabbix через Api
 */
@Service
@RequiredArgsConstructor
public class ZabbixApiService {
    private static final Logger log = LoggerFactory.getLogger(ZabbixApiService.class);
    private final ZabbixApiClient zabbixApiClient;

    public ZabbixApiResponseDTO getInfoFromZabbix(ZabbixApiRequestDTO request) {
        try {
            log.info("Совершается запрос к Api{}", request);
            return zabbixApiClient.sendRequest(request);
        } catch (Exception e) {
            log.error("Ошибка при выполнении запроса к Zabbix API: {}", request);
            log.error(Arrays.toString(e.getStackTrace()));
            throw new ZabbixApiException("Ошибка взаимодействия с Zabbix API", e);
        }
    }
}
