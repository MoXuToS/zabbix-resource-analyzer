package org.nngu.vkr.shared.zabbix.integration.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ZabbixParamsDTO {
    @Builder.Default
    private ZabbixFilterDTO filter = null;

    @Builder.Default
    private List<String> output = null;
}
