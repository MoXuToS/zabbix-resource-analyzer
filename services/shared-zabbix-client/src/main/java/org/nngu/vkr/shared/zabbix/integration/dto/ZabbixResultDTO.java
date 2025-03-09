package org.nngu.vkr.shared.zabbix.integration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * DTO для представления элементов результата из ответа Zabbix API.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZabbixResultDTO {
    /**
     * Уникальный идентификатор хоста в системе Zabbix.
     * Используется для последующих операций с хостом.
     */
    @Builder.Default
    private String hostid = null;
}
