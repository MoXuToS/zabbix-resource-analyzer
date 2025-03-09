package org.nngu.vkr.zabbix.api.controller;

import jakarta.validation.Valid;
import org.nngu.vkr.shared.dto.ZabbixApiRequestDTO;
import org.nngu.vkr.zabbix.api.service.ZabbixApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Контроллер по получению данных от забикса
 */
@RestController
public class ZabbixApiController {
    private static final Logger log = LoggerFactory.getLogger(ZabbixApiController.class);

    @Autowired
    private ZabbixApiService zabbixApiService;

    /**
     * Метод для получения данных от Api Zabbix
     *
     * @param request тело запроса
     */
    @PostMapping("/api/v1/getData")
    public ResponseEntity<?> getData(@RequestBody @Valid ZabbixApiRequestDTO request)
    {
        try {
            log.info("Совершается запрос к api Zabbix с методом{}", request.getMethod());
            return ResponseEntity.ok(zabbixApiService.getInfoFromZabbix(request));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", e.getMessage()));
        }
    }
}
