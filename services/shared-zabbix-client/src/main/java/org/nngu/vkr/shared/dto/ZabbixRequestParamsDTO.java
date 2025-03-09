package org.nngu.vkr.shared.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * DTO для параметров запроса к Zabbix API.
 * Используется для построения сложных вложенных структур запроса.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZabbixRequestParamsDTO {
    private ZabbixParamsDTO params;
}
