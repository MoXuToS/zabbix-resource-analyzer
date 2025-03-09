package org.nngu.vkr.shared.zabbix.integration.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude
public class ZabbixApiResponseDTO {
    @JsonProperty("jsonrpc")
    private String jsonrpc;

    @JsonProperty("result")
    private Object result;

    @JsonProperty("id")
    private long id;
}
