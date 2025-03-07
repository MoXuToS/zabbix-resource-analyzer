package org.nngu.vkr.zabbix.api.controller;

import lombok.RequiredArgsConstructor;
import org.nngu.vkr.zabbix.api.dto.ZabbixApiRequestDTO;
import org.nngu.vkr.zabbix.api.service.ZabbixApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер по получению данных от забикса
 */
@RestController
@RequiredArgsConstructor
public class ZabbixApiController {
    private final ZabbixApiService zabbixApiService;
    private static final Logger log = LoggerFactory.getLogger(ZabbixApiController.class);


    /**
     * Метод для сохранения полученных метрик в базу данных
     * @param request тело запроса
     */
    @PostMapping("/api/getHostId")
    public ResponseEntity<String> getHostID(@RequestBody ZabbixApiRequestDTO request)
    {

        try {
            String response = zabbixApiService.sendRequest(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Ошибка в обработке запроса к Api Zabbix", e);
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
