package org.nngu.vkr.metric.provider.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.nngu.vkr.shared.dto.*;
import org.nngu.vkr.shared.feign.ZabbixIntegrationClient;
import org.nngu.vkr.shared.exception.ZabbixApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Сервис по получению данных из Zabbix
 */
@Service
@RequiredArgsConstructor
public class ZabbixInfoService {
    private static final Logger log = LoggerFactory.getLogger(ZabbixInfoService.class);
    private final ZabbixIntegrationClient zabbixClient;
    private final ObjectMapper objectMapper;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     * Метод для получения id ВМ в забиксе
     * @param virtualMachineHostname Наименование виртуальной машины
     */
    public String getHostId(String virtualMachineHostname) {
        String method = "host.get";
        long id = System.currentTimeMillis() + random.nextInt(1000);
        Object params = ZabbixRequestParamsDTO.builder()
                .params(ZabbixParamsDTO.builder()
                        .filter(ZabbixFilterDTO.builder()
                                .host(List.of(virtualMachineHostname)) // Указываем хост
                                .build())
                        .output(List.of("hostid")) // Указываем возвращаемый параметр
                        .build());
        // Создаем DTO запроса к Api Zabbix
        ZabbixApiRequestDTO request = ZabbixApiRequestDTO.builder()
                .method(method)
                .id(id)
                .params(params).build();
        try {
            ZabbixApiResponseDTO response = zabbixClient.sendRequest(request);
            try {
                List<ZabbixResultDTO> result = objectMapper.convertValue(
                        response.getResult(),
                        new TypeReference<List<ZabbixResultDTO>>() {});
                if(!result.isEmpty()) {
                    return result.getFirst().getHostid();
                }
                else {
                    log.error("Zabbix Api прислал пустой ответ");
                    throw new RuntimeException("Хост был не найден");
                }
            } catch (IllegalArgumentException e) {
                log.error("Ошибка преобразования ответа от Api Zabbix");
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new ZabbixApiException("Ошибка взаимодействия с Zabbix API", e);
        }
    }
}
