package org.nngu.vkr.zabbix.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderClassName = "ZabbixApiRequestDTOBuilder")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude
public class ZabbixApiRequestDTO {
    @JsonProperty("jsonrpc")
    private final String jsonrpc = "2.0";

    @JsonProperty("method")
    private String method;

    @JsonProperty("id")
    private String id;

    @JsonProperty("params")
    private Object params;

    public static class ZabbixApiRequestDTOBuilder {
        private String method;
        private String id;
        private Object params;
    }
}
