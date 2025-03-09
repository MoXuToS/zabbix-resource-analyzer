package org.nngu.vkr.shared.feign;

import jakarta.validation.Valid;
import org.nngu.vkr.shared.dto.ZabbixApiRequestDTO;
import org.nngu.vkr.shared.dto.ZabbixApiResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Сервис по обращению к данным zabbix через Api
 * Используется внешними сервисами
 */
@FeignClient(name = "zabbix-integration")
public interface ZabbixIntegrationClient {
    @PostMapping(value = "/api/v1/getData")
    ZabbixApiResponseDTO sendRequest(@RequestBody @Valid ZabbixApiRequestDTO request);
}
