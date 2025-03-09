package org.nngu.vkr.shared.zabbix.integration.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ZabbixFilterDTO {
    @Builder.Default
    private List<String> host = null;
}
